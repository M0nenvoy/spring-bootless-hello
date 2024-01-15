package ru.stanislave.astoncourse.models;

import java.sql.Date;

public class Project {
    private int id;
    private String name;
    private Date deadline;

    public Project() {

    }

    public Project(int id, String name, Date deadline) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getName() {
        return name;
    }
}
