package ua.laksmi.web.dao;

import ua.laksmi.web.domain.authorization.AuthorizationUser;
import ua.laksmi.web.domain.roles.Roles;

import java.util.List;

/**
 * Created by Dobriks on 10.03.2017.
 */
public interface DaoRoles {
    boolean createRole(Roles roles);
    boolean deleteRole(int id);
    List<Roles> getListRoles();
    boolean checkAuthorization(AuthorizationUser authorizationUser);
}
