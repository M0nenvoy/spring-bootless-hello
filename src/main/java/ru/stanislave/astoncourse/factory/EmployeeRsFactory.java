package ru.stanislave.astoncourse.factory;

import ru.stanislave.astoncourse.models.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRsFactory implements RsFactory {
    @Override
    public Object create(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        String name = rs.getString(2);
        int positionId = rs.getInt(3);

        return new Employee(id, positionId, name);
    }
}
