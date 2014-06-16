package uz.micros.jstore.config;


import org.hibernate.mapping.Property;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = "uz.micros.jstore")
@PropertySource("classpath:app.properties")
public class AppConfig {

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
        PropertyPlaceholderConfigurer res = new PropertyPlaceholderConfigurer();
        res.setLocation(new ClassPathResource("app.properties"));
        res.setIgnoreUnresolvablePlaceholders(true);
        return res;
    }
}

