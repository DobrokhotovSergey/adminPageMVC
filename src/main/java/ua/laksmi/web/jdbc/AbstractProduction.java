package ua.laksmi.web.jdbc;

import org.springframework.jdbc.core.RowMapper;
import ua.laksmi.web.domain.tables.Production;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dobriks on 12.04.2017.
 */
public abstract class AbstractProduction<T extends Production> implements RowMapper<T>{

    public abstract T mapRow(ResultSet rs, int rowNum) throws SQLException;

    protected void mapBase(ResultSet rs, T production) throws SQLException {
        production.setIdProduct(rs.getInt("id"));
        production.setProduct(rs.getString("product"));
        production.setPrice(rs.getBigDecimal("price"));
        production.setCurrency(rs.getString("currency"));
        production.setIdFarm(rs.getInt("idFerm"));
        production.setGrading(rs.getInt("grading"));
        production.setNumberStemsInBox(rs.getInt("numberStemsInBox"));
        production.setType(rs.getString("type"));
        production.setVariety(rs.getString("variety"));
    }
}
