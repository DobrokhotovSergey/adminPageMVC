package ua.laksmi.web.jdbc;

import org.springframework.jdbc.core.RowMapper;
import ua.laksmi.web.domain.tables.employee.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dobriks on 20.04.2017.
 */
public class EmployeeRowMapperImpl implements RowMapper<Employee> {
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setUserName(rs.getString("userName"));
        employee.setRole(rs.getString("role"));
        employee.setStatus(rs.getBoolean("enabled"));
        employee.setId(rs.getInt("user_role_id"));
        return employee;
    }
}
