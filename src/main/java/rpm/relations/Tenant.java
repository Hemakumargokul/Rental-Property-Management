package rpm.relations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tenant {
	
	 private Long t_id;
	    private Long ssn;
	    private String email;
	    private String first_name;
	    private String last_name;
	    private String occupation;
	    private String phone_no;
	    private String tBranchID;
		public Long getT_id() {
			return t_id;
		}
		public void setT_id(Long t_id) {
			this.t_id = t_id;
		}
		public Long getSsn() {
			return ssn;
		}
		public void setSsn(Long ssn) {
			this.ssn = ssn;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public String getOccupation() {
			return occupation;
		}
		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}
		public String getPhone_no() {
			return phone_no;
		}
		public void setPhone_no(String phone_no) {
			this.phone_no = phone_no;
		}
		public String gettBranchID() {
			return tBranchID;
		}
		public void settBranchID(String tBranchID) {
			this.tBranchID = tBranchID;
		}
	    
	
}
