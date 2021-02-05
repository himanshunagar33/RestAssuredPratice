package RestAssuredPratice.RestAssuredPra;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class IntegrationTestDemo {

	static {
	    RestAssured.filters(new io.qameta.allure.restassured.AllureRestAssured());
	}
	
	@Test 
	public void part1Create() {
		
		// Post Request to create a student
			String url ="http://ezifyautomationlabs.com:6565/educative-rest/students";
			StudentPOJO std= new StudentPOJO("Kim","Nagar","Male");
			Response response =   	RestAssured.given()
									.header("accept","application/json")
									.header("content-type","application/json")
									.body(std)
									.post(url)
									.andReturn();
		
			assertEquals(response.getStatusCode(),201,"status code check failed");
			response.getBody().prettyPrint();
			long id= response.getBody().jsonPath().getLong("id");
				// print all the headers present in the response
			String headers=response.getHeaders().toString();
			System.out.println(headers);
			
		// Get to request to verify the Student is created
			
			Response getresp= 	RestAssured.given()
								.get(url+"/"+id)
								.andReturn();
			assertEquals(getresp.getStatusCode(), 200,"Status check failed");
			response.getBody().prettyPrint();
			
			assertEquals(getresp.getBody().jsonPath().getLong("id"), id, "ID mismatch issue");
			
		// delete the Created student record
			
			Response deleteResp= RestAssured.given()
								.given()
								.delete(url+"/"+id)
								.andReturn();
			
			assertEquals(deleteResp.getStatusCode(), 204,"status code mismatch");
			deleteResp.getBody().prettyPrint();
		
	    // Verify the record is deleted 
			
			ResponseOptions<?> delresp= RestAssured.given()
										.get(url+"/"+id)
										.andReturn();
			assertEquals(delresp.getStatusCode(),404, "record is not deleted");
			String dheaders=delresp.getHeaders().toString();
			System.out.println(dheaders);
		}
	
	
	
}
