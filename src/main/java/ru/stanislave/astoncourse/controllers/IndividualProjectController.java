package ru.stanislave.astoncourse.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stanislave.astoncourse.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

@RestController
@RequestMapping("/individual-project")
public class IndividualProjectController {
    private final static int individualProjectsStandardLengthInDays = 7;
    @PostMapping("/{name}")
    public String createIndividualProject(@PathVariable String name) {
        try (Connection con = DbUtil.connect()) {
            con.setAutoCommit(false);
            con.createStatement().executeUpdate(String.format("INSERT INTO customer (name) VALUES ('%s')", name));
            con.createStatement().executeUpdate(String.format("INSERT INTO project (name, deadline) VALUES ('%s', '%s')", name, LocalDate.now().plusDays(individualProjectsStandardLengthInDays)));
            con.commit();
            return "ok";
        } catch (SQLException e) {
            return "An error has occurred: " + e.getMessage();
        }
    }
}
