package ua.laksmi.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.laksmi.web.domain.charts.DonutChart;
import ua.laksmi.web.jdbc.GraphicsFarmRowMapperImpl;
import ua.laksmi.web.utils.Constants;

import javax.sql.DataSource;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Dobriks on 14.04.2017.
 */
@Repository("DaoCharts")
public class DaoChartsImpl implements DaoCharts {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DaoChartsImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource) ;
    }


    public List<DonutChart> getGraphicsFarm() {
        StringBuilder sb = new StringBuilder();
        sb.append("select count(a.idFarm) as value , b.farmName as label from \n");
        sb.append(Constants.TABLE_INVOICE_FARM);
        sb.append("\n a join \n");
        sb.append(Constants.TABLE_FARM);
        sb.append("\nb on a.idFarm = b.id\n");
        sb.append("group by a.idFarm, b.farmName");
        List<DonutChart> list = null;
        try{
            list = jdbcTemplate.query(sb.toString(),new GraphicsFarmRowMapperImpl());
        }catch (Exception ex){
            System.out.println(ex);
        }
//        DonutChart d1 = new DonutChart(1,"label1", randomRGB(),"red");
//        DonutChart d2 = new DonutChart(2,"label2", randomRGB(),"green");
//        List<DonutChart> list = new ArrayList<DonutChart>();
//        list.add(d1);
//        list.add(d2);
//        System.out.println(randomRGB().toString());
        return list;
    }
}
