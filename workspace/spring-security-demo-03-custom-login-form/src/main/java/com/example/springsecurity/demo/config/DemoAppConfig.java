package com.example.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.example.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
  private Logger logger = Logger.getLogger(getClass().getName());

  @Autowired
  private Environment env;

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/view/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }
  
  @Bean
  public DataSource securityDataSource() {
    ComboPooledDataSource securityDataSource =
        new ComboPooledDataSource();
    
    // Set jdbc driver
    try {
      securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
    } catch (PropertyVetoException e) {
      throw new RuntimeException(e);
    }
    
    // Set jdbc url/user/password 
    String jdbcUrl = env.getProperty("jdbc.url");
    String jdbcUser = env.getProperty("jdbc.user");
    String jdbcPassword = env.getProperty("jdbc.password");
    logger.info(">>> jdbc.url=" + jdbcUrl);
    logger.info(">>> jdbc.user=" + jdbcUser);
    logger.info(">>> jdbc.password=" + jdbcPassword);
    securityDataSource.setJdbcUrl(jdbcUrl);
    securityDataSource.setUser(jdbcUser);
    securityDataSource.setPassword(jdbcPassword);

    // Set poolsize properties and stuff
    securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
    securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
    securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
    securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

    return securityDataSource;
  }
  
  private int getIntProperty(String propName) {
    String propVal  = env.getProperty(propName);
    return Integer.parseInt(propVal);
  }
}