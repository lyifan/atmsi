package yifan.home.atmsi.persist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import yifan.home.atmsi.persist.config.AppConfig;
import yifan.home.atmsi.persist.dao.PlannedJobDao;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("resource")
	public static void main( String[] args )
    {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-app-context.xml");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		PlannedJobDao plannedJobDao = ctx.getBean("plannedJobDao", PlannedJobDao.class);
		
		plannedJobDao.getById(1);

    }
}
