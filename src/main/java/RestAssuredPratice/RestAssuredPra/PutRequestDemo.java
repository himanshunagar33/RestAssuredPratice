package RestAssuredPratice.RestAssuredPra;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PutRequestDemo {

	@Test
	public void PutReq() {
		String URl = " http://ezifyautomationlabs.com:6565/educative-rest/students/106";
		Student body1= new Student("Neha","Nagar","Female");
		body1.id=(long) 106;
		Response reps = RestAssured.given()	
						.header("accept","application/json")
						.header("content-type","application/json")
						.body(body1)
						.put(URl)
						.andReturn();
	
			reps.getBody().prettyPrint();
			assertTrue(reps.getStatusCode()==200,"Check Status code failed");
				
	}
	
}



class Student {
	
		
		public Student(String firstname,String lastname,String gender) {
			this.firstName=firstname;
			this.lastName=lastname;
			this.Gender=gender;
		}
		
	    @JsonProperty("id")
	    Long id;

	    @JsonProperty("first_name")
	    String firstName;

	    @JsonProperty("last_name")
	    String lastName;

	    @JsonProperty("gender")
	    String Gender;
		
	}


