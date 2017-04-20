package ua.laksmi.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.laksmi.web.domain.tables.employee.Employee;
import ua.laksmi.web.jdbc.EmployeeRowMapperImpl;
import ua.laksmi.web.utils.Constants;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Dobriks on 20.04.2017.
 */
@Repository("daoEmployee")
public class DaoEmployeeImpl implements DaoEmployee {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public DaoEmployeeImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource) ;
    }

    public List<Employee> getListEmployee() {
        StringBuilder sb = new StringBuilder();
        sb.append("select a.user_role_id, a.userName, a.role, b.enabled from ");
        sb.append(Constants.TABLE_USER_ROLES);
        sb.append(" a join ");
        sb.append(Constants.TABLE_USERS);
        sb.append(" b on a.userName = b.userName");
        List<Employee> list = null;
        try{
            list = jdbcTemplate.query(sb.toString(), new EmployeeRowMapperImpl());
        }catch (Exception ex){
            System.out.println(ex);
        }
        return list;
    }

    public boolean createEmployee(Employee employee) {
        return false;
    }

    public Employee editEmployee(Employee employee) {
        return null;
    }

    public boolean deleteEmployee() {
        return false;
    }
}
