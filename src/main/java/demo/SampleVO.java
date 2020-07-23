package demo;

public class SampleVO {
	
	private String firstName;
	private String lastName;
	private String gender;
	private String country;
	
	public SampleVO(String fname,String sname, String gender, String country) {
		this.firstName=fname;
		this.lastName=sname;
		this.gender=gender;
		this.country=country;
		
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
