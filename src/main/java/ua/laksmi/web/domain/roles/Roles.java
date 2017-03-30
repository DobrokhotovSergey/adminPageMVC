package ua.laksmi.web.domain.roles;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Dobriks on 10.03.2017.
 */
public class Roles {
    private int id;
    private String login;
    private byte[] hashPsw;
    private String role;
    private Date dateCreated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public byte[] getHashPsw() {
        return hashPsw;
    }

    public void setHashPsw(byte[] hashPsw) {
        this.hashPsw = hashPsw;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", hashPsw=" + Arrays.toString(hashPsw) +
                ", role='" + role + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
