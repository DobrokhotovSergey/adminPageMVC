package ua.laksmi.web.domain.tables.production;

import ua.laksmi.web.domain.tables.Prices;

/**
 * Created by Dobriks on 02.04.2017.
 */
public class ProductionInvFarm extends Production {
    private int idProductionInvoiceFarm;
    private int idInvoiceFarm;
    private Prices prices;
    private String farmName;
    private String clientName;

    public int getIdProductionInvoiceFarm() {
        return idProductionInvoiceFarm;
    }

    public void setIdProductionInvoiceFarm(int idProductionInvoiceFarm) {
        this.idProductionInvoiceFarm = idProductionInvoiceFarm;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public int getIdInvoiceFarm() {
        return idInvoiceFarm;
    }

    public void setIdInvoiceFarm(int idInvoiceFarm) {
        this.idInvoiceFarm = idInvoiceFarm;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "ProductionInvFarm{" +
                "idProductionInvoiceFarm=" + idProductionInvoiceFarm +
                ", idInvoiceFarm=" + idInvoiceFarm +
                ", prices=" + prices +
                ", farmName='" + farmName + '\'' +
                ", clientName='" + clientName + '\'' +
                "} " + super.toString();
    }
}
