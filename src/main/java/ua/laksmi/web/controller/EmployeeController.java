package ua.laksmi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.laksmi.web.domain.tables.employee.Employee;
import ua.laksmi.web.service.ServiceEmployee;
import ua.laksmi.web.validator.UserValidator;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Dobriks on 22.03.2017.
 */
@Controller
public class EmployeeController {

    @Autowired
    private ServiceEmployee serviceEmployee;

    @Autowired
    private UserValidator userValidator;

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/createEmployee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee createEmployee(@RequestBody Employee employee, BindingResult bindingResult){
        userValidator.validate(employee, bindingResult);
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            System.out.println("ERROR");
            return null;
        }
        return serviceEmployee.createEmployee(employee);
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/getListEmployee",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Employee> getListEmployee(){
        System.out.println(serviceEmployee.getListEmployee());
        return  serviceEmployee.getListEmployee();
    }

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView welcomePage()  {
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        if("ROLE_ADMIN".equals(authorities.toArray()[0].toString())){
            return new ModelAndView("redirect:/admin");
        }else if("ROLE_USER".equals(authorities.toArray()[0].toString())){
            return new ModelAndView("redirect:/user");
        }
        return new ModelAndView("redirect:/login");

    }
    @Secured({"ROLE_USER"})
    @RequestMapping(value = "/user**", method = RequestMethod.GET)
    public ModelAndView userPage(Authentication authentication){
        ModelAndView model = new ModelAndView();
        model.setViewName("user");
        model.addObject("login", authentication.getName());
        return model;

    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = {"/admin**", "/admin/getListFarm**",  "/admin/getListInvoicesFarm**",
            "/admin/getListInvoicesShipment**", "/admin/getGraphicsFarm**", "/admin/getListEmployee**"}, method = RequestMethod.GET)
    public ModelAndView adminPage(Authentication authentication) throws NoSuchAlgorithmException, InvalidKeySpecException,
            IllegalBlockSizeException, BadPaddingException, ShortBufferException, InvalidKeyException {
        ModelAndView model = new ModelAndView();
        model.setViewName("admin");
        model.addObject("login", authentication.getName());
        return model;

    }


}
