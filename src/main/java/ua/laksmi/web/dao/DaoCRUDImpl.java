package ua.laksmi.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ua.laksmi.web.domain.searchingForm.InvoiceFarmSearch;
import ua.laksmi.web.domain.tables.Farm;
import ua.laksmi.web.domain.tables.InvoiceFarm;
import ua.laksmi.web.domain.tables.Production;
import ua.laksmi.web.domain.tables.ProductionInvFarm;
import ua.laksmi.web.jdbc.FarmRowMapperImpl;
import ua.laksmi.web.jdbc.InvoiceFarmProductionRowMapperImpl;
import ua.laksmi.web.jdbc.InvoiceFarmRowMapperImpl;
import ua.laksmi.web.jdbc.ProductionRowMapperImpl;
import ua.laksmi.web.utils.Constants;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dobriks on 16.03.2017.
 */
@Component("daoCRUD")
public class DaoCRUDImpl implements DaoCRUD {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DaoCRUDImpl(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource) ;
    }

    public List<Production> getListProduction(int idFarm) {
        List<Production> listProduction = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select a.id, a.idFerm, a.product, a.grading, a.numberStemsInBox, b.currency, a.price, a.type, a.variety  from \n");
        sb.append(Constants.TABLE_PRODUCTION);
        sb.append("\n as a left join \n");
        sb.append(Constants.TABLE_FARM);
        sb.append("\n as b on a.idFerm=b.id\n");
        sb.append("where a.idFerm = ?");
        try{
            listProduction = jdbcTemplate.query(sb.toString(), new ProductionRowMapperImpl(), new Object[]{idFarm});
        }catch (DataAccessException ex){
            System.out.println(ex);
        }
        return listProduction;
    }

    public List<Farm> getListFarm() {
        StringBuilder sb = new StringBuilder();
        sb.append("select id, farmName, currency from\n");
        sb.append(Constants.TABLE_FARM);
        sb.append("\n");
        List<Farm> getListFarm = null;

        try {
            getListFarm = jdbcTemplate.query(sb.toString(), new FarmRowMapperImpl());
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return getListFarm;
    }

    public boolean deleteProduction(int idProduction) {
        StringBuilder sb = new StringBuilder();
        sb.append("delete from\n");
        sb.append(Constants.TABLE_PRODUCTION);
        sb.append("\n  where id=?;");
        boolean isDeleted = false;
        try{
            jdbcTemplate.update(sb.toString(), idProduction);
            isDeleted = true;
        }catch (Exception ex){
            System.out.println(ex);
        }
        return isDeleted;
    }

    public boolean deleteFarm(int idFarm) {
        StringBuilder sb = new StringBuilder();
        sb.append("delete from\n");
        sb.append(Constants.TABLE_FARM);
        sb.append("\n where id=?;");
        boolean isDeleted = false;
        try{
            jdbcTemplate.update(sb.toString(), idFarm);
            isDeleted = true;
        }catch (Exception ex){
            System.out.println(ex);
        }
        return isDeleted;
    }



    public Production addProduction(final Production production) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into\n");
        sb.append(Constants.TABLE_PRODUCTION);
        sb.append("\n(idFerm, product, grading, numberStemsInBox, price, type, variety)\n");
        sb.append("values(?, ?, ?, ?, ?, ?, ?);\n");
        Production newProduction = null;

        final String INSERT_SQL = sb.toString();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            jdbcTemplate.update(
                    new PreparedStatementCreator() {
                        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                            PreparedStatement ps =
                                    connection.prepareStatement(INSERT_SQL, new String[]{"id"});
                            ps.setInt(1, production.getIdFarm());
                            ps.setString(2, production.getProduct());
                            ps.setInt(3, production.getGrading());
                            ps.setInt(4, production.getNumberStemsInBox());
                            ps.setBigDecimal(5, production.getPrice());
                            ps.setString(6, production.getType());
                            ps.setString(7, production.getVariety());
                            return ps;
                        }
                    },
                    keyHolder);
        }catch (Exception ex){
            System.out.println(ex);
        }
        StringBuilder sb2 = new StringBuilder();
