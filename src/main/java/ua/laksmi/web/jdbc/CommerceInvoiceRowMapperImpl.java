package ua.laksmi.web.jdbc;

import org.springframework.jdbc.core.RowMapper;
import ua.laksmi.web.domain.tables.invoices.CommerceInvoice;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dobriks on 29.06.2017.
 */
public class CommerceInvoiceRowMapperImpl implements RowMapper<CommerceInvoice> {
    public CommerceInvoice mapRow(ResultSet rs, int rowNum) throws SQLException {
        CommerceInvoice invoice = new CommerceInvoice();
        invoice.setCount(rs.getInt("count"));
        invoice.setCountBox(rs.getInt("countBox"));
        invoice.setTotal(rs.getBigDecimal("total"));
        invoice.setTotalCross(rs.getBigDecimal("totalCross"));
        invoice.setVariety(rs.getString("variety"));
        return invoice;
    }
}
