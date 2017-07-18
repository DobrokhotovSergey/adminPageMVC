package ua.laksmi.web.domain.tables.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by Dobriks on 20.04.2017.
 */
public class Employee implements UserDetails {
    private int id;
    private String Username;
    private String role;
    private boolean status;
    @JsonIgnore
    private String password;
    private String firstname;
    private String lastname;
    private String position;
    private String user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (status != employee.status) return false;
        if (!Username.equals(employee.Username)) return false;
        if (!role.equals(employee.role)) return false;
        if (!password.equals(employee.password)) return false;
        if (firstname != null ? !firstname.equals(employee.firstname) : employee.firstname != null) return false;
        if (lastname != null ? !lastname.equals(employee.lastname) : employee.lastname != null) return false;
        if (position != null ? !position.equals(employee.position) : employee.position != null) return false;
        return list != null ? list.equals(employee.list) : employee.list == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Username.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + password.hashCode();
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (list != null ? list.hashCode() : 0);
        return result;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    Collection<? extends GrantedAuthority> list;

    public Collection<? extends GrantedAuthority> getList() {
        return list;
    }

    public void setList(Collection<? extends GrantedAuthority> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return list;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return Username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Username='" + Username + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", position='" + position + '\'' +
                ", list=" + list +
                '}';
    }
}
