package ua.laksmi.web.domain.charts;

/**
 * Created by Dobriks on 14.04.2017.
 */
public abstract class AbstractChart {
    protected double value;
    protected String color;
    protected String label;

    public AbstractChart(double value, String color, String label) {
        this.value = value;
        this.color = color;
        this.label = label;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "AbstractChart{" +
                "value=" + value +
                ", color='" + color + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
