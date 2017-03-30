package ua.laksmi.web.domain.tables;

import java.math.BigDecimal;

/**
 * Created by Dobriks on 15.03.2017.
 */
public class Production {
   private int id;
   private int idFarm;
   private String product;
   private int grading;
   private int numberStemsInBox;
   private BigDecimal price;
   private String currency;
   private String type;
   private String variety;

    public int getGrading() {
        return grading;
    }

    public void setGrading(int grading) {
        this.grading = grading;
    }

    public int getNumberStemsInBox() {
        return numberStemsInBox;
    }

    public void setNumberStemsInBox(int numberStemsInBox) {
        this.numberStemsInBox = numberStemsInBox;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public int getIdFarm() {
        return idFarm;
    }

    public void setIdFarm(int idFarm) {
        this.idFarm = idFarm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Production{" +
                "id=" + id +
                ", idFarm=" + idFarm +
                ", product='" + product + '\'' +
                ", grading=" + grading +
                ", numberStemsInBox=" + numberStemsInBox +
                ", price=" + price +
                ", currency=" + currency +
                ", type='" + type + '\'' +
                ", variety='" + variety + '\'' +
                '}';
    }
}
