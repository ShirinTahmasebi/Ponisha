package ir.ac.sbu.springponisha.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class UserApplicationInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        sc.addListener(new ContextLoaderListener(appContext));
    }
}