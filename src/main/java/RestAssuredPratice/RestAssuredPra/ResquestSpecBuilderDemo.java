package RestAssuredPratice.RestAssuredPra;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResquestSpecBuilderDemo {

	public RequestSpecification getrequestspc() {
		RequestSpecBuilder builder= new RequestSpecBuilder();
		builder.setBaseUri("http://ezifyautomationlabs.com:6565");
		builder.setBasePath("/educative-rest/students");
		
		RequestSpecification requestspec= builder.build();
		return requestspec;
	}
	
	@Test(enabled=false)
	public void getRequestwithRequestBuilder() {
		Response res = RestAssured.given().spec(getrequestspc())
				.queryParam("first_name", "John")
				.get();
		
		System.out.println(res.getStatusCode());
		res.getBody().prettyPrint();
	}
	
	@Test 
	public void getRequestdemoBuilder() {
		Response rep= RestAssured.given()
				.spec(getrequestspc())
				.get("/132");
		
		rep.getBody().prettyPrint();
	}
	
	@Test
	public void getRequestdemoBuilderCheck() {
		Response reps= RestAssured.given()
				.spec(getrequestspc())
				.get()
				.andReturn();
		
		reps.getBody().prettyPrint();
	}
	
}
