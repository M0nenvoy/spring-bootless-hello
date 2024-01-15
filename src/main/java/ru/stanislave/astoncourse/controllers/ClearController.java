package ru.stanislave.astoncourse.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stanislave.astoncourse.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping("/clear")
public class ClearController {
    @DeleteMapping
    public String clear() {
        try (Connection con = DbUtil.connect()) {
            try {
                con.setAutoCommit(false);
                con.createStatement().executeUpdate("DELETE FROM customer");
                con.createStatement().executeUpdate("DELETE FROM employee");
                con.createStatement().executeUpdate("DELETE FROM project");
                con.createStatement().executeUpdate("DELETE FROM position");
                // ProjectEmployee очистится каскадно
                con.commit();
                return "ok";
            } catch (SQLException e) {
                con.rollback();
                return "An error has occurred: + " + e.getMessage();
            }
        } catch (SQLException e) {
            return "An error has occurred: " + e.getMessage();
        }
    }
}
