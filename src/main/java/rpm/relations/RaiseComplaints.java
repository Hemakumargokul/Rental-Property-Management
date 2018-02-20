package rpm.relations;

public class RaiseComplaints {
String first_name;
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
String last_name;
Long tenant_ID;
Long eSSN;
String type;
String status;
String description;
String raised_date;
String completion_date;
public Long getTenant_ID() {
	return tenant_ID;
}
public void setTenant_ID(Long tenant_ID) {
	this.tenant_ID = tenant_ID;
}
public Long geteSSN() {
	return eSSN;
}
public void seteSSN(Long eSSN) {
	this.eSSN = eSSN;
}
public String getType() {
	return type;
}
public void setType(String l) {
	this.type = l;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getRaised_date() {
	return raised_date;
}
public void setRaised_date(String raised_date) {
	this.raised_date = raised_date;
}
public String getCompletion_date() {
	return completion_date;
}
public void setCompletion_date(String completion_date) {
	this.completion_date = completion_date;
}


}
