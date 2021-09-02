package misreportportal.dao;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Repository;

import misreportportal.conf.HibernateConf;
import misreportportal.pojos.Subscription;
import misreportportal.singleton.Singleton;

@Repository
public class Daos {

	@Autowired
	HibernateConf conf;
	Session s = null;
	Transaction tr = null;

	Singleton single = Singleton.getInstance();

	
	public List<Subscription> getServices() {

		s = conf.sessionfactory.openSession();

		tr = s.beginTransaction();
	  
		Query<Subscription> query = s.createQuery("from Subscription");
		
		List<Subscription> list=query.list();
		
		s.close();
		return list;

	}


}
