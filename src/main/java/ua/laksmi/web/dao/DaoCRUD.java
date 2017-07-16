package ua.laksmi.web.dao;

import org.springframework.web.multipart.MultipartFile;
import ua.laksmi.web.domain.searchingForm.InvoiceCommerceSearch;
import ua.laksmi.web.domain.searchingForm.InvoiceSearch;
import ua.laksmi.web.domain.tables.Farm;
import ua.laksmi.web.domain.tables.export.ExportCommercial;
import ua.laksmi.web.domain.tables.invoices.CommerceInvoice;
import ua.laksmi.web.domain.tables.invoices.InvoiceFarm;
import ua.laksmi.web.domain.tables.invoices.InvoiceShipment;
import ua.laksmi.web.domain.tables.production.Production;
import ua.laksmi.web.domain.tables.production.ProductionInvFarm;
import ua.laksmi.web.domain.tables.production.ProductionShipment;

import java.util.List;

/**
 * Created by Dobriks on 16.03.2017.
 */
public interface DaoCRUD {
    List<Production> getListProduction(int idFarm);
    List<Farm> getListFarm();
    boolean deleteProduction(int idProduction);
    boolean deleteFarm(int idFarm);
    Production editProduction(Production production);
    Production addProduction(Production production);
    Farm editFarm(Farm farm);
    Farm addFarm(Farm farm);

    InvoiceFarm createInvoiceFarm(InvoiceFarm invoiceFarm);

    List<InvoiceFarm> getListInvoicesFarm(InvoiceSearch invoiceFarmSearch);

    List<ProductionInvFarm> getListInvoiceFarmProduction(int[] id);

    List<String> searchClientName(String searchClientName);

    InvoiceShipment createInvoiceShipment(InvoiceShipment invoiceShipment);

    List<InvoiceShipment> getListInvoicesShipment(InvoiceSearch invoiceSearch);

    List<ProductionShipment> getListInvoiceProductionShipment(int id);
    byte[] exportCommercial(ExportCommercial exportCommercial);
    List<CommerceInvoice> getListCommercialIvoice(int id);
    boolean saveCommercialInvoice(final ExportCommercial exportCommercial);

    List<ExportCommercial> getListCommercial(InvoiceCommerceSearch invoiceCommerceSearch);

    ExportCommercial getExporCommercial(int id);


}
