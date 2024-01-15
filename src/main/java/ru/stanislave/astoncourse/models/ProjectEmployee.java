package ru.stanislave.astoncourse.models;

public class ProjectEmployee {
    private int id;
    private int projectId;
    private int employeeId;

    public ProjectEmployee() {

    }

    public ProjectEmployee(int id, int projectId, int employeeId) {
        this.id = id;
        this.projectId = projectId;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getProjectId() {
        return projectId;
    }
}
