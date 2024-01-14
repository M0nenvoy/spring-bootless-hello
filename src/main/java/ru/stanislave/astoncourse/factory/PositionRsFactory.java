package ru.stanislave.astoncourse.factory;

import ru.stanislave.astoncourse.models.Position;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionRsFactory implements RsFactory {
    @Override
    public Object create(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        String title = rs.getString(2);
        int salary = rs.getInt(3);

        return new Position(id, title, salary);
    }
}
