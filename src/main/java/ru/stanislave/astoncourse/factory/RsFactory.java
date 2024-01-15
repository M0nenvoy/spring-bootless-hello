package ru.stanislave.astoncourse.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RsFactory {
    Object create(ResultSet rs) throws SQLException;
}
