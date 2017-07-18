package ua.laksmi.config.core;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
/**
 * Created by Dobriks on 9.03.2017.
 */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    @Override
    protected boolean enableHttpSessionEventPublisher() {
        return true;
    }
}