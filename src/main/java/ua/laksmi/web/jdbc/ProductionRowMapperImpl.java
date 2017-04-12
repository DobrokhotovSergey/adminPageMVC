package ua.laksmi.web.jdbc;

import org.springframework.jdbc.core.RowMapper;
import ua.laksmi.web.domain.tables.Production;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dobriks on 16.03.2017.
 */
public class ProductionRowMapperImpl extends AbstractProduction{
    public Production mapRow(ResultSet rs, int rowNum) throws SQLException {
        Production production = new Production();
        mapBase(rs, production);
        return production;
    }
}
