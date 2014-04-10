package yifan.home.atmsi.persist.config;

import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import org.apache.commons.dbcp2.BasicDataSource;

import org.apache.log4j.Logger;

@Configuration
@ComponentScan(basePackages={"yifan.home.atmsi.persist"})
@PropertySource("classpath:config/hibernate.properties")
@PropertySource(value = "file:${ATMSI_CONF_DIR}/override-hibernate.properties", ignoreResourceNotFound = true)
public class AppConfig {
	
	@Bean(name="log4jLogger")
	public Logger buildLogger() {
		return Logger.getLogger("home.atmsi.persist");
	}
	
	@Bean(name="dataSource", destroyMethod="close")
	@Autowired
    public DataSource buildDataSource(Environment env) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
    
    @Bean(name="hibernateSessionFactory")
	@Autowired
    public FactoryBean<SessionFactory> buildHibernateSessionFactoryBean(DataSource dataSource, Environment env) {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan("yifan.home.atmsi.persist.domain");

		Properties properties = new Properties();

		properties.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		properties.setProperty("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));

		factoryBean.setHibernateProperties(properties);

		return factoryBean;
    }
    	
}
