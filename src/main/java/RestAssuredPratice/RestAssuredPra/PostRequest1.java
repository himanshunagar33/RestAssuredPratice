package RestAssuredPratice.RestAssuredPra;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;


//class student{
//	String firstname;
//	String lastname;
//	String gender;
//	
//	public student(String firstname,String lastname,String gender) {
//		this.firstname=firstname;
//		this.lastname=lastname;
//		this.gender=gender;
//	}
//	
//    @JsonProperty("id")
//    Long id;
//
//    @JsonProperty("first_name")
//    String firstName;
//
//    @JsonProperty("last_name")
//    String lastName;
//
//    @JsonProperty("gender")
//    String Gender;
//	
//}

public class PostRequest1 {

	@Test (enabled=false)
	public void SimplePost() {
		
		String url= "http://ezifyautomationlabs.com:6565/educative-rest/students";
		String body = "{\"first_name\": \"Jack\", \"last_name\": \"Preacher\", \"gender\": \"Male\" }";
		
		Response res= RestAssured.given()
				.header("accept","application/json")
				.header("content-type","application/json")
				.body(body)
				.post(url)
				.andReturn();
		
		assertEquals(res.getStatusCode(),201,"Status Code check");
		res.getBody().prettyPrint();
	
	}
	
	
	@Test
	public void PojoPost() {
		
		String url="http://ezifyautomationlabs.com:6565/educative-rest/students";
		Student body = new Student("Himanshu","Nagar","Male");
		Response rep= RestAssured.given()
				.body(body)
				.header("content-type","Application/json")
				.header("accept","Application/json")
				.post(url)
				.thenReturn();
		assertTrue(rep.getStatusCode()==201,"status checked");
		rep.getBody().prettyPrint();
		}
	
	
}


