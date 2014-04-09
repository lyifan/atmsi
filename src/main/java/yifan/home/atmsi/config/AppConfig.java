package yifan.home.atmsi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import org.apache.log4j.Logger;

@Configuration
@ComponentScan(basePackages="yifan.home.atmsi")
@EnableWebMvc
public class AppConfig {
	
	@Bean(name={"log4jLogger"})
	public Logger buildLog4jLogger() {
		return Logger.getLogger("home.atmsi");
	}
	
	@Bean
	public ViewResolver buildViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
