package ua.laksmi.web.service;

import ua.laksmi.web.domain.searchingForm.InvoiceFarmSearch;
import ua.laksmi.web.domain.tables.Farm;
import ua.laksmi.web.domain.tables.InvoiceFarm;
import ua.laksmi.web.domain.tables.Production;
import ua.laksmi.web.domain.tables.ProductionInvFarm;

import java.util.List;

/**
 * Created by Dobriks on 16.03.2017.
 */
public interface ServiceCRUD {
    List<Production> getListProduction(int idFarm);
    List<Farm> getListFarm();
    boolean deleteProduction(int idProduction);
    boolean deleteFarm(int idFarm);
    Production editProduction(Production production);
    Production addProduction(Production production);
    Farm editFarm(Farm farm);
    Farm addFarm(Farm farm);

    InvoiceFarm createInvoiceFarm(InvoiceFarm invoiceFarm);

    List<InvoiceFarm> getListInvoicesFarm(InvoiceFarmSearch invoiceFarmSearch);

    List<ProductionInvFarm> getListInvoiceFarmProduction(int id);
}
