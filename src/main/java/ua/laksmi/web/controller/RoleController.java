package ua.laksmi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import ua.laksmi.web.service.ServiceRoles;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Collection;

/**
 * Created by Dobriks on 22.03.2017.
 */
@Controller
public class RoleController {

    @Autowired
    private ServiceRoles serviceRoles;
    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    public RoleController(InMemoryUserDetailsManager inMemoryUserDetailsManager) {
        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
    }

    @RequestMapping("exists/{username}")
    public boolean userExists(@PathVariable("username") String username ) {
        System.out.println(inMemoryUserDetailsManager.userExists(username));
        return inMemoryUserDetailsManager.userExists(username);
    }
    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView welcomePage()  {
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        //System.out.println(authorities.toArray()[0].toString());
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
    @RequestMapping(value = {"/admin**"}, method = RequestMethod.GET)
    public ModelAndView adminPage(Authentication authentication) throws NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, ShortBufferException, InvalidKeyException {
        System.out.println(authentication.getName());
//		Collection<? extends GrantedAuthority> grantedAuthorities = authentication.getAuthorities();
//
//		inMemoryUserDetailsManager.createUser(new User("serg", "ser",grantedAuthorities));
        ModelAndView model = new ModelAndView();
        model.setViewName("admin");
        model.addObject("login", authentication.getName());
        return model;

    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "getDocument", method = RequestMethod.POST)
    public @ResponseBody
    String adminPageItem(Authentication authentication) {
        //System.out.println("doc");
        return "DOCUMENT";

    }
//	@RequestMapping("add/{username}/{password}")
//	public String add(@PathVariable("username") String username, @PathVariable("password") String password) {
//		inMemoryUserDetailsManager.createUser(new User(username, password, new ArrayList<GrantedAuthority>()));
//		return "added";
//	}

}
