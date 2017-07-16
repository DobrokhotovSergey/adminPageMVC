package ua.laksmi.web.domain.searchingForm;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Dobriks on 13.04.2017.
 */
public class InvoiceSearch extends AbstractSearch{

    private String client;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "InvoiceSearch{" +
                "client='" + client + '\'' +
                "} " + super.toString();
    }
}
