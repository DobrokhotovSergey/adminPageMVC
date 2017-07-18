package ua.laksmi.config.core;

import ua.laksmi.config.AppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ua.laksmi.config.DataBaseConfig;

import javax.servlet.ServletRegistration;

/**
 * Created by Dobriks on 9.03.2017.
 */
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class, DataBaseConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		boolean done = registration.setInitParameter("throwExceptionIfNoHandlerFound", "true"); // -> true
		if(!done) throw new RuntimeException();
	}
}