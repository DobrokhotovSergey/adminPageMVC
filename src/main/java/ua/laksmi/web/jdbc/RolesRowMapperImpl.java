package ua.laksmi.web.jdbc;

import org.springframework.jdbc.core.RowMapper;
import ua.laksmi.web.domain.roles.Roles;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dobriks on 10.03.2017.
 */
public class RolesRowMapperImpl implements RowMapper<Roles> {
    public Roles mapRow(ResultSet resultSet, int i) throws SQLException {
        Roles role = new Roles();
        role.setId(resultSet.getInt("id"));
        role.setDateCreated(resultSet.getDate("dateCreated"));
        role.setHashPsw(resultSet.getBytes("hashPsw"));
        role.setLogin(resultSet.getString("login"));
        role.setRole(resultSet.getString("role"));
        return role;
    }
}
