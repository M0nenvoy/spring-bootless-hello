package ru.stanislave.astoncourse.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import ru.stanislave.astoncourse.DbUtil;
import ru.stanislave.astoncourse.factory.RsFactory;
import ru.stanislave.astoncourse.models.Position;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
public abstract class CrudController<T> {
    @GetMapping("/{id}")
    public String getById(@PathVariable int id) {
        try (Connection con = DbUtil.connect()) {
            final Statement st = con.createStatement();
            final ResultSet rs = st.executeQuery(queryGetById(id));
            if (!rs.next()) {
                return "Not found";
            }
            Object obj = createModelFactory().create(rs);
            return new ObjectMapper().writeValueAsString(obj);
        } catch (SQLException | JsonProcessingException e) {
            return wrapErrorMessage(e.getMessage());
        }
    }

    @GetMapping
    public String getAll() {
        try (Connection con = DbUtil.connect()) {
            final Statement st = con.createStatement();
            final ResultSet rs = st.executeQuery(queryGetAll());
            final ObjectMapper mapper = new ObjectMapper();
            final RsFactory factory = createModelFactory();
            List<Object> result = new ArrayList<>();
            while (rs.next()) {
                result.add(factory.create(rs));
            }
            return new ObjectMapper().writeValueAsString(result);
        } catch (SQLException | JsonProcessingException e) {
            return wrapErrorMessage(e.getMessage());
        }
    }

    @PostMapping
    public String create(@RequestBody T t) {
        try (Connection con = DbUtil.connect()) {
            final Statement st = con.createStatement();
            st.execute(queryCreate(t));
            return "ok";
        } catch (SQLException e) {
            return wrapErrorMessage(e.getMessage());
        }
    }

    @PutMapping
    public String update(@RequestBody T t) {
        try (Connection con = DbUtil.connect()) {
            int affected = con.createStatement()
                    .executeUpdate(queryUpdate(t));
            if (affected == 0) {
                return "Nothing to update";
            }

            return "ok";
        } catch (SQLException e) {
            return wrapErrorMessage(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        try (Connection con = DbUtil.connect()) {
            int affected = con.createStatement()
                    .executeUpdate(queryDelete(id));
            if (affected == 0) {
                return String.format("No element with such id (%d)", id);
            }

            return "ok";
        } catch (SQLException e) {
            return wrapErrorMessage(e.getMessage());
        }
    }

    @DeleteMapping("/clear")
    public String clear() {
        try (Connection con = DbUtil.connect()) {
            con.createStatement()
                    .executeUpdate(queryClear());
            return "ok";
        } catch (SQLException e) {
            return wrapErrorMessage(e.getMessage());
        }
    }

    public static String wrapErrorMessage(String message) {
        return "An error has occurred: " + message;
    }

    protected abstract String queryGetById(int id);

    protected abstract String queryGetAll();

    protected abstract String queryCreate(T t);

    protected abstract String queryUpdate(T t);

    protected abstract String queryDelete(int id);

    protected abstract String queryClear();

    protected abstract RsFactory createModelFactory();
}
