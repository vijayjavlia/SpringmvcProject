package misreportportal.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.collections4.Get;
import org.apache.poi.util.SystemOutLogger;
import org.hibernate.internal.build.AllowSysOut;

public class CreateReport {
	
	public static Connection con=getDatabse(),con57=getDatabse57(),zcon=getDatabseZg();
	
	public static void main(String[] args) {
		gamedubai();
		zgames();
	}

	public static void gamedubai() {
		
		try {

		String nesubs = "SELECT COUNT(1) , DATE(SUBDATE(NOW(),1)) FROM 9mob_dubai.tbl_billing_success WHERE DATE(PROCESS_DATETIME) = DATE(SUBDATE(NOW(),1)) AND TYPE_EVENT = 'SUB' ";

		String ren = "SELECT COUNT(1) FROM 9mob_dubai.tbl_billing_success WHERE DATE(PROCESS_DATETIME) = DATE(SUBDATE(NOW(),1)) AND TYPE_EVENT = 'REN'  ";

		String nesubsrev = "SELECT COUNT(1), SUM(DEDUCTED_AMOUNT), SUM(DEDUCTED_AMOUNT)/100 FROM 9mob_dubai.tbl_billing_success WHERE DATE(PROCESS_DATETIME) = DATE(SUBDATE(NOW(),1)) AND TYPE_EVENT = 'SUB'";

		String renrev = "SELECT COUNT(1), SUM(DEDUCTED_AMOUNT), SUM(DEDUCTED_AMOUNT)/100 FROM 9mob_dubai.tbl_billing_success WHERE DATE(PROCESS_DATETIME) = DATE(SUBDATE(NOW(),1)) AND TYPE_EVENT = 'REN' ";

		String churn = "SELECT COUNT(1) FROM 9mob_dubai.tbl_subscription_unsub WHERE DATE(unsub_date_time) = DATE(SUBDATE(NOW(),1)) ";
		
		
		double newsubs=0,rencount=0,newsubrev=0,renrevn=0;
		String date="";
		int churncount=0;
		ResultSet rs1=getResultSet(nesubs,con);		
		ResultSet rs2=getResultSet(ren,con);
		ResultSet rs3=getResultSet(nesubsrev,con);		
		ResultSet rs4=getResultSet(renrev,con);
		ResultSet rs5=getResultSet(churn,con);	
		
		
		if (rs1.next())
			newsubs = rs1.getDouble(1); date=rs1.getString(2);
		if (rs2.next())
			rencount = rs2.getDouble(1);
		if (rs3.next())
			newsubrev = rs3.getDouble(3);
		if (rs4.next())
			renrevn = rs4.getDouble(3);
		if (rs5.next())
			churncount = rs5.getInt(1);
		
		double total=newsubrev+renrevn;
		String insert="insert into tbl_gamedubai (date,newsubscriptioncount,renewalcount,newsubscriptionrevenue,renewalrevenue,totalrevenue_inaed,totalrevenue_inusd,totalrevenue_ininr,revenueshare_inaed,churn) values(?,?,?,?,?,?,?,?,?,?)";
		String insertsummary="insert into tbl_dubai_summry (date,newsubscription_count,renewal_count,renewal_revenue,total_revenue_inaed,genrosysrevenue_inaed)values(?,?,?,?,?,?)";
		PreparedStatement ps=con57.prepareStatement(insert);

		PreparedStatement pst=con57.prepareStatement(insertsummary);
		
		ps.setString(1, date);
		ps.setDouble(2, newsubs);
		ps.setDouble(3, rencount);
		ps.setDouble(4, newsubrev);
		ps.setDouble(5, renrevn);
		ps.setDouble(6, total);
		ps.setDouble(7, total*0.27);
		ps.setDouble(8, total*0.27*71);
		ps.setDouble(9, total*48.6/100);
		ps.setInt(10, churncount);
		
		pst.setString(1, date);
		pst.setDouble(2, newsubs);
		pst.setDouble(3, rencount);
		pst.setDouble(4, total);
		pst.setDouble(5, total);
		pst.setDouble(6, total*48.6/100);
		
		
		String check="SELECT COUNT(1) FROM tbl_gamedubai  WHERE DATE(DATE)=DATE(SUBDATE(NOW(),1))";
		PreparedStatement ps1=con57.prepareStatement(check);
		ResultSet rs=ps1.executeQuery();
		rs.next();
		
		if(rs.getInt(1)==0)
		{
			
		ps.executeUpdate();
		System.out.println(insert);
		
		pst.executeUpdate();
		System.out.println(insertsummary);
		
		
		}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}
	
	
	public static void zgames()
	{
		
		try {
			String totalbase="SELECT COUNT(1) ,DATE(SUBDATE(NOW(),1)) FROM tbl_subscription WHERE DATE(sub_date_time)<= DATE(SUBDATE(NOW(),1))";
			String subscount="SELECT COUNT(1),type_event  FROM tbl_billing_success WHERE DATE(process_datetime)= DATE(SUBDATE(NOW(),1))  GROUP BY 2";
			String newsubsrevn="SELECT COUNT(1),DEDUCTED_AMOUNT FROM tbl_billing_success WHERE DATE(process_datetime) = DATE(SUBDATE(NOW(),1)) AND TYPE_EVENT='SUB' GROUP BY DEDUCTED_AMOUNT";
			String renrevn="SELECT COUNT(1), DEDUCTED_AMOUNT FROM TBL_BILLING_SUCCESS WHERE DATE (PROCESS_DATETIME)=DATE(SUBDATE(NOW(),1)) AND TYPE_EVENT='REN' GROUP BY DEDUCTED_AMOUNT";
			String churn="SELECT COUNT(1),m_deact FROM tbl_subscription_unsub WHERE DATE(unsub_date_time) = DATE(SUBDATE(NOW(),1)) GROUP BY 2 ";
			
		
			long newsubcount=0,rencount=0,newsub150=0,newsub30=0,ren150=0,ren30=0,ccurl=0,ussd=0,sms=0,totalcount=0,totalchurn=0;
			String date="";
			long totalnewsubrevn=0,totalrenrevn=0,totalrevn=0;
			ResultSet rs1=getResultSet(totalbase, zcon);
			ResultSet rs2=getResultSet(subscount, zcon);
			ResultSet rs3=getResultSet(newsubsrevn, zcon);
			ResultSet rs4=getResultSet(renrevn, zcon);
			ResultSet rs5=getResultSet(churn, zcon);
			rs1.next();
			totalcount=rs1.getLong(1);
			date=rs1.getString(2);
			while(rs2.next())
			{
              if(rs2.getString(2).equalsIgnoreCase("ren")) rencount=rs2.getLong(1);
              else newsubcount=rs2.getLong(1);
			}
			
			while(rs3.next())
			{
				
				if(rs3.getString(2).equalsIgnoreCase("150")) newsub150=rs3.getLong(1);
				else newsub30=rs3.getLong(1);
			}
			
			while(rs4.next())
			{
				
				if(rs4.getString(2).equalsIgnoreCase("150")) ren150=rs4.getLong(1);
				else ren30=rs4.getLong(1);
			}
			
			while(rs5.next())
			{
				
				if(rs5.getString(2).equalsIgnoreCase("ccurl")) ccurl=rs5.getLong(1);
				else if(rs5.getString(2).equalsIgnoreCase("ussd")) ussd=rs5.getLong(1);
				else if(rs5.getString(2).equalsIgnoreCase("sms")) sms=rs5.getLong(1);
				
			}
			
			totalnewsubrevn=newsub150*150+newsub30*30;
			totalrenrevn=ren150*150+ren30*30;
			totalrevn=totalnewsubrevn+totalrenrevn;
			totalchurn=sms+ussd+ccurl;
			
			String insert="insert into tbl_zgames (date,total_base,newsubs_count,renewal_count,newsubs_150,newsubs_30,total_newsubrevenue,renewal_150,renewal_30,total_renewalrevenue,total_revenue_incfa,ccurl_churn,sms_churn,ussd_churn,total_churn)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            String insertsummary="insert into tbl_zgames_summary (date,total_base,newsubs_count,renewal_count,newsubs_revenue,renewal_revenue,total_revenue_incfa)values(?,?,?,?,?,?,?)";
			
			PreparedStatement ps=con57.prepareStatement(insert);
			PreparedStatement pst=con57.prepareStatement(insertsummary);
			ps.setString(1, date);
			ps.setLong(2, totalcount);
			ps.setLong(3, newsubcount);
			ps.setLong(4, rencount);
			ps.setLong(5, newsub150);
			ps.setLong(6, newsub30);
			ps.setLong(7, totalnewsubrevn);
			ps.setLong(8, ren150);
			ps.setLong(9, ren30);
			ps.setLong(10, totalrenrevn);
			ps.setLong(11, totalrevn);
			ps.setLong(12, ccurl);
			ps.setLong(13, sms);
			ps.setLong(14, ussd);
			ps.setLong(15, totalchurn);
			
			pst.setString(1, date);
			pst.setLong(2, totalcount);
			pst.setLong(3,newsubcount);
			pst.setLong(4, rencount);
			pst.setLong(5, totalnewsubrevn);
			pst.setLong(6, totalrenrevn);
			pst.setLong(7, totalrevn);
			
			String check="SELECT COUNT(1) FROM tbl_zgames  WHERE DATE(DATE)=DATE(SUBDATE(NOW(),1)) ";
			ResultSet rs=getResultSet(check, con57);
			rs.next();
			if(rs.getInt(1)==0)
			{
			pst.executeUpdate();
			System.out.println(insertsummary);
			ps.executeUpdate();
			System.out.println(insert);
	}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

	private static ResultSet getResultSet(String query ,Connection con)
	{

		ResultSet rs = null;
		try {

			PreparedStatement ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			System.out.println(query);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return rs;

	}

	public static Connection getDatabse() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ndoto?serverTimezone=UTC&autoReconnect=true", "root","gloadmin123");
//			
			conn = DriverManager.getConnection(
					"jdbc:mysql://5.189.169.12:3306/9mob_dubai?serverTimezone=UTC&autoReconnect=true", "root",
					"gloadmin123");
			System.out.println("gamedubai DB connected");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection getDatabseZg() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nigerorange?serverTimezone=UTC&autoReconnect=true", "root","gloadmin123");
//			
			conn = DriverManager.getConnection(
					"jdbc:mysql://5.189.146.57:3306/nigerorange?serverTimezone=UTC&autoReconnect=true", "root","genr@&y&123");
			System.out.println("nigerorange DB connected");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection getDatabse57() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/misreport?serverTimezone=UTC&autoReconnect=true", "root","genr@&y&123");
//			
			conn = DriverManager.getConnection(
					"jdbc:mysql://5.189.146.57:3306/misreport?serverTimezone=UTC&autoReconnect=true", "root","genr@&y&123");
			
			System.out.println("misreport DB connected");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	
	
	
	
	

}
