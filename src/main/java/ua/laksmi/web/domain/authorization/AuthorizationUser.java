package ua.laksmi.web.domain.authorization;

/**
 * Created by Dobriks on 11.03.2017.
 */
public class AuthorizationUser {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthorizationUser {"+this.login+", "+this.password+"}";
    }
}
