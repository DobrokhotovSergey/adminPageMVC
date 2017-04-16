package ua.laksmi.web.domain.tables.invoices;

import ua.laksmi.web.domain.tables.production.ProductionShipment;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Dobriks on 16.04.2017.
 */
public class InvoiceShipment extends AbstractInvoice {
    private BigDecimal crossUSD_EUR;
    private BigDecimal crossEUR_USD;
    private BigDecimal totalPrice_USD;
    private BigDecimal totalPrice_EUR;
    private List<ProductionShipment> productionShipmentList;

    public List<ProductionShipment> getProductionShipmentList() {
        return productionShipmentList;
    }

    public void setProductionShipmentList(List<ProductionShipment> productionShipmentList) {
        this.productionShipmentList = productionShipmentList;
    }

    public BigDecimal getCrossUSD_EUR() {
        return crossUSD_EUR;
    }

    public void setCrossUSD_EUR(BigDecimal crossUSD_EUR) {
        this.crossUSD_EUR = crossUSD_EUR;
    }

    public BigDecimal getCrossEUR_USD() {
        return crossEUR_USD;
    }

    public void setCrossEUR_USD(BigDecimal crossEUR_USD) {
        this.crossEUR_USD = crossEUR_USD;
    }

    public BigDecimal getTotalPrice_USD() {
        return totalPrice_USD;
    }

    public void setTotalPrice_USD(BigDecimal totalPrice_USD) {
        this.totalPrice_USD = totalPrice_USD;
    }

    public BigDecimal getTotalPrice_EUR() {
        return totalPrice_EUR;
    }

    public void setTotalPrice_EUR(BigDecimal totalPrice_EUR) {
        this.totalPrice_EUR = totalPrice_EUR;
    }

    @Override
    public String toString() {
        return "InvoiceShipment{" +
                "crossUSD_EUR=" + crossUSD_EUR +
                ", crossEUR_USD=" + crossEUR_USD +
                ", totalPrice_USD=" + totalPrice_USD +
                ", totalPrice_EUR=" + totalPrice_EUR +
                ", productionShipmentList=" + productionShipmentList +
                "} " + super.toString();
    }
}
