package ua.laksmi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.laksmi.web.dao.DaoRoles;
import ua.laksmi.web.domain.authorization.AuthorizationUser;
import ua.laksmi.web.domain.roles.Roles;

/**
 * Created by Dobriks on 10.03.2017.
 */

@Service
public class ServiceRolesImpl implements ServiceRoles {

    @Autowired
    private DaoRoles daoRoles;

    public boolean createRole(Roles roles) {
        return daoRoles.createRole(roles);
//
    }

    public boolean deleteRole(int id) {
        return false;
//        return daoRoles.deleteRole(id);
    }

    public boolean checkAuthorization(AuthorizationUser authorizationUser) {
        return false;
//        return daoRoles.checkAuthorization(authorizationUser);
    }
}
