package misreportportal.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_billing_success")
public class Billing {
	
	@Id
	private String ani;
	private String Deducted_amount;
	private String type_event;
	private String process_datetime;
	private String servicename;
	
	public String getAni() {
		return ani;
	}
	public void setAni(String ani) {
		this.ani = ani;
	}
	public String getDeducted_amount() {
		return Deducted_amount;
	}
	public void setDeducted_amount(String deducted_amount) {
		Deducted_amount = deducted_amount;
	}
	public String getType_event() {
		return type_event;
	}
	public void setType_event(String type_event) {
		this.type_event = type_event;
	}
	public String getProcess_datetime() {
		return process_datetime;
	}
	public void setProcess_datetime(String process_datetime) {
		this.process_datetime = process_datetime;
	}
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	
	

}
