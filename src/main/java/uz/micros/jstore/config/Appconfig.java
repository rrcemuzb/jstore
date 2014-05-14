package uz.micros.jstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "uz.micros.jstore")
public class Appconfig {

    /*@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver res = new InternalResourceViewResolver();
        res.setViewClass(JstlView.class);
        res.setPrefix("/WEB-INF/pages/");
        res.setSuffix(".jsp");

        return res;
    }
*/
}
