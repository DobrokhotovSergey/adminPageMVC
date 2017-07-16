package ua.laksmi.web.domain.tables.export;

import ua.laksmi.web.domain.tables.invoices.CommerceInvoice;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Dobriks on 28.06.2017.
 */
public class ExportCommercial {
    private int id;
    private List<String> consigne;
    private TableH1 tableH1;
    private TableH2 tableH2;
    private List<CommerceInvoice> commerceInvoice;
    private BigDecimal commisionPerStem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getConsigne() {
        return consigne;
    }

    public void setConsigne(List<String> consigne) {
        this.consigne = consigne;
    }

    public TableH1 getTableH1() {
        return tableH1;
    }

    public void setTableH1(TableH1 tableH1) {
        this.tableH1 = tableH1;
    }

    public TableH2 getTableH2() {
        return tableH2;
    }

    public void setTableH2(TableH2 tableH2) {
        this.tableH2 = tableH2;
    }

    public List<CommerceInvoice> getCommerceInvoice() {
        return commerceInvoice;
    }

    public void setCommerceInvoice(List<CommerceInvoice> commerceInvoice) {
        this.commerceInvoice = commerceInvoice;
    }

    public BigDecimal getCommisionPerStem() {
        return commisionPerStem;
    }

    public void setCommisionPerStem(BigDecimal commisionPerStem) {
        this.commisionPerStem = commisionPerStem;
    }

    @Override
    public String toString() {
        return "ExportCommercial{" +
                "id=" + id +
                ", consigne=" + consigne +
                ", tableH1=" + tableH1 +
                ", tableH2=" + tableH2 +
                ", commerceInvoice=" + commerceInvoice +
                ", commisionPerStem=" + commisionPerStem +
                '}';
    }
}
