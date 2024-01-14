package ru.stanislave.astoncourse.factory;

import ru.stanislave.astoncourse.models.ProjectEmployee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectEmployeeFactory implements RsFactory {
    @Override
    public Object create(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        int projectId = rs.getInt(2);
        int employeeId = rs.getInt(3);

        return new ProjectEmployee(id, projectId, employeeId);
    }
}
