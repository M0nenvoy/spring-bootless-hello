package ru.stanislave.astoncourse.models;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
    private final int id;
    private final int positionId;
    private final String name;

    public Employee(int id, int positionId, String name) {
        this.id = id;
        this.positionId = positionId;
        this.name = name;
    }

    public Employee() {
        this(0, 0, "");
    }

    public static Employee fromResultSet(ResultSet rs) {
        try {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int positionId = rs.getInt(3);

            return new Employee(id, positionId, name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getId() {
        return id;
    }

    public int getPositionId() {
        return positionId;
    }

    public String getName() {
        return name;
    }
}
