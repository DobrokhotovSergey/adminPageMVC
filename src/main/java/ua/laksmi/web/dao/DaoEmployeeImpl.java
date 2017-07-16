package ua.laksmi.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import ua.laksmi.web.domain.tables.employee.Employee;
import ua.laksmi.web.jdbc.EmployeeRowMapperImpl;
import ua.laksmi.web.utils.Constants;

import javax.sql.DataSource;
import java.sql.Types;
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
        sb.append("select a.user_role_id, a.userName, a.role,b.password, b.enabled, b.firstname, b.lastname, b.position from ");
        sb.append(Constants.TABLE_USER_ROLES);
        sb.append(" a join ");
        sb.append(Constants.TABLE_USERS);
        sb.append(" b on a.userName = b.userName\n");
        List<Employee> list = null;
        try{
            list = jdbcTemplate.query(sb.toString(), new EmployeeRowMapperImpl());
        }catch (Exception ex){
            System.out.println(ex);
        }
        return list;
    }

    public Employee createEmployee(Employee employee) {
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO ");
        sb.append(Constants.TABLE_USERS);
        sb.append(" (username,password,enabled,firstname,lastname)\n");
        sb.append("values (?,?,?,?,?);\n");
        sb.append("insert into ");
        sb.append(Constants.TABLE_USER_ROLES);
        sb.append("(username, role)\n");
        sb.append("values(?,?) \n");
        try{
            jdbcTemplate.update(sb.toString(), new Object[]{employee.getUsername(), employee.getPassword(), 1,employee.getFirstname(),employee.getLastname(),
                    employee.getUsername(), employee.getRole()});
        }catch (Exception e){
            System.out.println(e);
        }

        return findByUsername(employee.getUsername());
    }

    public Employee editEmployee(Employee employee) {

        System.out.println(employee);
        boolean isUpdated = false;
        StringBuilder sb = new StringBuilder();
        sb.append("update ");
        sb.append(Constants.TABLE_USERS);
        sb.append(" set firstname =?, lastname=?, position=? where username =? \n");

        try{
            jdbcTemplate.update(sb.toString(), new Object[]{employee.getFirstname(), employee.getLastname(), employee.getPosition(), employee.getUser()
            });
         }catch (Exception ex){
            System.out.println(ex);
        }
        StringBuilder sb2= new StringBuilder();
        sb2.append("update ");
        sb2.append(Constants.TABLE_USER_ROLES);
        sb2.append(" set role =? ");
        sb2.append(" where username=? ");
        try{
            jdbcTemplate.update(sb2.toString(), new Object[]{
                    employee.getRole(), employee.getUser()
            });
        }catch (Exception ex){
            System.out.println(ex);
        }
        return findByUsername(employee.getUser());
    }

    public boolean deleteEmployee() {
        return false;
    }

    public Employee findByUsername(String userName) {
        StringBuilder sb = new StringBuilder();
        sb.append("select a.user_role_id, a.userName, a.role,b.password, b.enabled, b.firstname, b.lastname, b.position from ");
        sb.append(Constants.TABLE_USER_ROLES);
        sb.append(" a join ");
        sb.append(Constants.TABLE_USERS);
        sb.append(" b on a.userName = b.userName\n");
        sb.append("where a.userName = ?");
        Employee employee = null;
//        System.out.println(sb.toString());
        try {
            employee = jdbcTemplate.queryForObject(sb.toString(), new EmployeeRowMapperImpl(), userName);
        }catch (Exception ex){
            System.out.println(ex);


        }
        System.out.println(employee);
        return employee;
    }




    @Override
    public boolean uploadUserImage(MultipartFile multipartFile, String user) {

        boolean isSaved = false;
        StringBuilder sb = new StringBuilder();
        sb.append("update ");
        sb.append(Constants.TABLE_USERS);
        sb.append(" set avatar = ? where userName = ?");

        try{
            LobHandler lobHandler = new DefaultLobHandler();
            jdbcTemplate.update(sb.toString(),
                    new Object[] {
                            new SqlLobValue(multipartFile.getInputStream(), (int)multipartFile.getSize(), lobHandler),
                            user},
                    new int[] {Types.BLOB, Types.VARCHAR} );
            isSaved = true;
        }catch (Exception ex){
            System.out.println(ex);
        }
        return isSaved;
    }

    @Override
    public byte[] getAvatar(String userName) {
        StringBuilder sb = new StringBuilder();
        sb.append("select avatar from ");
        sb.append(Constants.TABLE_USERS);
        sb.append(" where username = ?");
        byte[] image = new byte[0];
        try {
            image = jdbcTemplate.queryForObject(
                    sb.toString(),
                    (rs, rowNum) -> rs.getBytes(1), userName);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return image;
    }

    @Override
    public boolean updateProfile(Employee employee) {
        System.out.println(employee);
        boolean isUpdated = false;
        StringBuilder sb = new StringBuilder();
        sb.append("update ");
        sb.append(Constants.TABLE_USERS);
        sb.append(" set firstname =?, lastname=?, position=? where username =?");
        try{
            jdbcTemplate.update(sb.toString(), new Object[]{employee.getFirstname(), employee.getLastname(), employee.getPosition(), employee.getUsername()});
            isUpdated = true;
        }catch (Exception ex){
            System.out.println(ex);
        }
        return isUpdated;
    }

}
