package ua.laksmi.web.domain.tables;

/**
 * Created by Dobriks on 16.03.2017.
 */
public class Farm {
    private int id;
    private String farmName;
    private String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "id=" + id +
                ", farmName='" + farmName + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
