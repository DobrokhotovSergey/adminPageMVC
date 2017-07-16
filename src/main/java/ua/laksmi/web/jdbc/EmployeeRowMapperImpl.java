package ua.laksmi.web.jdbc;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ua.laksmi.web.domain.tables.employee.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dobriks on 20.04.2017.
 */
public class EmployeeRowMapperImpl implements RowMapper<Employee> {
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setUsername(rs.getString("userName"));
        employee.setRole(rs.getString("role"));
        employee.setStatus(rs.getBoolean("enabled"));
        employee.setId(rs.getInt("user_role_id"));
        employee.setFirstname(rs.getString("firstname"));
        employee.setLastname(rs.getString("lastname"));
        employee.setPassword(rs.getString("password"));
        employee.setPosition(rs.getString("position"));

        List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
        auths.add(new SimpleGrantedAuthority(rs.getString("role")));
        employee.setList(auths);

        return employee;
    }
}
