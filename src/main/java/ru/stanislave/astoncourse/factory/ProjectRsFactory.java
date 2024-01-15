package ru.stanislave.astoncourse.factory;

import ru.stanislave.astoncourse.factory.RsFactory;
import ru.stanislave.astoncourse.models.Project;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectRsFactory implements RsFactory {
    @Override
    public Object create(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        String name = rs.getString(2);
        Date deadline = rs.getDate(3);

        return new Project(id, name, deadline);
    }
}
