package ua.laksmi.web.jdbc;

import org.springframework.jdbc.core.RowMapper;
import ua.laksmi.web.domain.tables.export.ExportCommercial;
import ua.laksmi.web.domain.tables.export.TableH1;
import ua.laksmi.web.domain.tables.export.TableH2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Created by Dobriks on 01.07.2017.
 */
public class InvoiceCommerceRowMapperImpl implements RowMapper<ExportCommercial> {
    @Override
    public ExportCommercial mapRow(ResultSet rs, int rowNum) throws SQLException {
        ExportCommercial exportCommercial = new ExportCommercial();
        TableH1 tableH1 = new TableH1();
        tableH1.setAgent(rs.getString("agent"));
        tableH1.setDate(rs.getDate("date"));
        tableH1.setModOfTransport(rs.getString("modOfTransport"));
        tableH1.setTermNet(rs.getString("termsnet"));
        exportCommercial.setId(rs.getInt("id"));
        tableH1.setNameInvoice(rs.getString("name"));
        exportCommercial.setTableH1(tableH1);
        TableH2 tableH2 = new TableH2();
        tableH2.setAwb(rs.getString("awb"));
        tableH2.setFltNumber(rs.getString("flt"));
        tableH2.setMawb(rs.getString("mawb"));
        exportCommercial.setConsigne(Arrays.asList((String[])rs.getArray("consigne").getArray()));
        exportCommercial.setTableH2(tableH2);
        return exportCommercial;
    }
}
