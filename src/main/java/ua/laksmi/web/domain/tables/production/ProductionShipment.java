package ua.laksmi.web.domain.tables.production;

import java.math.BigDecimal;

/**
 * Created by Dobriks on 16.04.2017.
 */
public class ProductionShipment extends ProductionInvFarm {

    private int box;
    private BigDecimal priceForStem;
    private BigDecimal priceForBox;
    private BigDecimal priceCross;
    private BigDecimal priceWithBoxCross;

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public BigDecimal getPriceForStem() {
        return priceForStem;
    }

    public void setPriceForStem(BigDecimal priceForStem) {
        this.priceForStem = priceForStem;
    }

    public BigDecimal getPriceForBox() {
        return priceForBox;
    }

    public void setPriceForBox(BigDecimal priceForBox) {
        this.priceForBox = priceForBox;
    }

    public BigDecimal getPriceCross() {
        return priceCross;
    }

    public void setPriceCross(BigDecimal priceCross) {
        this.priceCross = priceCross;
    }

    public BigDecimal getPriceWithBoxCross() {
        return priceWithBoxCross;
    }

    public void setPriceWithBoxCross(BigDecimal priceWithBoxCross) {
        this.priceWithBoxCross = priceWithBoxCross;
    }

    @Override
    public String toString() {
        return "ProductionShipment{" +
                "box=" + box +
                ", priceForStem=" + priceForStem +
                ", priceForBox=" + priceForBox +
                ", priceCross=" + priceCross +
                ", priceWithBoxCross=" + priceWithBoxCross +
                "} " + super.toString();
    }
}
