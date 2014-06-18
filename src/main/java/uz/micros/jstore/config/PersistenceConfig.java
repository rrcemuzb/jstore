package uz.micros.jstore.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "uz.micros.jstore.repository")
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
  public EntityManagerFactory entityManagerFactory(){
      LocalContainerEntityManagerFactoryBean res = new LocalContainerEntityManagerFactoryBean();
      res.setPackagesToScan("uz.micros.jstore.entity.blog");
      res.setDataSource(getDataSource());
      res.setJpaProperties(getProperties());
      res.setJpaVendorAdapter(getJpaVendorAdapter());
      res.afterPropertiesSet();
      return res.getObject();

  }

    private JpaVendorAdapter getJpaVendorAdapter() {
        HibernateJpaVendorAdapter res = new HibernateJpaVendorAdapter();
        res.setShowSql(Boolean.valueOf(showql));
        res.setGenerateDdl(true);
        res.setDatabase(Database.MYSQL);
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
     public PlatformTransactionManager transactionManager(){
        JpaTransactionManager res = new JpaTransactionManager();
        res.setEntityManagerFactory(entityManagerFactory());
        return res;
    }

}
