package ua.laksmi.web.domain.tables;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by Dobriks on 31.03.2017.
 */
public class InvoiceFarm{

    private int id;
    private int idFarm;
    private String currency;
    private String invoiceName;
    private String clientName;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date invoiceDate;
    private Prices prices;
    private List<ProductionInvFarm> listProduction;
    private String farmName;

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getIdFarm() {
        return idFarm;
    }

    public void setIdFarm(int idFarm) {
        this.idFarm = idFarm;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }



    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public List<ProductionInvFarm> getListProduction() {
        return listProduction;
    }

    public void setListProduction(List<ProductionInvFarm> listProduction) {
        this.listProduction = listProduction;
    }

    @Override
    public String toString() {
        return "InvoiceFarm{" +
                "id=" + id +
                ", idFarm=" + idFarm +
                ", currency='" + currency + '\'' +
                ", invoiceName='" + invoiceName + '\'' +
                ", clientName='" + clientName + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", prices=" + prices +
                ", listProduction=" + listProduction +
                ", farmName='" + farmName + '\'' +
                '}';
    }
}
