package ua.laksmi.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.laksmi.web.domain.tables.employee.Employee;
import ua.laksmi.web.service.ServiceEmployee;

/**
 * Created by Dobriks on 22.04.2017.
 */
@Service
public class UserValidator implements Validator {
    @Autowired
    private ServiceEmployee serviceEmployee;

    public boolean supports(Class<?> aClass) {
        return Employee.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        Employee employee = (Employee) o;
        if (serviceEmployee.findByUsername(employee.getUsername()) != null) {
            errors.rejectValue("userName", "Duplicate.userForm.userName");
        }

    }
}
