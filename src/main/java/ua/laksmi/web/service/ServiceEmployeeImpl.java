package ua.laksmi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.laksmi.web.dao.DaoEmployee;
import ua.laksmi.web.domain.tables.employee.Employee;

import java.util.List;

/**
 * Created by Dobriks on 20.04.2017.
 */
@Service
public class ServiceEmployeeImpl implements ServiceEmployee {

    @Autowired
    private DaoEmployee daoEmployee;

    public List<Employee> getListEmployee() {
        return daoEmployee.getListEmployee();
    }

    public boolean createEmployee(Employee employee) {
        return daoEmployee.createEmployee(employee);
    }

    public Employee editEmployee(Employee employee) {
        return daoEmployee.editEmployee(employee);
    }

    public boolean deleteEmployee() {
        return daoEmployee.deleteEmployee();
    }
}
