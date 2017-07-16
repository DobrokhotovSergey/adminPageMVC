package ua.laksmi.web.domain.tables.invoices;

import java.math.BigDecimal;

/**
 * Created by Dobriks on 29.06.2017.
 */
public class CommerceInvoice {
    private BigDecimal total;
    private BigDecimal totalCross;
    private String variety;
    private int countBox;
    private int count;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalCross() {
        return totalCross;
    }

    public void setTotalCross(BigDecimal totalCross) {
        this.totalCross = totalCross;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public int getCountBox() {
        return countBox;
    }

    public void setCountBox(int countBox) {
        this.countBox = countBox;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CommerceInvoice{" +
                "total=" + total +
                ", totalCross=" + totalCross +
                ", variety='" + variety + '\'' +
                ", countBox=" + countBox +
                ", count=" + count +
                '}';
    }
}
