package ua.laksmi.web.jdbc;

import org.springframework.jdbc.core.RowMapper;
import ua.laksmi.web.domain.tables.InvoiceFarm;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dobriks on 31.03.2017.
 */
public class InvoiceFarmRowMapperImpl implements RowMapper<InvoiceFarm> {
    public InvoiceFarm mapRow(ResultSet rs, int rowNum) throws SQLException {
        InvoiceFarm invoiceFarm = new InvoiceFarm();
        invoiceFarm.setPrice(rs.getBigDecimal("price"));
        invoiceFarm.setProduct(rs.getString("product"));
        invoiceFarm.setVariety(rs.getString("variety"));
        invoiceFarm.setPriceAfterDiscount(rs.getBigDecimal("priceAfterDiscount"));
        invoiceFarm.setDiscount(rs.getDouble("discount"));
        invoiceFarm.setGrading(rs.getInt("grading"));
        invoiceFarm.setNumberStemsInBox(rs.getInt("numberStemsInBox"));
        invoiceFarm.setIdProduct(rs.getInt("idProduct"));
        invoiceFarm.setCurrency(rs.getString("currency"));
        invoiceFarm.setIdFarm(rs.getInt("idFarm"));
        invoiceFarm.setType(rs.getString("type"));
        invoiceFarm.setIdInvoice(rs.getInt("idInvoice"));
        invoiceFarm.setClientName(rs.getString("clientName"));
        return invoiceFarm;
    }
}
