package RestAssuredPratice.RestAssuredPra;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestAndResponseSpecificationDemo {

	public RequestSpecification RequestSpecCreation() {
		RequestSpecBuilder build= new RequestSpecBuilder();
		build.setBaseUri("http://ezifyautomationlabs.com:6565");
		build.setBasePath("/educative-rest/students");
		build.addQueryParam("gender", "male");
		RequestSpecification reqspc= build.build();
		
		return reqspc;
	}
	
	public ResponseSpecification ResponseSpecCreation() {
		
		ResponseSpecBuilder bulder = new ResponseSpecBuilder();
		bulder.expectStatusCode(200);
		
		ResponseSpecification respSpec = bulder.build();
		 return respSpec;
	}
	
	@Test
	
	public void SpecificationDemo() {
		RestAssured.given()
		.spec(RequestSpecCreation())
		.get()
		.then()
		.spec(ResponseSpecCreation());
	
	}
	
	
	
}
