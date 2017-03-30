package ua.laksmi.web.service;

import ua.laksmi.web.domain.authorization.AuthorizationUser;
import ua.laksmi.web.domain.roles.Roles;

/**
 * Created by Dobriks on 10.03.2017.
 */
public interface ServiceRoles {
    boolean createRole(Roles roles);
    boolean deleteRole(int id);
    boolean checkAuthorization(AuthorizationUser authorizationUser);
}
