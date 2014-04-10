package yifan.home.atmsi.persist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.apache.log4j.Logger;

import yifan.home.atmsi.persist.bo.*;
import yifan.home.atmsi.persist.config.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring-app-context.xml");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		PlannedJobService plannedJobService = ctx.getBean("plannedJobService", PlannedJobService.class);
		
		plannedJobService.save(args[0]);

    }
}
