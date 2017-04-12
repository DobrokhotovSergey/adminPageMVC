package ua.laksmi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.laksmi.web.dao.DaoCRUD;
import ua.laksmi.web.domain.searchingForm.InvoiceFarmSearch;
import ua.laksmi.web.domain.tables.Farm;
import ua.laksmi.web.domain.tables.InvoiceFarm;
import ua.laksmi.web.domain.tables.Production;
import ua.laksmi.web.domain.tables.ProductionInvFarm;

import java.util.List;

/**
 * Created by Dobriks on 16.03.2017.
 */
@Service
public class ServiceCRUDImpl implements ServiceCRUD{

    @Autowired
    private DaoCRUD daoCRUD;

    public List<Production> getListProduction(int idFarm) {
        return daoCRUD.getListProduction(idFarm);
    }

    public List<Farm> getListFarm() {
        return daoCRUD.getListFarm();
    }

    public boolean deleteProduction(int idProduction) {
        return daoCRUD.deleteProduction(idProduction);
    }

    public boolean deleteFarm(int idFarm) {
        return daoCRUD.deleteFarm(idFarm);
    }

    public Production editProduction(Production production) {
        return daoCRUD.editProduction(production);
    }

    public Production addProduction(Production production) {
        return daoCRUD.addProduction(production);
    }

    public Farm editFarm(Farm farm) {
        return daoCRUD.editFarm(farm);
    }

    public Farm addFarm(Farm farm) {
        return daoCRUD.addFarm(farm);
    }

    public InvoiceFarm createInvoiceFarm(InvoiceFarm invoiceFarm) {
        return daoCRUD.createInvoiceFarm(invoiceFarm);
    }

    public List<InvoiceFarm> getListInvoicesFarm(InvoiceFarmSearch invoiceFarmSearch) {
        return daoCRUD.getListInvoicesFarm(invoiceFarmSearch);
    }

    public List<ProductionInvFarm> getListInvoiceFarmProduction(int id) {
        return daoCRUD.getListInvoiceFarmProduction(id);
    }
}
