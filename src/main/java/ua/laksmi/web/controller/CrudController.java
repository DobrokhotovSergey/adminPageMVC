package ua.laksmi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.laksmi.web.domain.tables.Farm;
import ua.laksmi.web.domain.tables.InvoiceFarm;
import ua.laksmi.web.domain.tables.Production;
import ua.laksmi.web.service.ServiceCRUD;

import java.util.List;

/**
 * Created by Dobriks on 22.03.2017.
 */
@Controller
public class CrudController {

    @Autowired
    private ServiceCRUD serviceCRUD;

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/getProduction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Production> getProduction(@RequestParam int id){
        List<Production> list = serviceCRUD.getListProduction(id);
       // System.out.println(list);
        return list;
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/createInvoiceFarm", method =  RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InvoiceFarm createInvoiceFarm(@RequestBody InvoiceFarm invoiceFarm){
        System.out.println("---->"+invoiceFarm);
        return serviceCRUD.createInvoiceFarm(invoiceFarm);
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/addProduction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Production addProduction(@RequestBody Production production){
        return serviceCRUD.addProduction(production);
    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/editProduction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Production editProduction(@RequestBody Production production){
        return serviceCRUD.editProduction(production);
    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean deleteProduction(@RequestParam int idProduct){
        return serviceCRUD.deleteProduction(idProduct);
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/getListInvoicesFarm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<InvoiceFarm> getListInvoicesFarm(){
        return serviceCRUD.getListInvoicesFarm();
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/getListFarm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Farm> getListFarm(){
        return serviceCRUD.getListFarm();
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/addFarm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Farm addFarm(@RequestBody Farm farm){
        return serviceCRUD.addFarm(farm);
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/editFarm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Farm editFarm(@RequestBody Farm farm){
        return serviceCRUD.editFarm(farm);
    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/deleteFarm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean deleteFarm(@RequestParam int id){
       return serviceCRUD.deleteFarm(id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

}
