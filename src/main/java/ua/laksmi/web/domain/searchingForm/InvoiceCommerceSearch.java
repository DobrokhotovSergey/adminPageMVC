package ua.laksmi.web.domain.searchingForm;

/**
 * Created by Dobriks on 01.07.2017.
 */
public class InvoiceCommerceSearch extends AbstractSearch {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "InvoiceCommerceSearch{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
