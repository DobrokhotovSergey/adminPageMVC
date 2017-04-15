package ua.laksmi.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.laksmi.web.dao.DaoCharts;
import ua.laksmi.web.domain.charts.DonutChart;

import java.util.List;

/**
 * Created by Dobriks on 14.04.2017.
 */
@Service
public class ServiceChartsImpl implements ServiceCharts {
    @Autowired
    private DaoCharts daoCharts;
    public List<DonutChart> getGraphicsFarm() {
        return daoCharts.getGraphicsFarm();
    }
}
