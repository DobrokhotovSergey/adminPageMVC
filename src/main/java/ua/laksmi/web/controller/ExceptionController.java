package ua.laksmi.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by Dobriks on 23.04.2017.
 */
@Controller
public class ExceptionController {
    // for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied(Principal user) {

        ModelAndView model = new ModelAndView();

        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
                    + ", you do not have permission to access this page!");
        } else {
            model.addObject("msg",
                    "You do not have permission to access this page!");
        }

        model.setViewName("403");
        return model;

    }
    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public ModelAndView notExists(Principal user) {
        ModelAndView model = new ModelAndView();
        model.setViewName("404");
        return model;
    }
}
