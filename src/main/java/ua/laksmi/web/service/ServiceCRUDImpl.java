package ua.laksmi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.laksmi.web.dao.DaoCRUD;
import ua.laksmi.web.domain.searchingForm.InvoiceCommerceSearch;
import ua.laksmi.web.domain.searchingForm.InvoiceSearch;
import ua.laksmi.web.domain.tables.Farm;
import ua.laksmi.web.domain.tables.export.CommercialFile;
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

    public List<InvoiceFarm> getListInvoicesFarm(InvoiceSearch invoiceFarmSearch) {
        return daoCRUD.getListInvoicesFarm(invoiceFarmSearch);
    }

    public List<ProductionInvFarm> getListInvoiceFarmProduction(int[] id) {
        return daoCRUD.getListInvoiceFarmProduction(id);
    }

    public List<String> searchClientName(String searchClientName) {
        return daoCRUD.searchClientName(searchClientName);
    }

    public InvoiceShipment createInvoiceShipment(InvoiceShipment invoiceShipment) {
        return daoCRUD.createInvoiceShipment(invoiceShipment);
    }

    public List<InvoiceShipment> getListInvoicesShipment(InvoiceSearch invoiceSearch) {
        return daoCRUD.getListInvoicesShipment(invoiceSearch);
    }

    public List<ProductionShipment> getListInvoiceProductionShipment(int id) {
        return daoCRUD.getListInvoiceProductionShipment(id);
    }

    public byte[] exportCommercial(ExportCommercial exportCommercial) {
       return daoCRUD.exportCommercial(exportCommercial);
    }

    public CommercialFile getCommercialFile(ExportCommercial exportCommercial) {
        CommercialFile commercialFile = new CommercialFile();
        commercialFile.setBytes(daoCRUD.exportCommercial(exportCommercial));
        commercialFile.setFileName(exportCommercial.getTableH1().getNameInvoice()+"___"+exportCommercial.getTableH1().getDate()+".xlsx");
        return commercialFile;
    }

    public List<CommerceInvoice> getListCommercialIvoice(int id) {
        return daoCRUD.getListCommercialIvoice(id);
    }

    @Override
    public boolean saveCommercialInvoice(ExportCommercial exportCommercial) {
        return daoCRUD.saveCommercialInvoice(exportCommercial);
    }

    @Override
    public List<ExportCommercial> getListCommercial(InvoiceCommerceSearch invoiceCommerceSearch) {
        return daoCRUD.getListCommercial(invoiceCommerceSearch);
    }

    @Override
    public ExportCommercial getExporCommercial(int id) {
        return daoCRUD.getExporCommercial(id);
    }


}
