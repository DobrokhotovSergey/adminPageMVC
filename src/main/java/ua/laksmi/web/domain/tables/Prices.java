package ua.laksmi.web.domain.tables;

import java.math.BigDecimal;

/**
 * Created by Dobriks on 03.04.2017.
 */
public class Prices {
    private BigDecimal crossCurs;
    private BigDecimal price;
    private BigDecimal priceDiscount;
    private BigDecimal priceCross;
    private BigDecimal priceDiscountCross;

    public Prices() {
    }

    public Prices(BigDecimal crossCurs, BigDecimal price, BigDecimal priceDiscount, BigDecimal priceCross, BigDecimal priceDiscountCross) {
        this.crossCurs = crossCurs;
        this.price = price;
        this.priceDiscount = priceDiscount;
        this.priceCross = priceCross;
        this.priceDiscountCross = priceDiscountCross;
    }

    public BigDecimal getCrossCurs() {
        return crossCurs;
    }

    public void setCrossCurs(BigDecimal crossCurs) {
        this.crossCurs = crossCurs;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(BigDecimal priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public BigDecimal getPriceCross() {
        return priceCross;
    }

    public void setPriceCross(BigDecimal priceCross) {
        this.priceCross = priceCross;
    }

    public BigDecimal getPriceDiscountCross() {
        return priceDiscountCross;
    }

    public void setPriceDiscountCross(BigDecimal priceDiscountCross) {
        this.priceDiscountCross = priceDiscountCross;
    }

    @Override
    public String toString() {
        return "Prices{" +
                "crossCurs=" + crossCurs +
                ", price=" + price +
                ", priceDiscount=" + priceDiscount +
                ", priceCross=" + priceCross +
                ", priceDiscountCross=" + priceDiscountCross +
                '}';
    }
}
