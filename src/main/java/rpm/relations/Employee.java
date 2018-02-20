package rpm.relations;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    private Long ssn;
    private String first_name;
    private String last_name;
    private String Date;
    private String Salary;
    private String Join_Date;
    private String Designation;
    private String EBranchID;
    
    public Long getSSN() {
		return ssn;
	}
	public void setSSN(Long ssn) {
		this.ssn = ssn;
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
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getSalary() {
		return Salary;
	}
	public void setSalary(String salary) {
		Salary = salary;
	}
	public String getJoin_Date() {
		return Join_Date;
	}
	public void setJoin_Date(String join_Date) {
		Join_Date = join_Date;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getEBranchID() {
		return EBranchID;
	}
	public void setEBranchID(String eBranchID) {
		EBranchID = eBranchID;
	}
	
    
}