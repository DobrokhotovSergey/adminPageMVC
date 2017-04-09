package ua.laksmi.web.domain.tables;

/**
 * Created by Dobriks on 02.04.2017.
 */
public class ProductionInvFarm extends Production{
    private int idInvoiceFarm;
    private Prices prices;

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
                "idInvoiceFarm=" + idInvoiceFarm +
                ", prices=" + prices +
                '}';
    }
}
