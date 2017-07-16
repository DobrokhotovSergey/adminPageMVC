package ua.laksmi.web.controller;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.laksmi.web.domain.tables.employee.Employee;
import ua.laksmi.web.service.ServiceEmployee;
import ua.laksmi.web.validator.UserValidator;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.servlet.http.HttpServletResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dobriks on 22.03.2017.
 */
@Controller
public class EmployeeController {

    @Autowired
    private ServiceEmployee serviceEmployee;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserValidator userValidator;



    private volatile Cache<String, byte[]> cache = CacheBuilder.newBuilder()
            .concurrencyLevel(30)
            .expireAfterWrite(7, TimeUnit.HOURS)
            .initialCapacity(500)
            .maximumSize(3000).softValues().build();

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
    @RequestMapping(value = {"/admin/uploadUserImage","uploadUserImage"},headers = "content-type=multipart/*",  method = RequestMethod.POST)
    public @ResponseBody
    boolean uploadFileHandler(@RequestParam("file") MultipartFile multipartFile, Authentication authentication) {
        String user = authentication.getName();
        cache.invalidate(user);
        return serviceEmployee.uploadUserImage(multipartFile, user);
    }
    @RequestMapping(value = "/admin/getAvatar/{userName}", method=RequestMethod.GET)
    public @ResponseBody
    byte[] getAvatar(@PathVariable String userName, HttpServletResponse response) {

        response.setHeader("Cache-Control", "max-age=604800, only-if-cached");
        response.setHeader("Pragma", "cache");
        response.setHeader("User-Cache-Control", "max-age=604800");
        response.setDateHeader("Expires", System.currentTimeMillis() + 604800000L);
        byte[] byteCache = cache.getIfPresent(userName);
        if(byteCache != null){
            return byteCache;
        }
        byte[] imageBytes = serviceEmployee.getAvatar(userName);
        if(imageBytes!=null){
            cache.put(userName, imageBytes);
        }

        return imageBytes;
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
    @RequestMapping(value = {"/admin**","/admin/getAvatar/**", "/admin/getListFarm**",  "/admin/getListInvoicesFarm**",
            "/admin/getListInvoicesShipment**", "/admin/getGraphicsFarm**", "/admin/getListEmployee**","/admin/getListCommercial**"}, method = RequestMethod.GET)
    public ModelAndView adminPage(Authentication authentication) throws NoSuchAlgorithmException, InvalidKeySpecException,
            IllegalBlockSizeException, BadPaddingException, ShortBufferException, InvalidKeyException {
        Employee emp = (Employee) userDetailsService.loadUserByUsername(authentication.getName());
        ModelAndView model = new ModelAndView();
        model.setViewName("admin");

        model.addObject("login", emp.getUsername());
        model.addObject("firstname", emp.getFirstname());
        model.addObject("lastname", emp.getLastname());
        model.addObject("position", emp.getPosition());
        return model;

    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/updateProfile",  method = RequestMethod.POST
            , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public boolean updateProfile(@RequestBody Employee employee, Authentication authentication){
        employee.setUsername(authentication.getName());
        return serviceEmployee.updateProfile(employee);
    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/editEmployee",  method = RequestMethod.POST
            , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public Employee editEmployee(@RequestBody Employee employee){

        return serviceEmployee.editEmployee(employee);
    }
}
