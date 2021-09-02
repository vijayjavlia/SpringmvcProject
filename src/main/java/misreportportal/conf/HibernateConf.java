package misreportportal.conf;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import misreportportal.singleton.Singleton;

@Component
public class HibernateConf {

	public static SessionFactory sessionfactory;

	  @Bean
	public static SessionFactory getSession() {
		if (sessionfactory == null) {
			sessionfactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return sessionfactory;
	}
//	  @Bean
//	public static SessionFactory getSafariSession() {
//		if (sessionfactory == null) {
//			sessionfactory = new Configuration().configure("safaricom.cfg.xml").buildSessionFactory();
//		}
//		return sessionfactory;
//	}
//	  @Bean
//	public static SessionFactory getTigoSession() {
//		if (sessionfactory == null) {
//			sessionfactory = new Configuration().configure("tigo.cfg.xml").buildSessionFactory();
//		}
//		return sessionfactory;
//	}
//	  
//	public static SessionFactory getZgamesSession() {
//		if (sessionfactory == null) {
//			sessionfactory = new Configuration().configure("zgames.cfg.xml").buildSessionFactory();
//		}
//		return sessionfactory;
//	}

//	public static void main(String[] args) {
//	
//     	Session	s=getTigoSession().openSession();
//		Transaction tr=s.beginTransaction();
//		 String query="SELECT COUNT(1),DATE(sub_date_time),service_type FROM tigo.tbl_subscription  WHERE  DATE(sub_date_time)=DATE(SUBDATE(NOW(),1))GROUP BY 3 ";
//		 
//		                   NativeQuery<Object[]> q = s.createNativeQuery(query);
//		                                  List <Object[]>list = q.list();
//		                                  for (Object [] ob:list) {
//											System.out.println(Arrays.toString(ob));
//										}
//		                                  		                                                      		                                  
//		                                  list.forEach(e->System.out.println(e));		 
		 
//		}

}
