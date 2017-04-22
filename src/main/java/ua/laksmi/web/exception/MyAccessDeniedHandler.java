package ua.laksmi.web.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Dobriks on 23.04.2017.
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    private String errorPage;

    public MyAccessDeniedHandler() {
    }

    public MyAccessDeniedHandler(String errorPage) {
        this.errorPage = errorPage;
    }

    public String getErrorPage() {
        return errorPage;
    }

    public void setErrorPage(String errorPage) {
        this.errorPage = errorPage;
    }


    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException)
            throws IOException, ServletException {

        //do some business logic, then redirect to errorPage url
        response.sendRedirect(errorPage);

    }

}