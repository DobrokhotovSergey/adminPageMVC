package ua.laksmi.web.dao;

import ua.laksmi.web.domain.tables.employee.Employee;

import java.util.List;

/**
 * Created by Dobriks on 20.04.2017.
 */
public interface DaoEmployee {
    List<Employee> getListEmployee();
    boolean createEmployee(Employee employee);
    Employee editEmployee(Employee employee);
    boolean deleteEmployee();
}
