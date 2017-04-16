package ua.laksmi.web.jdbc;

import org.springframework.jdbc.core.RowMapper;
import ua.laksmi.web.domain.tables.production.ProductionShipment;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dobriks on 16.04.2017.
 */
public class InvoiceShipmentProductionRowMapper implements RowMapper<ProductionShipment> {
    public ProductionShipment mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductionShipment productionShipment = new ProductionShipment();
        productionShipment.setIdInvoiceFarm(rs.getInt("idInvoiceShipment"));
        productionShipment.setIdProduct(rs.getInt("idProduct"));
        productionShipment.setPriceForStem(rs.getBigDecimal("priceForStem"));
        productionShipment.setPriceForBox(rs.getBigDecimal("priceForBox"));
        productionShipment.setPriceCross(rs.getBigDecimal("priceCross"));
        productionShipment.setPriceWithBoxCross(rs.getBigDecimal("priceWithBoxCross"));
        productionShipment.setBox(rs.getInt("box"));
        return productionShipment;
    }
}
