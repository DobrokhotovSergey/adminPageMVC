package ua.laksmi.web.domain.tables.invoices;

import ua.laksmi.web.domain.tables.Prices;
import ua.laksmi.web.domain.tables.production.ProductionInvFarm;

import java.util.List;

/**
 * Created by Dobriks on 31.03.2017.
 */
public class InvoiceFarm extends AbstractInvoice{

    private int idFarm;
    private String currency;
    private String clientName;
    private Prices prices;
    private List<ProductionInvFarm> listProduction;
    private String farmName;

    public int getIdFarm() {
        return idFarm;
    }

    public void setIdFarm(int idFarm) {
        this.idFarm = idFarm;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public List<ProductionInvFarm> getListProduction() {
        return listProduction;
    }

    public void setListProduction(List<ProductionInvFarm> listProduction) {
        this.listProduction = listProduction;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    @Override
    public String toString() {
        return "InvoiceFarm{" +
                "idFarm=" + idFarm +
                ", currency='" + currency + '\'' +
                ", clientName='" + clientName + '\'' +
                ", prices=" + prices +
                ", listProduction=" + listProduction +
                ", farmName='" + farmName + '\'' +
                "} " + super.toString();
    }
}
