package ru.stanislave.astoncourse.models;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Position {
    private final int id;
    private final int salary;
    private final String title;

    public Position() {
        this(0, "", 0);
    }

    public Position(int id, String title, int salary) {
        this.id = id;
        this.title = title;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public String getTitle() {
        return title;
    }
}
