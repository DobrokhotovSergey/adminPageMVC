package ua.laksmi.web.jdbc;

import org.springframework.jdbc.core.RowMapper;
import ua.laksmi.web.domain.tables.Farm;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dobriks on 16.03.2017.
 */
public class FarmRowMapperImpl implements RowMapper<Farm> {
    public Farm mapRow(ResultSet rs, int rowNum) throws SQLException {
        Farm farm = new Farm();
        farm.setId(rs.getInt("id"));
        farm.setFarmName(rs.getString("farmName"));
        farm.setCurrency(rs.getString("currency"));
        return farm;
    }
}
