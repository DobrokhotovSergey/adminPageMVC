package ua.laksmi.web.domain.charts;

/**
 * Created by Dobriks on 14.04.2017.
 */
public class DonutChart extends AbstractChart {
    private String highlight;

    public DonutChart(double value, String label, String color, String highlight) {
        super(value, color, label);
        this.highlight = highlight;
    }



    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    @Override
    public String toString() {
        return "DonutChart{" +
                "highlight='" + highlight + '\'' +
                "} " + super.toString();
    }
}
