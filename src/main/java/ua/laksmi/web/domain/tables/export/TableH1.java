package ua.laksmi.web.domain.tables.export;

import java.util.Date;

/**
 * Created by Dobriks on 28.06.2017.
 */
public class TableH1 {
    private Date date;
    private String nameInvoice;
    private String termNet;
    private String agent;
    private String modOfTransport;


    public Date getDate() {
        return date;
    }

    public String getNameInvoice() {
        return nameInvoice;
    }

    public String getTermNet() {
        return termNet;
    }

    public String getAgent() {
        return agent;
    }

    public String getModOfTransport() {
        return modOfTransport;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNameInvoice(String nameInvoice) {
        this.nameInvoice = nameInvoice;
    }

    public void setTermNet(String termNet) {
        this.termNet = termNet;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public void setModOfTransport(String modOfTransport) {
        this.modOfTransport = modOfTransport;
    }

    @Override
    public String toString() {
        return "TableH1{" +
                "date=" + date +
                ", nameInvoice='" + nameInvoice + '\'' +
                ", termNet='" + termNet + '\'' +
                ", agent='" + agent + '\'' +
                ", modOfTransport='" + modOfTransport + '\'' +
                '}';
    }
}
