package RestAssuredPratice.RestAssuredPra;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Employee {

	public Employee() {
		
	}
	public Employee(String firstName,String lastName, String gender) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.gender=gender;
	}
	
	 long id;
	
	
	@JsonProperty("first_name")
	String firstName;
	
	@JsonProperty("last_name")
	String lastName;
	
	String gender;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	
	public void setlastName(String lastName) {
		this.lastName=lastName;
	}
	public String getgender() {
		return gender;
	}
	
	public void setgender(String gender) {
		this.gender=gender;
	}
	@Override
	public String toString() {
		return String.format("Employee [id=%s, firstName=%s,lastname=%s, gender=%s ]" ,id,firstName,lastName,gender);
	}
	
}
