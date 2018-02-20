package rpm.relations;

public class LeaseExpiry {
private String Fname;
private String Lname;
private String SSN;
private String start_date;
private String end_date;
public String getFname() {
	return Fname;
}

public void setFname(String fname) {
	Fname = fname;
}
public String getLname() {
	return Lname;
}
public void setLname(String lname) {
	Lname = lname;
}
public String getSSN() {
	return SSN;
}
public void setSSN(String sSN) {
	SSN = sSN;
}
public String getStart_date() {
	return start_date;
}
public void setStart_date(String start_date) {
	this.start_date = start_date;
}
public String getEnd_date() {
	return end_date;
}
public void setEnd_date(String end_date) {
	this.end_date = end_date;
}
}
