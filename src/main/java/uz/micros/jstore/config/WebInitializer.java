package uz.micros.jstore.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
        rootCtx.register(Appconfig.class);

        container.addListener(new ContextLoaderListener(rootCtx));

        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher",new DispatcherServlet(rootCtx));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
    }
}
