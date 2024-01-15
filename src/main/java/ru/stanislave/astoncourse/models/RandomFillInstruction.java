package ru.stanislave.astoncourse.models;

import java.util.List;

public class RandomFillInstruction {
    private int customerNumber;
    private int employeeNumber;
    private int positionNumber;
    private int projectNumber;
    private int positionMaxSalary;
    private int projectMaxDaysSinceDeadline;
    private List<String> customerNamePool;
    private List<String> employeeNamePool;
    private List<String> projectNamePool;
    private List<String> positionNamePool;

    public RandomFillInstruction() {

    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public int getPositionMaxSalary() {
        return positionMaxSalary;
    }

    public int getPositionNumber() {
        return positionNumber;
    }

    public int getProjectMaxDaysSinceDeadline() {
        return projectMaxDaysSinceDeadline;
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    public List<String> getCustomerNamePool() {
        return customerNamePool;
    }

    public List<String> getEmployeeNamePool() {
        return employeeNamePool;
    }

    public List<String> getPositionNamePool() {
        return positionNamePool;
    }

    public List<String> getProjectNamePool() {
        return projectNamePool;
    }
}
