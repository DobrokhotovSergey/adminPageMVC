package ua.laksmi.web.domain.searchingForm;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Dobriks on 13.04.2017.
 */
public class InvoiceSearch {

    private String client;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date start;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date end;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

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
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
