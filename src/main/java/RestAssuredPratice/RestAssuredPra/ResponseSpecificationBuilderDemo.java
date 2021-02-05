package RestAssuredPratice.RestAssuredPra;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.anything;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationBuilderDemo {

	public ResponseSpecification getResponseSpecDemo() {
		ResponseSpecBuilder builder= new ResponseSpecBuilder();
		builder.expectStatusCode(200);
		
		ResponseSpecification respSpec= builder.build();
		return respSpec;
	}
	
	@Test
	
	public void builderDemoResponse() {
		 RestAssured.given()
				.get("http://ezifyautomationlabs.com:6565/educative-rest/students")
				.then()
				.spec(getResponseSpecDemo()).body("john", is(anything()));
		
	}
	
}
