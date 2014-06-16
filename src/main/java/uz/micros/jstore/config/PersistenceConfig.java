package uz.micros.jstore.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.beans.factory.annotation.Autowired;
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
        res.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        res.setProperty("hibernate.hbm2ddl.auto","update");
        res.setProperty("hibernate.show.sql","true");

            return res;
    }

    private DataSource getDataSource() {

        BasicDataSource res = new BasicDataSource();
        res.setDriverClassName("com.mysql.jdbc.Driver");
        res.setUrl("jdbc:mysql://localhost:3306/jstore");
        res.setUsername("root");
        res.setPassword("root");
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
