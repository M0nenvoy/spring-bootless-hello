package ru.stanislave.astoncourse.factory;

import ru.stanislave.astoncourse.models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRsFactory implements RsFactory {
    @Override
    public Object create(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        String name = rs.getString(2);

        return new Customer(id, name);
    }
}
