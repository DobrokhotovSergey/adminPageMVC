package ua.laksmi.web.dao;

import org.springframework.web.multipart.MultipartFile;
import ua.laksmi.web.domain.tables.employee.Employee;

import java.util.List;

/**
 * Created by Dobriks on 20.04.2017.
 */
public interface DaoEmployee {
    List<Employee> getListEmployee();
    Employee createEmployee(Employee employee);
    Employee editEmployee(Employee employee);
    boolean deleteEmployee();

    Employee findByUsername(String userName);
    boolean uploadUserImage(MultipartFile multipartFile, String user);

    byte[] getAvatar(String userName);


    boolean updateProfile(Employee employee);
}
