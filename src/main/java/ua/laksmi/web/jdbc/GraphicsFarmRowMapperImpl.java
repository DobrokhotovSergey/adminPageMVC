package ua.laksmi.web.jdbc;

import org.springframework.jdbc.core.RowMapper;
import ua.laksmi.web.domain.charts.DonutChart;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 * Created by Dobriks on 15.04.2017.
 */
public class GraphicsFarmRowMapperImpl implements RowMapper<DonutChart> {
    private String randomRGB(){
        Random random = new Random();
        final float hue = random.nextFloat();
        final float saturation = (random.nextInt(2000) + 1000) / 10000f;
        final float luminance = 0.9f;
        final Color color = Color.getHSBColor(hue, saturation, luminance);
        String rgb = Integer.toHexString(color.getRGB()).substring(2).toUpperCase();

        return "#"+rgb;
    }
    public DonutChart mapRow(ResultSet rs, int rowNum) throws SQLException {
        String randomColor = randomRGB();
        DonutChart donutChart = new DonutChart(rs.getInt("value"), rs.getString("label"), randomColor, randomColor);
        return donutChart;
    }
}
