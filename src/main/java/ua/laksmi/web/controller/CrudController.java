package ua.laksmi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.laksmi.web.domain.searchingForm.InvoiceSearch;
import ua.laksmi.web.domain.tables.Farm;
import ua.laksmi.web.domain.tables.invoices.InvoiceFarm;
import ua.laksmi.web.domain.tables.invoices.InvoiceShipment;
import ua.laksmi.web.domain.tables.production.Production;
import ua.laksmi.web.domain.tables.production.ProductionInvFarm;
import ua.laksmi.web.domain.tables.production.ProductionShipment;
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
    @RequestMapping(value = "/admin/getProduction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Production> getProduction(@RequestParam int id){
        List<Production> list = serviceCRUD.getListProduction(id);
        return list;
    }
    //getInvoiceShipment
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/getInvoiceProductionShipment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ProductionShipment> getInvoiceProductionShipment(@RequestParam int id){
        List<ProductionShipment> list = serviceCRUD.getListInvoiceProductionShipment(id);
        return list;
    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/getInvoiceFarmProduction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ProductionInvFarm> getInvoiceFarmProduction(@RequestParam(value = "id[]") int[] id){
        List<ProductionInvFarm> list = serviceCRUD.getListInvoiceFarmProduction(id);
        return list;
    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/createInvoiceShipment", method =  RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InvoiceShipment createInvoiceShipment(@RequestBody InvoiceShipment invoiceShipment){
        System.out.println("---->"+invoiceShipment);
        return serviceCRUD.createInvoiceShipment(invoiceShipment);
    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/createInvoiceFarm", method =  RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InvoiceFarm createInvoiceFarm(@RequestBody InvoiceFarm invoiceFarm){
        System.out.println("---->"+invoiceFarm);
        return serviceCRUD.createInvoiceFarm(invoiceFarm);
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/searchClientName", method =  RequestMethod.POST)
    @ResponseBody
    public List<String> searchClientName(@RequestParam String searchClientName){
        return serviceCRUD.searchClientName(searchClientName);
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/addProduction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Production addProduction(@RequestBody Production production){
        return serviceCRUD.addProduction(production);
    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/editProduction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Production editProduction(@RequestBody Production production){
        return serviceCRUD.editProduction(production);
    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/deleteProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean deleteProduction(@RequestParam int idProduct){
        return serviceCRUD.deleteProduction(idProduct);
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/getListInvoicesShipment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<InvoiceShipment> getListInvoicesShipment(@RequestBody InvoiceSearch invoiceSearch){
        return serviceCRUD.getListInvoicesShipment(invoiceSearch);
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/getListInvoicesFarm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<InvoiceFarm> getListInvoicesFarm(@RequestBody InvoiceSearch invoiceFarmSearch){
        return serviceCRUD.getListInvoicesFarm(invoiceFarmSearch);
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/getListFarm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Farm> getListFarm(){
        return serviceCRUD.getListFarm();
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/addFarm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Farm addFarm(@RequestBody Farm farm){
        return serviceCRUD.addFarm(farm);
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/editFarm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Farm editFarm(@RequestBody Farm farm){
        return serviceCRUD.editFarm(farm);
    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/deleteFarm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
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
