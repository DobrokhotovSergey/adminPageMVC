package ua.laksmi.web.dao;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;

import org.springframework.web.multipart.MultipartFile;
import ua.laksmi.web.domain.searchingForm.InvoiceCommerceSearch;
import ua.laksmi.web.domain.searchingForm.InvoiceSearch;
import ua.laksmi.web.domain.tables.Farm;
import ua.laksmi.web.domain.tables.export.ExportCommercial;
import ua.laksmi.web.domain.tables.invoices.CommerceInvoice;
import ua.laksmi.web.domain.tables.invoices.InvoiceFarm;
import ua.laksmi.web.domain.tables.invoices.InvoiceShipment;
import ua.laksmi.web.domain.tables.production.Production;
import ua.laksmi.web.domain.tables.production.ProductionInvFarm;
import ua.laksmi.web.domain.tables.production.ProductionShipment;
import ua.laksmi.web.jdbc.*;
import ua.laksmi.web.utils.Constants;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.*;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

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
//            System.out.println(newProduction);
        }catch (Exception ex){
            System.out.println(ex);
        }

        return newProduction;
    }

    public Production editProduction(Production production) {
//        System.out.println(production);
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
//        System.out.println(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("select a.id, a.idFerm, a.product, a.grading, a.numberStemsInBox, b.currency, a.price, a.type, a.variety  from \n");
        sb2.append(Constants.TABLE_PRODUCTION);
        sb2.append("\n as a left join \n");
        sb2.append(Constants.TABLE_FARM);
        sb2.append("\n as b on a.idFerm=b.id\n");
        sb2.append("where a.id=?");

        Production newProduction = null;
//        System.out.println(sb2.toString());
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
        sb.append("\n set farmName =?\n");
        sb.append("where id = ?;\n");

        try{
            jdbcTemplate.update(sb.toString(), new Object[]{farm.getFarmName(), farm.getId()});
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
//            System.out.println(farm);
        }catch (Exception ex){
            System.out.println(ex);
        }
        return newFarm;
    }
    public InvoiceShipment createInvoiceShipment(final InvoiceShipment invoiceShipment) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into\n");
        sb.append(Constants.TABLE_INVOICE_SHIPMENT);
        sb.append("\n(shipmentName, shipmentDate, cross_usd_eur, cross_eur_usd, totalPrice_usd, totalPrice_eur)\n");
        sb.append("values(?,?,?,?,?,?)");
        InvoiceShipment newInvoiceShipment = null;
        final String INSERT_SQL = sb.toString();
        final KeyHolder keyHolder = new GeneratedKeyHolder();
