package ua.laksmi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.laksmi.config.core.BCrypPasswordEncoder;
import ua.laksmi.web.dao.DaoEmployee;
import ua.laksmi.web.domain.tables.employee.Employee;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Dobriks on 20.04.2017.
 */
@Service
public class ServiceEmployeeImpl implements ServiceEmployee, UserDetailsService {

    @Autowired
    private DaoEmployee daoEmployee;

    @Autowired
    @Qualifier("encoder")
    private BCrypPasswordEncoder bCryptPasswordEncoder;

    @Resource(name="sessionRegistry")
    private SessionRegistry sessionRegistry;

    public List<Employee> getListEmployee() {
        return daoEmployee.getListEmployee();
    }

    public Employee createEmployee(Employee employee) {
        employee.setPassword(bCryptPasswordEncoder.passwordEncoder().encode(employee.getPassword()));
        return daoEmployee.createEmployee(employee);
    }

    public Employee editEmployee(Employee employee) {
        Employee emp = daoEmployee.editEmployee(employee);
        killSession(emp);
        return emp;
    }
    public void killSession(Object userName){
        List<Object> users = sessionRegistry.getAllPrincipals();


        for (Object user: users) {
            System.out.println(userName);
            System.out.println(user);
            System.out.println(true);
            if(userName.equals(user)){

                List<SessionInformation> sessions = sessionRegistry.getAllSessions(user, false);
                sessionRegistry.getSessionInformation(sessions.get(0).getSessionId()).expireNow();
            }
        }

    }
    public boolean deleteEmployee() {
        return daoEmployee.deleteEmployee();
    }

    public Employee findByUsername(String userName) {
        return daoEmployee.findByUsername(userName);
    }
    @Override
    public boolean uploadUserImage(MultipartFile multipartFile, String user) {
        return daoEmployee.uploadUserImage(multipartFile, user);
    }

    @Override
    public byte[] getAvatar(String userName) {
        return daoEmployee.getAvatar(userName);
    }

    @Override
    public boolean updateProfile(Employee employee) {
        return daoEmployee.updateProfile(employee);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee user = daoEmployee.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("No user found for username '" + username +"'.");
        }

        return user;
    }

}
