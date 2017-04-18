package ua.laksmi.web.jdbc;

import ua.laksmi.web.domain.tables.Prices;
import ua.laksmi.web.domain.tables.production.ProductionInvFarm;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dobriks on 12.04.2017.
 */
public class InvoiceFarmProductionRowMapperImpl extends AbstractProduction<ProductionInvFarm> {

    public ProductionInvFarm mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductionInvFarm productionInvFarm = new ProductionInvFarm();
        mapBase(rs, productionInvFarm);
        productionInvFarm.setIdInvoiceFarm(rs.getInt("idInvoiceFarm"));
        productionInvFarm.setFarmName(rs.getString("farmName"));
        productionInvFarm.setClientName(rs.getString("clientName"));
        productionInvFarm.setIdProductionInvoiceFarm(rs.getInt("idProductionInvoiceFarm"));
        productionInvFarm.setPrices(new Prices(rs.getBigDecimal("crosscurs"), rs.getBigDecimal("price"),
                rs.getBigDecimal("PriceDiscount"), rs.getBigDecimal("PriceCross"), rs.getBigDecimal("PriceDiscountCross")));
        return productionInvFarm;
    }
}
