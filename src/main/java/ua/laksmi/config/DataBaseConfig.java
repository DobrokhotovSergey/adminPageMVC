package ua.laksmi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ua.laksmi.web.dao.DaoCRUD;
import ua.laksmi.web.dao.DaoCRUDImpl;
import ua.laksmi.web.dao.DaoRoles;
import ua.laksmi.web.dao.DaoRolesImpl;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Dobriks on 11.03.2017.
 */
@Configuration
public class DataBaseConfig {
    @Bean
    public DriverManagerDataSource getMySQLDriverManagerDatasource() {
//        URI dbUri = null;
//        try {
//            dbUri = new URI(System.getenv("DATABASE_URL"));
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

//        String username = dbUri.getUserInfo().split(":")[0];
//        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://ec2-54-235-181-120.compute-1.amazonaws.com:5432/d214mn7r53p1uk?sslmode=require";


        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        try {
            dataSource.setUrl(dbUrl);
            dataSource.setUsername("ygvcoviixumdga");
            dataSource.setPassword("69bb3a4d772ef7546822b29f2405c437a10b0b49701801bf52cd27f31e036193");
        }catch (Exception ex){
            System.out.println(ex);
        }


        return dataSource;
    }
    @Bean("daoRoles")
	public DaoRoles getDaoRoles() {
		return new DaoRolesImpl(getMySQLDriverManagerDatasource());
	}

    @Bean("daoCRUD")
    public DaoCRUD getDaoCRUD() {
        return new DaoCRUDImpl(getMySQLDriverManagerDatasource());
    }

}
