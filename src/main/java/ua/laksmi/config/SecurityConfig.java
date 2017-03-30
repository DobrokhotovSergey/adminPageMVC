package ua.laksmi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import ua.laksmi.web.dao.DaoRoles;
import ua.laksmi.web.domain.roles.EncryptionServise;
import ua.laksmi.web.domain.roles.Roles;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * Created by Dobriks on 9.03.2017.
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan({ "ua.laksmi.*" })
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource(name = "")
	DaoRoles d;
	EncryptionServise en = new EncryptionServise();


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
		for(Roles roles: d.getListRoles()){
			System.out.println(roles.getLogin() + ", " + en.decrypt(roles.getHashPsw()) + ", -->" + roles.getRole()+"<---");
			auth.inMemoryAuthentication().withUser(roles.getLogin()).password(en.decrypt(roles.getHashPsw())).roles("USER");
		}
		auth.userDetailsService(inMemoryUserDetailsManager());

	}
	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() throws Exception {
		final Properties users = new Properties();
		for(Roles roles: d.getListRoles()){
			users.put(roles.getLogin(),en.decrypt(roles.getHashPsw())+",ROLE_"+roles.getRole()+",enabled"); //add whatever other user you need
		}
		return new InMemoryUserDetailsManager(users);
	}
	//.csrf() is optional, enabled by default, if using WebSecurityConfigurerAdapter constructor
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.and()
				.formLogin().loginPage("/login").failureUrl("/login?error")
					.usernameParameter("username").passwordParameter("password")
				
			.and()
				.logout().logoutSuccessUrl("/login?logout")
			.and()
				.csrf(); 
		
	}
}