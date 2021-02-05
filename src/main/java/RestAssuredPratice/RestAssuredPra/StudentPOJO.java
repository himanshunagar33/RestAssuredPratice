package RestAssuredPratice.RestAssuredPra;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentPOJO {

	public StudentPOJO(String firstname, String lastname, String gender) {
		this.firstname=firstname;
		this.lastname=lastname;
		this.gender=gender;
	}
	@JsonProperty("id")
	long id;
	
	@JsonProperty("first_name")
	String firstname;
	
	@JsonProperty("last_name")
	String lastname;
	
	@JsonProperty("gender")
	String gender;
}
