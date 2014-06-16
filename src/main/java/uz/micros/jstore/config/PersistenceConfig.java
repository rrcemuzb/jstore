package uz.micros.jstore.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement

public class PersistenceConfig {
    @Value("${hibernate.dialect}")
    private String dialect;
    @Value("${hibernate.show_sql}")
    private String showql;
    @Value("${hibernate.update}")
    private String ddl;
    @Value("${jdbc.user}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driver}")
    private String driver;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean res = new LocalSessionFactoryBean();
        res.setDataSource(getDataSource());
        res.setPackagesToScan("uz.micros.jstore.entity.blog");
        res.setHibernateProperties(getProperties());
        return res;
    }

    private Properties getProperties() {
        Properties res = new Properties();
        res.setProperty("hibernate.dialect",dialect);
        res.setProperty("hibernate.hbm2ddl.auto",ddl);
        res.setProperty("hibernate.show_sql",showql);

            return res;
    }

    private DataSource getDataSource() {

        BasicDataSource res = new BasicDataSource();
        res.setDriverClassName(driver);
        res.setUrl(url);
        res.setUsername(username);
        res.setPassword(password);
            return res;
    }

    @Bean
    @Autowired

    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager res = new HibernateTransactionManager();
        res.setSessionFactory(sessionFactory);
        return res;
    }

}
