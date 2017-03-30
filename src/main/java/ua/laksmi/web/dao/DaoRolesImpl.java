package ua.laksmi.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.laksmi.web.domain.authorization.AuthorizationUser;
import ua.laksmi.web.domain.roles.Roles;
import ua.laksmi.web.jdbc.RolesRowMapperImpl;
import ua.laksmi.web.utils.Constants;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dobriks on 10.03.2017.
 */

@Component(value = "daoRoles")
public class DaoRolesImpl implements DaoRoles {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DaoRolesImpl(DataSource dataSource) {
       jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean createRole(Roles roles) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into\n");
        sb.append(Constants.TABLE_ROLES);
        sb.append("\n(login, hashPsw,role, dateCreated)\n");
        sb.append("values (?,?,?,CURRENT_TIMESTAMP)");
        boolean isCreated = false;
        try{
            jdbcTemplate.update(sb.toString(),new Object[]{roles.getLogin(), roles.getHashPsw(), roles.getRole()});
            isCreated = true;
        }catch(Exception ex){
            System.out.println(ex);
        }

        return isCreated;
    }

    public boolean deleteRole(int id) {
        return false;
    }

    public List<Roles> getListRoles() {
        StringBuilder sb = new StringBuilder();

        sb.append("select id, login, hashPsw, role, dateCreated from\n");
        sb.append(Constants.TABLE_ROLES);
        sb.append("\n");
        List<Roles> listRoles = new ArrayList<Roles>();
        try{
            listRoles = jdbcTemplate.query(sb.toString(), new RolesRowMapperImpl());
        }catch (DataAccessException ex){
            System.out.println(ex);
        }



        return listRoles;
    }

    public boolean checkAuthorization(AuthorizationUser authorizationUser) {
        StringBuilder sb = new StringBuilder();
        sb.append("select id, login, hashPsw, role, dateCreated from\n");
        sb.append(Constants.TABLE_ROLES);
        sb.append("\n");
        sb.append("where login = ?");
        Roles roles;
        try{
            roles = jdbcTemplate.queryForObject(sb.toString(), new RolesRowMapperImpl(),
                    new Object[]{authorizationUser.getLogin()});
            System.out.println(roles);
        }catch(DataAccessException ex){
            System.out.println(ex);
        }
        return false;
    }
}
