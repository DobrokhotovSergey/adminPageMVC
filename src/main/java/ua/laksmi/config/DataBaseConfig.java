package ua.laksmi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ua.laksmi.web.dao.*;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Dobriks on 11.03.2017.
 */
//@Configuration
//public class DataBaseConfig {
//    @Bean
//    public DriverManagerDataSource getMySQLDriverManagerDatasource() {
//        URI dbUri = null;
//        try {
//            dbUri = new URI(System.getenv("DATABASE_URL"));
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//
//        String username = dbUri.getUserInfo().split(":")[0];
//        String password = dbUri.getUserInfo().split(":")[1];
//        //String dbUrl = "jdbc:postgresql://ec2-54-235-181-120.compute-1.amazonaws.com:5432/d214mn7r53p1uk?sslmode=require";
//        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
//
//
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        try {
//            dataSource.setUrl(dbUrl);
//            dataSource.setUsername(username);
//            dataSource.setPassword(password);
//        }catch (Exception ex){
//            System.out.println(ex);
//        }
//
//
//        return dataSource;
//    }
//    @Bean("daoRoles")
//    public DaoRoles getDaoRoles() {
//        return new DaoRolesImpl(getMySQLDriverManagerDatasource());
//    }
//
//    @Bean("daoCRUD")
//    public DaoCRUD getDaoCRUD() {
//        return new DaoCRUDImpl(getMySQLDriverManagerDatasource());
//    }
//
//}



@Configuration
public class DataBaseConfig {
    @Bean
    public DriverManagerDataSource getDriverManagerDatasource() {
        URI dbUri = null;
        try {
            dbUri = new URI(System.getenv("DATABASE_URL"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
//        String dbUrl = "jdbc:postgresql://ec2-23-21-96-70.compute-1.amazonaws.com:5432/d9s122lkd6dc5c?sslmode=require";
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        try {
            dataSource.setUrl(dbUrl);
            dataSource.setUsername("yefzqnfdvaghvd");
            dataSource.setPassword("3fc956464fdc3567b06c26160334e92fd16f90df302849bd596548717d4dd865");
        }catch (Exception ex){
            System.out.println(ex);
        }


        return dataSource;
    }
    @Bean("daoEmployee")
	public DaoEmployee getDaoRoles() {
		return new DaoEmployeeImpl(getDriverManagerDatasource());
	}

    @Bean("daoCRUD")
    public DaoCRUD getDaoCRUD() {
        return new DaoCRUDImpl(getDriverManagerDatasource());
    }

    @Bean("daoCharts")
    public DaoCharts getDaoCharts() { return new DaoChartsImpl(getDriverManagerDatasource());}

}