//        sb2.append("select id, idFerm, product, grading, numberStemsInBox, price, type, variety from\n");
//        sb2.append(Constants.TABLE_PRODUCTION);
//        sb2.append("\n where id = ?");
        sb2.append("select a.id, a.idFerm, a.product, a.grading, a.numberStemsInBox, b.currency, a.price, a.type, a.variety  from \n");
        sb2.append(Constants.TABLE_PRODUCTION);
        sb2.append("\n as a left join \n");
        sb2.append(Constants.TABLE_FARM);
        sb2.append("\n as b on a.idFerm=b.id\n");
        sb2.append("where a.id=?");
        try{
            newProduction = (Production) jdbcTemplate.queryForObject(sb2.toString(), new ProductionRowMapperImpl(), new Object[]{keyHolder.getKey()});
            System.out.println(newProduction);
        }catch (Exception ex){
            System.out.println(ex);
        }

        return newProduction;
    }

    public Production editProduction(Production production) {
        System.out.println(production);
        StringBuilder sb = new StringBuilder();
        sb.append("update \n");
        sb.append(Constants.TABLE_PRODUCTION);
        sb.append("\n set product =?, grading=?, price=?, numberStemsInBox=?, type=?, variety=?\n");
        sb.append("where id = ?;\n");
        try{
            jdbcTemplate.update(sb.toString(), new Object[]{
                    production.getProduct(),production.getGrading(), production.getPrice(),
                    production.getNumberStemsInBox(), production.getType(), production.getVariety(), production.getIdProduct()});
        }catch (Exception ex){
            System.out.println("--0-"+ex);
        }
        System.out.println(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("select a.id, a.idFerm, a.product, a.grading, a.numberStemsInBox, b.currency, a.price, a.type, a.variety  from \n");
        sb2.append(Constants.TABLE_PRODUCTION);
        sb2.append("\n as a left join \n");
        sb2.append(Constants.TABLE_FARM);
        sb2.append("\n as b on a.idFerm=b.id\n");
        sb2.append("where a.id=?");

        Production newProduction = null;
        System.out.println(sb2.toString());
        try{
            newProduction = (Production) jdbcTemplate.queryForObject(sb2.toString(), new ProductionRowMapperImpl(),
                    new Object[]{production.getIdProduct()});
        }catch (Exception ex){
            System.out.println("--1-"+ex);
        }
        return newProduction;
    }
    public Farm editFarm( Farm farm) {
        StringBuilder sb = new StringBuilder();
        sb.append("update \n");
        sb.append(Constants.TABLE_FARM);
        sb.append("\n set farmName =?, currency=?\n");
        sb.append("where id = ?;\n");

        try{
            jdbcTemplate.update(sb.toString(), new Object[]{farm.getFarmName(),farm.getCurrency(), farm.getId()});
        }catch (Exception ex){
            System.out.println("--0-"+ex);
        }

        StringBuilder sb2 = new StringBuilder();
        sb2.append("select id, farmName, currency from\n");
        sb2.append(Constants.TABLE_FARM);
        sb2.append("\n where id = ?");
        Farm newfarm = null;

        try{
            newfarm = jdbcTemplate.queryForObject(sb2.toString(), new FarmRowMapperImpl(), new Object[]{farm.getId()});

        }catch (Exception ex){
            System.out.println("--1-"+ex);
        }

        return newfarm;
    }

    public Farm addFarm(final Farm farm) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into\n");
        sb.append(Constants.TABLE_FARM);
        sb.append("\n(farmName, currency)\n");
        sb.append("values(?, ?);\n");
        Farm newFarm = null;

        final String INSERT_SQL = sb.toString();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            jdbcTemplate.update(
                    new PreparedStatementCreator() {
                        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                            PreparedStatement ps =
                                    connection.prepareStatement(INSERT_SQL, new String[]{"id"});
                            ps.setString(1, farm.getFarmName());
                            ps.setString(2, farm.getCurrency());
                            return ps;
                        }
                    },
                    keyHolder);
        }catch (Exception ex){
            System.out.println(ex);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("select id, farmName, currency from\n");
        sb2.append(Constants.TABLE_FARM);
        sb2.append("\n where id = ?");
        try{
            newFarm = jdbcTemplate.queryForObject(sb2.toString(), new FarmRowMapperImpl(), new Object[]{keyHolder.getKey()});
            System.out.println(farm);
        }catch (Exception ex){
            System.out.println(ex);
        }
        return newFarm;
    }

    public InvoiceFarm createInvoiceFarm(final InvoiceFarm invoiceFarm) {
        StringBuilder sb = new StringBuilder("insert into\n");
        sb.append(Constants.TABLE_INVOICE_FARM);
        sb.append("\n(idFarm, invoiceName, clientName, invoiceDate, crossCurs, totalPrice, totalPriceDiscount, totalPriceCross, totalPriceDiscountCross)");
        sb.append("values(?,?,?,?,?,?,?,?,?);\n");
        InvoiceFarm newInvoiceFarm = null;
        final String INSERT_SQL = sb.toString();
        final KeyHolder keyHolder = new GeneratedKeyHolder();

        try {
            jdbcTemplate.update(
                    new PreparedStatementCreator() {
                        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                            PreparedStatement ps =
                                    connection.prepareStatement(INSERT_SQL, new String[]{"id"});
                            ps.setInt(1, invoiceFarm.getIdFarm());
                            ps.setString(2, invoiceFarm.getInvoiceName());
                            ps.setString(3,invoiceFarm.getClientName());
                            ps.setDate(4, new java.sql.Date(invoiceFarm.getInvoiceDate().getTime()));
                            ps.setBigDecimal(5,invoiceFarm.getPrices().getCrossCurs());
                            ps.setBigDecimal(6, invoiceFarm.getPrices().getPrice());
                            ps.setBigDecimal(7, invoiceFarm.getPrices().getPriceDiscount());
                            ps.setBigDecimal(8, invoiceFarm.getPrices().getPriceCross());
                            ps.setBigDecimal(9, invoiceFarm.getPrices().getPriceDiscountCross());
                            //ps.setString(2, farm.getCurrency());
                            return ps;
                        }
                    },
                    keyHolder);
        }catch (Exception ex){
            System.out.println(ex);
        }

        StringBuilder sb2 = new StringBuilder();
        sb2.append("insert into\n");
        sb2.append(Constants.TABLE_PRODUCTION_INVOICE_FARM);
        sb2.append("\n(idInvoiceFarm, idProduct, numberStemsInBox, price, priceDiscount, currency, priceCross, priceDiscountCross)");
        sb2.append("values (?, ?, ?, ?, ?, ?, ?, ?)\n");
        System.out.println("key--> "+keyHolder.getKey().intValue());
        final List<ProductionInvFarm> listProduction = invoiceFarm.getListProduction();
        try{
            jdbcTemplate.batchUpdate(sb2.toString(), new BatchPreparedStatementSetter(){

                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ProductionInvFarm productionInvFarm = listProduction.get(i);
                    ps.setInt(1,keyHolder.getKey().intValue());
                    ps.setInt(2,productionInvFarm.getIdProduct());
                    ps.setInt(3,productionInvFarm.getNumberStemsInBox());
                    ps.setBigDecimal(4,productionInvFarm.getPrices().getPrice());
                    ps.setBigDecimal(5, productionInvFarm.getPrices().getPriceDiscount());
                    ps.setString(6, invoiceFarm.getCurrency());
                    ps.setBigDecimal(7, productionInvFarm.getPrices().getPriceCross());
                    ps.setBigDecimal(8, productionInvFarm.getPrices().getPriceDiscountCross());

                }

                public int getBatchSize() {
                    return listProduction.size();
                }
            } );
        }catch(Exception ex){
            System.out.println(ex);
        }

