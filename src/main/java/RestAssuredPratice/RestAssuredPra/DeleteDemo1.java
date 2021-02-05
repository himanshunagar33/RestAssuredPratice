package RestAssuredPratice.RestAssuredPra;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteDemo1 {

	@Test
	public void DeleteDem() {
		
		String url="http://ezifyautomationlabs.com:6565/educative-rest/students/148";
		Response res= RestAssured.given().header("accept","application/json").header("content-type","application/json").delete(url).andReturn();
		System.out.println(res.getStatusCode());
		res.getBody().prettyPrint();
		assertTrue(res.getBody().prettyPrint().isEmpty());
		assertTrue(res.getStatusCode()==204,"Checked");
		
	}
}
