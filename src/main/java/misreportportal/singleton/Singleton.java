package misreportportal.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

public class Singleton {

	
	private static Singleton singletone=null;
	
	private String s="Singleton Intiate";
	private Singleton()
	{
		System.out.println(s);
	}
	
	private void init() {
	
	singletone=	new Singleton();

	}
	
	public static Singleton getInstance()
	{
		if(singletone==null)
		{
			singletone=new Singleton();
		}
		
		return singletone;
	}
	
	public  String getProperty(String key)
	{
		String str=null;
		try {
			if(key==null || key=="")
			{
				throw new NullPointerException("String is null ");
			}
			ClassLoader loader=Thread.currentThread().getContextClassLoader();
            URL url=loader.getResource("action.properties");
			Properties prop=new Properties();
			prop.load(url.openStream());
		    str=prop.getProperty(key);
//			System.out.println(str);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return str;
		
	}
	
}