//        sb.append();
        return newInvoiceFarm;
    }

    public List<InvoiceFarm> getListInvoicesFarm(InvoiceFarmSearch invoiceFarmSearch) {
        StringBuilder sb = new StringBuilder();
        sb.append("select a.id,b.farmName,b.currency, a.idFarm, a.invoiceName, a.clientName, a.invoiceDate, \n" +
                "a.crossCurs, a.totalPrice, a.totalPriceDiscount, a.totalPriceCross, a.totalPriceDiscountCross from\n");
        sb.append(Constants.TABLE_INVOICE_FARM);
        sb.append("\n a join \n");
        sb.append(Constants.TABLE_FARM);
        sb.append("\n b\n");
        sb.append("on a.idFarm = b.id\n");
        sb.append("where a.invoiceDate between ? and ? \n");
        List<InvoiceFarm> list = null;
        try{
            list = jdbcTemplate.query(sb.toString(), new InvoiceFarmRowMapperImpl(), new Object[]{invoiceFarmSearch.getStart(), invoiceFarmSearch.getEnd()});
        }catch(Exception ex){
            System.out.println(ex);
        }
        return list;
    }

    public List<ProductionInvFarm> getListInvoiceFarmProduction(int id) {
        List<ProductionInvFarm> list = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select a.idInvoiceFarm,b.product,b.idFerm,b.grading,b.variety,b.type, a.idProduct as id,c.crossCurs, a.numberStemsInBox, a.price, a.priceDiscount, a.currency, a.priceCross, a.priceDiscountCross from\n");
        sb.append(Constants.TABLE_PRODUCTION_INVOICE_FARM);
        sb.append("\n as a left join \n");
        sb.append(Constants.TABLE_PRODUCTION);
        sb.append("\n as b on a.idProduct=b.id\n");
        sb.append("join \n");
        sb.append(Constants.TABLE_INVOICE_FARM);
        sb.append("\n as c on a.idInvoiceFarm = c.id\n");
        sb.append("where a.idInvoiceFarm = ?");
        try{
            list = jdbcTemplate.query(sb.toString(), new InvoiceFarmProductionRowMapperImpl(), new Object[]{id});
        }catch (Exception ex){
            System.out.println(ex);
        }
        return list;
    }
}
