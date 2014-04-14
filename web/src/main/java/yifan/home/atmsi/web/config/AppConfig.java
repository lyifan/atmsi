package yifan.home.atmsi.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import org.apache.log4j.Logger;

@Configuration
@Lazy
@ComponentScan(basePackages={"yifan.home.atmsi.web"})
@EnableWebMvc
@PropertySource(value = "/WEB-INF/config/webapp.properties", ignoreResourceNotFound = true)
@PropertySource(value = "file:${ATMSI_CONF_DIR}/override-webapp.properties", ignoreResourceNotFound = true)
public class AppConfig {

	@Autowired
	private Environment _env;
	
	@Bean(name={"webLogger"})
	public Logger buildLog4jLogger() {
		return Logger.getLogger("home.atmsi.web");
	}

	@Bean
	@Autowired
	public ViewResolver buildViewResolver(@Qualifier("webLogger") Logger logger) {
		logger.debug(String.format("(%s)building ViewResolver.......", logger));
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
