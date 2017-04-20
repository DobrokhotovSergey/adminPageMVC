package ua.laksmi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.laksmi.web.domain.charts.DonutChart;
import ua.laksmi.web.service.ServiceCharts;

import java.util.List;

/**
 * Created by Dobriks on 14.04.2017.
 */
@Controller
public class GraphicsController {

    @Autowired
    private ServiceCharts serviceCharts;


    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/admin/getGraphicsFarm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<DonutChart> getGraphicsFarm(){
//        System.out.println(serviceCharts.getGraphicsFarm());
        return serviceCharts.getGraphicsFarm();
    }
}
