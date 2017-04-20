package ua.laksmi.web.service;

import ua.laksmi.web.domain.tables.employee.Employee;

import java.util.List;

/**
 * Created by Dobriks on 20.04.2017.
 */
public interface ServiceEmployee {
    List<Employee> getListEmployee();
    boolean createEmployee(Employee employee);
    Employee editEmployee(Employee employee);
    boolean deleteEmployee();
}
