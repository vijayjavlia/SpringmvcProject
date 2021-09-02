package misreportportal.service;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import misreportportal.conf.HibernateConf;
import misreportportal.dao.Daos;
import misreportportal.pojos.Subscription;
import misreportportal.singleton.Singleton;

@Service
public class Services {

    @Autowired
	public Daos dao;
	
    Singleton single=Singleton.getInstance();
	
    
	public List< Subscription> getServiceName()
	{
	
		return dao.getServices();
		
	}
	

	public String getMisReportData(String action) {
		
		
		return "hello";
		
	}
	
	
	
	
}
