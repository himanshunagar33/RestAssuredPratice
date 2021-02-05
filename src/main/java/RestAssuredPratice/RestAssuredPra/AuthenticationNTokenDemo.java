package RestAssuredPratice.RestAssuredPra;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.http.auth.AUTH;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthenticationNTokenDemo {

	@Test
	public void basicAuthoValidUser() {
		String url="http://ezifyautomationlabs.com:6565/educative-rest/auth/students";
		String username="testuser";
		String Password="testpass";
		Response resp = RestAssured
					.given()
					.auth().basic(username, Password)
					.when()
					.get(url)
					.andReturn();
		assertTrue(resp.getStatusCode()==200);
		resp.getBody().prettyPrint();
		
	}
	
	@Test
	public void basicAuthoInvalidUser() {
		String url="http://ezifyautomationlabs.com:6565/educative-rest/auth/students";
		String username="timepass";
		String Password="timpass";
		Response res = RestAssured
				.given()
				.auth().basic(username, Password)
				.when()
				.get(url)
				.andReturn();
	assertEquals(res.getStatusCode(), 200,"Invalid credentials");
	res.getBody().prettyPrint();
	
	}
	
	@Test 
	public void tokenBaseAuthenticationDemo() {
		String url="http://ezifyautomationlabs.com:6565/educative-rest/auth/students";
		String Token="Basic dGVzdHVzZXI6dGVzdHBhc3M=";
		Response respnse= 	RestAssured
							.given()
							.header("authorization", Token)
							.when()
							.get(url).andReturn();
		
		assertEquals(respnse.getStatusCode(), 200," token is invalid");
		respnse.getBody().prettyPrint();
							
							
	}
	
}
