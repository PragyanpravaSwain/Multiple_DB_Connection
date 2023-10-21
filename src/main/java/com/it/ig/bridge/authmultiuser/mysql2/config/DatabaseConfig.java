package com.it.ig.bridge.authmultiuser.mysql2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "db2entityManagerFactoryBean",
        basePackages = "com.it.ig.bridge.authmultiuser.mysql2",
        transactionManagerRef = "db2transactionManager"
)
public class DatabaseConfig {
    @Value("${spring.db2.datasource.url}")
    private String url;
    @Value("${spring.db2.datasource.username}")
    private String username;
    @Value("${spring.db2.datasource.password}")
    private String password;
    @Value("${spring.db2.datasource.driver.class.name}")
    private String driverClassName;

    @Bean(name = "secondDataSource")
    @Primary
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);

        return dataSource;
    }
    @Bean(name = "db2entityManagerFactoryBean")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource());

        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(adapter);

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.ddl.auto", "update");
        bean.setJpaPropertyMap(props);

        bean.setPackagesToScan("com.it.ig.bridge.authmultiuser.mysql2.entities");

        return bean;
    }
    @Bean(name = "db2transactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return manager;
    }

}

