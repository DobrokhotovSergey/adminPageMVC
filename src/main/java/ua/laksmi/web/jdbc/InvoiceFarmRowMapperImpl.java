package ua.laksmi.web.jdbc;

import org.springframework.jdbc.core.RowMapper;
import ua.laksmi.web.domain.tables.InvoiceFarm;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dobriks on 11.04.2017.
 */
public class InvoiceFarmRowMapperImpl implements RowMapper<InvoiceFarm> {
    public InvoiceFarm mapRow(ResultSet rs, int rowNum) throws SQLException {
        InvoiceFarm invoiceFarm = new InvoiceFarm();
        invoiceFarm.setClientName(rs.getString("clientName"));
        invoiceFarm.setIdFarm(rs.getInt("idFarm"));
        invoiceFarm.setId(rs.getInt("id"));
       // invoiceFarm.setCurrency(rs.getString("currency"));
        invoiceFarm.setInvoiceDate(rs.getDate("invoiceDate"));
        invoiceFarm.setInvoiceName(rs.getString("invoiceName"));

        return invoiceFarm;
    }
}
