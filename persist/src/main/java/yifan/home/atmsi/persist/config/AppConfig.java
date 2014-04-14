package yifan.home.atmsi.persist.config;

import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@Lazy
@ComponentScan(basePackages={"yifan.home.atmsi.persist"})
@EnableTransactionManagement
@PropertySource("classpath:config/hibernate.properties")
@PropertySource(value = "file:${ATMSI_CONF_DIR}/override-hibernate.properties", ignoreResourceNotFound = true)
public class AppConfig {

/*	
	@Autowired
	@Qualifier("persistLogger")
	private Logger _logger;
*/	
	@Bean(name="persistLogger")
	public Logger buildLogger() {
		return Logger.getLogger("home.atmsi.persist");
	}
	
	// Register DataSource bean
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
    
    // Register Hibernate SessionFactory bean
    @Bean(name="hibernateSessionFactory")
	@Autowired
    public FactoryBean<SessionFactory> buildHibernateSessionFactoryBean(DataSource dataSource, Environment env, @Qualifier("persistLogger")Logger logger) {
    
   		logger.info("building Hibernate SessionFactory...");
    
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
 
 	// Register HibernateTransactionManager bean
 	@Bean
 	@Autowired
 	public PlatformTransactionManager buildHibernateTransactionManager(@Qualifier("hibernateSessionFactory")FactoryBean<SessionFactory> sessionFactoryBean, @Qualifier("persistLogger")Logger logger) {
		HibernateTransactionManager txMgr = new HibernateTransactionManager();
		try {
			SessionFactory hibernateSessionFactory = sessionFactoryBean.getObject();
			if(hibernateSessionFactory == null) {
				throw new Exception("hibernateSessionFactory bean is null.");
			}
			txMgr.setSessionFactory(hibernateSessionFactory);
		}catch(Exception ex) {
			logger.error("Failed to build HibernateTransactionManager", ex);
		}
		
		logger.info("HibernateTransactionManager built successfully");
		
		return txMgr;
 	}
 	
}
