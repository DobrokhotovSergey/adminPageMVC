package ua.laksmi.web.domain.tables;

import java.math.BigDecimal;

/**
 * Created by Dobriks on 31.03.2017.
 */
public class InvoiceFarm extends Production{

    private int idInvoice;
    private BigDecimal priceAfterDiscount;
    private double discount;
    private String clientName;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public BigDecimal getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void setPriceAfterDiscount(BigDecimal priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    @Override
    public String toString() {
        return "InvoiceFarm{" +
                "idInvoice=" + idInvoice +
                ", priceAfterDiscount=" + priceAfterDiscount +
                ", discount=" + discount +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}
