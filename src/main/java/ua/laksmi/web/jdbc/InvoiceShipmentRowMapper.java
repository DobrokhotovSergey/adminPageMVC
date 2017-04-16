package ua.laksmi.web.jdbc;

import org.springframework.jdbc.core.RowMapper;
import ua.laksmi.web.domain.tables.invoices.InvoiceShipment;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dobriks on 16.04.2017.
 */
public class InvoiceShipmentRowMapper implements RowMapper<InvoiceShipment> {
    public InvoiceShipment mapRow(ResultSet rs, int rowNum) throws SQLException {
        InvoiceShipment invoiceShipment = new InvoiceShipment();
        invoiceShipment.setId(rs.getInt("idshipment"));
        invoiceShipment.setInvoiceName(rs.getString("shipmentname"));
        invoiceShipment.setInvoiceDate(rs.getDate("shipmentdate"));
        invoiceShipment.setCrossUSD_EUR(rs.getBigDecimal("cross_usd_eur"));
        invoiceShipment.setCrossEUR_USD(rs.getBigDecimal("cross_eur_usd"));
        invoiceShipment.setTotalPrice_USD(rs.getBigDecimal("totalprice_usd"));
        invoiceShipment.setTotalPrice_EUR(rs.getBigDecimal("totalprice_eur"));
        return invoiceShipment;
    }
}
