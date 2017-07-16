package ua.laksmi.web.domain.tables.export;

/**
 * Created by Dobriks on 28.06.2017.
 */
public class TableH2 {
    private String fltNumber;
    private String mawb;
    private String awb;

    public String getFltNumber() {
        return fltNumber;
    }

    public void setFltNumber(String fltNumber) {
        this.fltNumber = fltNumber;
    }

    public String getMawb() {
        return mawb;
    }

    public void setMawb(String mawb) {
        this.mawb = mawb;
    }

    public String getAwb() {
        return awb;
    }

    public void setAwb(String awb) {
        this.awb = awb;
    }

    @Override
    public String toString() {
        return "TableH2{" +
                "fltNumber='" + fltNumber + '\'' +
                ", mawb='" + mawb + '\'' +
                ", awb='" + awb + '\'' +
                '}';
    }
}
