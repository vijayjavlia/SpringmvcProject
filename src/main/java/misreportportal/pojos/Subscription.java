package misreportportal.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_subscription")
public class Subscription {

	@Id
	private String ani;
	private String sub_date_time;
	private String next_billed_date;
	private String last_billed_date;
	private String m_act;
	private String service_type;
	private String default_amount;
	public String getAni() {
		return ani;
	}
	public void setAni(String ani) {
		this.ani = ani;
	}
	public String getSub_date_time() {
		return sub_date_time;
	}
	public void setSub_date_time(String sub_date_time) {
		this.sub_date_time = sub_date_time;
	}
	public String getNext_billed_date() {
		return next_billed_date;
	}
	public void setNext_billed_date(String next_billed_date) {
		this.next_billed_date = next_billed_date;
	}
	public String getLast_billed_date() {
		return last_billed_date;
	}
	public void setLast_billed_date(String last_billed_date) {
		this.last_billed_date = last_billed_date;
	}
	public String getM_act() {
		return m_act;
	}
	public void setM_act(String m_act) {
		this.m_act = m_act;
	}
	public String getService_type() {
		return service_type;
	}
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}
	public String getDefault_amount() {
		return default_amount;
	}
	public void setDefault_amount(String default_amount) {
		this.default_amount = default_amount;
	}
	
	
	
	
	
	
	
}