//        System.out.println(INSERT_SQL);
        try {
            jdbcTemplate.update(
                    new PreparedStatementCreator() {
                        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                            PreparedStatement ps =
                                    connection.prepareStatement(INSERT_SQL, new String[]{"idshipment"});
                            ps.setString(1, invoiceShipment.getInvoiceName());
                            ps.setDate(2, new java.sql.Date(invoiceShipment.getInvoiceDate().getTime()));
                            ps.setBigDecimal(3, invoiceShipment.getCrossUSD_EUR());
                            ps.setBigDecimal(4, invoiceShipment.getCrossEUR_USD());
                            ps.setBigDecimal(5, invoiceShipment.getTotalPrice_USD());
                            ps.setBigDecimal(6, invoiceShipment.getTotalPrice_EUR());
                            return ps;
                        }
                    },
                    keyHolder);
        }catch (Exception ex){
            System.out.println(ex);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("insert into\n");
        sb2.append(Constants.TABLE_PRODUCTION_INVOICE_SHIPMENT);
        sb2.append("\n(idInvoiceShipment, idProduct, priceForStem, priceForBox, priceCross, priceWithBoxCross, idproductinvfarm, box, idproductioninvoicefarm)");
        sb2.append("values (?, ?, ?, ?, ?, ?, ?,?, ?)\n");
//        System.out.println("key--> "+keyHolder.getKey().intValue());
        final List<ProductionShipment> listProduction = invoiceShipment.getProductionShipmentList();
        try{
            jdbcTemplate.batchUpdate(sb2.toString(), new BatchPreparedStatementSetter(){
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ProductionShipment productionInvFarm = listProduction.get(i);
                    ps.setInt(1,keyHolder.getKey().intValue());
                    ps.setInt(2,productionInvFarm.getIdProduct());
                    ps.setBigDecimal(3, productionInvFarm.getPriceForStem());
                    ps.setBigDecimal(4, productionInvFarm.getPriceForBox());
                    ps.setBigDecimal(5, productionInvFarm.getPriceCross());
                    ps.setBigDecimal(6, productionInvFarm.getPriceWithBoxCross());
                    ps.setInt(7, productionInvFarm.getIdInvoiceFarm());
                    ps.setInt(8,productionInvFarm.getBox());
                    ps.setInt(9,productionInvFarm.getIdProductionInvoiceFarm());
                }
                public int getBatchSize() {
                    return listProduction.size();
                }
            } );
        }catch(Exception ex){
            System.out.println(ex);
        }

        return newInvoiceShipment;
    }

    public boolean saveCommercialInvoice(final ExportCommercial exportCommercial){
        boolean isSaved = false;
        StringBuilder sb = new StringBuilder();
        sb.append("insert into \n");
        sb.append(Constants.TABLE_COMMERCIAL_INVOICE);
        sb.append(" (name, date, termsNet, agent,modOfTransport,flt, mawb, awb, commision, consigne)");
        sb.append("values(?,?,?,?,?,?,?,?,?,?);\n");
        final String INSERT_SQL = sb.toString();
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        try{
            jdbcTemplate.update(
                    new PreparedStatementCreator() {
                        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                            PreparedStatement ps =
                                    connection.prepareStatement(INSERT_SQL, new String[]{"id"});
                            ps.setString(1, exportCommercial.getTableH1().getNameInvoice());
                            ps.setDate(2,  new java.sql.Date(exportCommercial.getTableH1().getDate().getTime()));
                            ps.setString(3, exportCommercial.getTableH1().getTermNet());
                            ps.setString(4, exportCommercial.getTableH1().getAgent());
                            ps.setString(5, exportCommercial.getTableH1().getModOfTransport());
                            ps.setString(6, exportCommercial.getTableH2().getFltNumber());
                            ps.setString(7, exportCommercial.getTableH2().getMawb());
                            ps.setString(8, exportCommercial.getTableH2().getAwb());
                            ps.setBigDecimal(9, exportCommercial.getCommisionPerStem());
                            Array array = connection.createArrayOf("text", exportCommercial.getConsigne().stream().toArray(String[]::new));
                            ps.setArray(10, array);
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
        sb2.append(Constants.TABLE_COMMERCIAL_INVOICE_TAB);
        sb2.append("\n(id, variety, boxes, stems, total, totalCross)");
        sb2.append("values (?, ?, ?, ?, ?, ?)\n");
//        System.out.println("key--> "+keyHolder.getKey().intValue());
        final List<CommerceInvoice> tableCommerceInvoice = exportCommercial.getCommerceInvoice();
        try{
            jdbcTemplate.batchUpdate(sb2.toString(), new BatchPreparedStatementSetter(){

                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    CommerceInvoice commerceInvoice = tableCommerceInvoice.get(i);
                    ps.setInt(1,keyHolder.getKey().intValue());
                    ps.setString(2,commerceInvoice.getVariety());
                    ps.setInt(3,commerceInvoice.getCountBox());
                    ps.setInt(4,commerceInvoice.getCountBox());
                    ps.setBigDecimal(5, commerceInvoice.getTotal());
                    ps.setBigDecimal(6, commerceInvoice.getTotalCross());

                }

                public int getBatchSize() {
                    return tableCommerceInvoice.size();
                }
            } );
        }catch(Exception ex){
            System.out.println(ex);
        }

        return isSaved;
    }

    @Override
    public List<ExportCommercial> getListCommercial(InvoiceCommerceSearch invoiceCommerceSearch) {
        StringBuilder sb = new StringBuilder();
        sb.append("select id, name , date, termsnet, agent, modOfTransport, awb, flt, mawb,consigne from\n");
        sb.append(Constants.TABLE_COMMERCIAL_INVOICE);
        sb.append(" where ");
        List<Object> listParam = new ArrayList<Object>();
        if(invoiceCommerceSearch.getStart()!=null&&invoiceCommerceSearch.getEnd()!=null){
            sb.append("date between ? and ? \n");
            listParam.add(invoiceCommerceSearch.getStart());
            listParam.add(invoiceCommerceSearch.getEnd());
        }
        if(invoiceCommerceSearch.getName()!=null&&StringUtils.isNotBlank(invoiceCommerceSearch.getName())){
            if(listParam.size()>0){
                sb.append(" and ");
            }
            sb.append(" upper(name) = upper(?)\n");
            listParam.add(invoiceCommerceSearch.getName());
        }
        List<ExportCommercial> list = null;
//        System.out.println(invoiceCommerceSearch);
        try{
            list = jdbcTemplate.query(sb.toString(), new InvoiceCommerceRowMapperImpl(), listParam.toArray());
        }catch(Exception ex){
            System.out.println(ex);
        }

        return list;
    }

    @Override
    public ExportCommercial getExporCommercial(int id) {
        StringBuilder sb = new StringBuilder();
        sb.append("select id, name , date, termsnet, agent, modOfTransport, awb, flt, mawb, consigne from\n");
        sb.append(Constants.TABLE_COMMERCIAL_INVOICE);
        sb.append(" where id = ?");
        ExportCommercial exportCommercial = jdbcTemplate.queryForObject(sb.toString(), new InvoiceCommerceRowMapperImpl(), id);

        StringBuilder sb2 = new StringBuilder();
        sb2.append("select id, variety, boxes as countBox,stems as count,total, totalCross\n");
        sb2.append("from ");
        sb2.append(Constants.TABLE_COMMERCIAL_INVOICE_TAB);
        sb2.append(" where id =?");
        List<CommerceInvoice> list = jdbcTemplate.query(sb2.toString(), new CommerceInvoiceRowMapperImpl(), id);
       // List<CommerceInvoice> list = getListCommercialIvoice(id);
        exportCommercial.setCommerceInvoice(list);
        System.out.println(exportCommercial);
//        InvoiceCommerceRowMapperImpl
        return exportCommercial;
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
//        System.out.println("key--> "+keyHolder.getKey().intValue());
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
    public List<InvoiceShipment> getListInvoicesShipment(InvoiceSearch invoiceSearch) {
        StringBuilder sb = new StringBuilder();
        sb.append("select a.idshipment, a.shipmentName, a.shipmentDate, a.cross_usd_eur,\n");
        sb.append("a.cross_eur_usd, a.totalprice_usd, a.totalprice_eur from ");
        sb.append(Constants.TABLE_INVOICE_SHIPMENT);
        sb.append(" a where a.shipmentDate between ? and ?");
        List<InvoiceShipment> invoiceShipmentList = null;
        try{
            invoiceShipmentList = jdbcTemplate.query(sb.toString(), new InvoiceShipmentRowMapper(),
                    new Object[]{invoiceSearch.getStart(), invoiceSearch.getEnd()});
        }catch (Exception ex){
            System.out.println(ex);
        }
//        select a.idshipment, a.shipmentName, a.shipmentDate, a.cross_usd_eur,
//                a.cross_eur_usd, a.totalprice_usd, a.totalprice_eur from invoiceShipment a
        return invoiceShipmentList;
    }



    public List<InvoiceFarm> getListInvoicesFarm(InvoiceSearch invoiceFarmSearch) {
        StringBuilder sb = new StringBuilder();
        List<Object> listParam = new ArrayList<Object>();
        sb.append("select a.id,b.farmName,b.currency, a.idFarm, a.invoiceName, a.clientName, a.invoiceDate, \n" +
                "a.crossCurs, a.totalPrice, a.totalPriceDiscount, a.totalPriceCross, a.totalPriceDiscountCross from\n");
        sb.append(Constants.TABLE_INVOICE_FARM);
        sb.append("\n a join \n");
        sb.append(Constants.TABLE_FARM);
        sb.append("\n b\n");
        sb.append("on a.idFarm = b.id\n");
        sb.append("where ");
        if(invoiceFarmSearch.getStart()!=null&&invoiceFarmSearch.getEnd()!=null){
            sb.append("a.invoiceDate between ? and ? \n");
            listParam.add(invoiceFarmSearch.getStart());
            listParam.add(invoiceFarmSearch.getEnd());
        }
        if(invoiceFarmSearch.getClient()!=null&&StringUtils.isNotBlank(invoiceFarmSearch.getClient())){
            if(listParam.size()>0){
                sb.append(" and ");
            }
            sb.append(" upper(clientName) = upper(?)\n");
            listParam.add(invoiceFarmSearch.getClient());
        }
        List<InvoiceFarm> list = null;
        System.out.println(invoiceFarmSearch);
        try{
            list = jdbcTemplate.query(sb.toString(), new InvoiceFarmRowMapperImpl(), listParam.toArray());
        }catch(Exception ex){
            System.out.println(ex);
        }
        return list;
    }

    public List<CommerceInvoice> getListCommercialIvoice(int id){
        List<CommerceInvoice> list = null;
        StringBuilder sb = new StringBuilder();

        sb.append("select distinct sum(d.numberStemsInBox) as count,\n");
        sb.append("sum(d.priceDiscount*d.numberStemsInBox) as total, b.variety,\n");
        sb.append("sum(d.priceDiscountCross*d.numberStemsInBox) as totalCross,  sum(a.box) as countBox from\n");
        sb.append("public.productionInvoiceShipment a join public.Production b on a.idProduct = b.id join\n");
        sb.append(Constants.TABLE_FARM);
        sb.append("  c on b.idFerm = c.id join \n");
        sb.append(Constants.TABLE_PRODUCTION_INVOICE_FARM);
        sb.append(" d on d.idProductionInvoiceFarm = a.idProductionInvoiceFarm join \n");
        sb.append(Constants.TABLE_INVOICE_FARM);
        sb.append(" e on e.id = d.idInvoiceFarm\n");
        sb.append(" where a.idInvoiceShipment = ?\n");
        sb.append("group by b.variety\n");

        try{
            list = jdbcTemplate.query(sb.toString(), new CommerceInvoiceRowMapperImpl(), new Object[]{id});
        }catch (Exception ex){
            System.out.println(ex);
        }
        return list;
    };
    public List<ProductionShipment> getListInvoiceProductionShipment(int id) {
        List<ProductionShipment> list = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select distinct c.farmName,d.numberStemsInBox,e.clientName, a.idInvoiceShipment, a.idProduct, d.priceDiscount as priceForStem, a.priceForBox, d.priceDiscountCross as priceCross, a.priceWithBoxCross, a.box from\n");
        sb.append(Constants.TABLE_PRODUCTION_INVOICE_SHIPMENT);
        sb.append(" a join ");
        sb.append(Constants.TABLE_PRODUCTION);
        sb.append(" b on a.idProduct = b.id \n");
        sb.append(" join ");
        sb.append(Constants.TABLE_FARM);
        sb.append("\n c on b.idFerm = c.id \n");
        sb.append(" join ");
        sb.append(Constants.TABLE_PRODUCTION_INVOICE_FARM);
        sb.append("\n d on d.idProductionInvoiceFarm = a.idProductionInvoiceFarm \n");
        sb.append("join ");
        sb.append(Constants.TABLE_INVOICE_FARM);
        sb.append(" e on e.id = d.idInvoiceFarm\n");

        sb.append(" where a.idInvoiceShipment = ?");
        System.out.println(sb.toString());
        try{
            list = jdbcTemplate.query(sb.toString(), new InvoiceShipmentProductionRowMapper(), new Object[]{id});
        }catch (Exception ex){
            System.out.println(ex);
        }
        return list;
    }
    private static byte[] readBytesFromFile(String filePath) {

        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;

        try {

            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];

            //read file into bytes[]
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return bytesArray;

    }

    public byte[] exportCommercial(ExportCommercial exportCommercial) {
        byte [] bytes = null;
        File myFile = new File("src/main/resources/CommercialExcel.xlsx");
        System.out.println("-->"+exportCommercial);
        try {
            FileInputStream fis = new FileInputStream(myFile);

            // Finds the workbook instance for XLSX file
            XSSFWorkbook wb = new XSSFWorkbook (fis);

            XSSFSheet sheet1 = wb.getSheet("Sheet1");

            XSSFRow row8 = sheet1.getRow(9);
            XSSFCell cell8 = row8.getCell(3);
            cell8.setCellValue(exportCommercial.getTableH1().getDate());
            XSSFRow row9 = sheet1.getRow(10);
            XSSFCell cell9 = row9.getCell(3);
            cell9.setCellValue(exportCommercial.getTableH1().getNameInvoice());
            XSSFRow row10 = sheet1.getRow(11);
            XSSFCell cell10 = row10.getCell(3);
            cell10.setCellValue(exportCommercial.getTableH1().getTermNet());
            XSSFRow row11 = sheet1.getRow(12);
            XSSFCell cell11 = row11.getCell(3);
            cell11.setCellValue(exportCommercial.getTableH1().getAgent());
            XSSFRow row12 = sheet1.getRow(13);
            XSSFCell cell12 = row12.getCell(3);
            cell12.setCellValue(exportCommercial.getTableH1().getModOfTransport());

            XSSFRow rowTab10 = sheet1.getRow(9);
            XSSFCell cellTab10 = rowTab10.getCell(1);
            cellTab10.setCellValue(exportCommercial.getTableH2().getFltNumber());
            XSSFRow rowTab11 = sheet1.getRow(10);
            XSSFCell cellTab11 = rowTab11.getCell(1);
            cellTab11.setCellValue(exportCommercial.getTableH2().getMawb());
            XSSFRow rowTab12 = sheet1.getRow(11);
            XSSFCell cellTab12 = rowTab12.getCell(1);
            cellTab12.setCellValue(exportCommercial.getTableH2().getAwb());

            for(int i=0; i<exportCommercial.getConsigne().size();i++){
                XSSFRow rowConsigne = sheet1.getRow(i+10);
                XSSFCell cellConsigne = rowConsigne.getCell(0);
                cellConsigne.setCellValue(exportCommercial.getConsigne().get(i));
            }
            XSSFCellStyle newCellStyle = wb.createCellStyle();

            newCellStyle.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
            newCellStyle.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
            int sizeCommerceTable = exportCommercial.getCommerceInvoice().size();
            sheet1.shiftRows(26, sheet1.getLastRowNum()+3, sizeCommerceTable, true,true);

            for(int i =0; i <exportCommercial.getCommerceInvoice().size();i++){
                XSSFRow rowT = sheet1.createRow(i+26);
                for (int j = 0; j < 4; j++){
                    XSSFCell localXSSFCell = rowT.createCell(j);
                    localXSSFCell.setCellStyle(newCellStyle);
                    if(j==0){
                        localXSSFCell.setCellValue(exportCommercial.getCommerceInvoice().get(i).getVariety());
                    }
                    else if(j==1){
                        localXSSFCell.setCellValue(exportCommercial.getCommerceInvoice().get(i).getCountBox());
                    }
                    else if(j==2){
                        localXSSFCell.setCellValue(exportCommercial.getCommerceInvoice().get(i).getCount());
                    }
                    else if(j==3) {
                        localXSSFCell.setCellType(Cell.CELL_TYPE_NUMERIC);
                        localXSSFCell.setCellValue(exportCommercial.getCommerceInvoice().get(i).getTotal().doubleValue());
                    }
                }
            }

            String strFormula= "SUM(B27:B"+(26+sizeCommerceTable)+")";
            XSSFCell cellGrandTotal = sheet1.getRow(26+sizeCommerceTable).createCell(1);
            cellGrandTotal.setCellType(XSSFCell.CELL_TYPE_FORMULA);
            cellGrandTotal.setCellFormula(strFormula);

            newCellStyle.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
            newCellStyle.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
            cellGrandTotal.setCellStyle(newCellStyle);

            String strFormulaStem= "SUM(C27:C"+(26+sizeCommerceTable)+")";
            XSSFCell cellStem = sheet1.getRow(26+sizeCommerceTable).createCell(2);
            cellStem.setCellType(XSSFCell.CELL_TYPE_FORMULA);
            cellStem.setCellFormula(strFormulaStem);
            cellStem.setCellStyle(newCellStyle);

            String strFormulaTotal= "SUM(D27:D"+(26+sizeCommerceTable)+")";
            XSSFCell cellTotal = sheet1.getRow(26+sizeCommerceTable).createCell(3);
            cellTotal.setCellType(XSSFCell.CELL_TYPE_FORMULA);
            cellTotal.setCellFormula(strFormulaTotal);
            cellTotal.setCellStyle(newCellStyle);

            BigDecimal comm = exportCommercial.getCommisionPerStem();
            if(comm ==null){
                comm = BigDecimal.ZERO;
            }

            String strFormulaCommisionPerStem= comm.toString()+"*C"+(27+sizeCommerceTable);
            XSSFCell cellCommisionPerStem = sheet1.getRow(27+sizeCommerceTable).createCell(3);
            cellCommisionPerStem.setCellType(XSSFCell.CELL_TYPE_FORMULA);
            cellCommisionPerStem.setCellFormula(strFormulaCommisionPerStem);
            cellCommisionPerStem.setCellStyle(newCellStyle);



            String strFormulaGrandTotal1= "+D"+(27+sizeCommerceTable)+"+D"+(28+sizeCommerceTable);
            XSSFCell cellGrandTotal1 = sheet1.getRow(28+sizeCommerceTable).createCell(3);
            cellGrandTotal1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
            cellGrandTotal1.setCellFormula(strFormulaGrandTotal1);
            cellGrandTotal1.setCellStyle(newCellStyle);
            XSSFRow rowBottom = sheet1.getRow(41+sizeCommerceTable);
            XSSFCell cellBottom3 = rowBottom.createCell(3);
            XSSFCellStyle cellStyleDate = wb.createCellStyle();
            XSSFCreationHelper createHelper = wb.getCreationHelper();
            cellStyleDate.setDataFormat(
                    createHelper.createDataFormat().getFormat("d-mmm-yy"));
            cellBottom3.setCellValue(exportCommercial.getTableH1().getDate());
            cellBottom3.setCellStyle(cellStyleDate);
           // sheet1.shiftRows(29, sheet1.getLastRowNum()+1, 1, true,true);
            FileOutputStream fileOut = new FileOutputStream("src/main/resources/"+exportCommercial.getTableH1().getNameInvoice()+"_commercial.xlsx");
            wb.write(fileOut);
            fileOut.close();
            File file = new File("src/main/resources/"+exportCommercial.getTableH1().getNameInvoice()+"_commercial.xlsx");
            bytes = readBytesFromFile(file.getPath());
            try{



                if(file.delete()){
                    System.out.println(file.getName() + " is deleted!");
                }else{
                    System.out.println("Delete operation is failed.");
                }

            }catch(Exception e){

                e.printStackTrace();

            }

        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println(ex);
        }
        return bytes;
    }

    public List<ProductionInvFarm> getListInvoiceFarmProduction(int[] id) {

        List<ProductionInvFarm> list = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select a.idProductionInvoiceFarm,d.farmName,c.clientName, a.idInvoiceFarm,b.product,b.idFerm,b.grading,b.variety,b.type, a.idProduct as id,c.crossCurs, a.numberStemsInBox, a.price, a.priceDiscount, a.currency, a.priceCross, a.priceDiscountCross from\n");
        sb.append(Constants.TABLE_PRODUCTION_INVOICE_FARM);
        sb.append("\n as a left join \n");
        sb.append(Constants.TABLE_PRODUCTION);
        sb.append("\n as b on a.idProduct=b.id\n");
        sb.append("join \n");
        sb.append(Constants.TABLE_INVOICE_FARM);
        sb.append("\n as c on a.idInvoiceFarm = c.id\n");

        sb.append("join ");
        sb.append(Constants.TABLE_FARM);
        sb.append(" as d on b.idFerm = d.id\n");

        sb.append("where a.idInvoiceFarm in ");
        sb.append(Arrays.toString(id).replace("[","(").replace("]",")"));
        System.out.println(sb.toString());
        try{
            list = jdbcTemplate.query(sb.toString(), new InvoiceFarmProductionRowMapperImpl());
        }catch (Exception ex){
            System.out.println(ex);
        }
        return list;
    }

    public List<String> searchClientName(String searchClientName) {
        StringBuilder sb= new StringBuilder();
        sb.append("select distinct clientName from\n");
        sb.append(Constants.TABLE_INVOICE_FARM);
        sb.append("\n where clientName like ?");
        List<String> finded = null;
        try{
            finded = jdbcTemplate.queryForList(sb.toString(), String.class, new Object[]{"%"+searchClientName+"%"});
            System.out.println("finded--"+finded);
        }catch (Exception ex){
            System.out.println(ex);
        }
        return finded;
    }


}
