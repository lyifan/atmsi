package yifan.home.atmsi.persist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.apache.log4j.Logger;

import yifan.home.atmsi.persist.dao.*;
import yifan.home.atmsi.persist.config.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-app-context.xml");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		PlannedJobDao plannedJobDao = ctx.getBean("plannedJobDao", PlannedJobDao.class);
		
		plannedJobDao.getById(1);

    }
}
