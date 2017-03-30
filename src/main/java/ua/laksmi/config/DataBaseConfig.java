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
        URI dbUri = null;
        try {
            dbUri = new URI(System.getenv("DATABASE_URL"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();


        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        try {
            dataSource.setUrl(dbUrl);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
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
