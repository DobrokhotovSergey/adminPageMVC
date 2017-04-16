package ua.laksmi.web.domain.tables.invoices;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Dobriks on 16.04.2017.
 */
public abstract class AbstractInvoice {
    private int id;
    private String invoiceName;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date invoiceDate;

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

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Override
    public String toString() {
        return "AbstractInvoice{" +
                "id=" + id +
                ", invoiceName='" + invoiceName + '\'' +
                ", invoiceDate=" + invoiceDate +
                '}';
    }
}
