package RestAssuredPratice.RestAssuredPra;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequestExperiment {

	@Test(enabled=false)
	// for getting all the records and looking for a specific student ID
	
	public void RequestOne() {
		
		String URL= "http://ezifyautomationlabs.com:6565/educative-rest/students" ;
		
		Response Res= RestAssured.given().get(URL).andReturn();
		
		Res.getBody().prettyPrint();
		
		assertEquals(Res.getStatusCode(), 200, "Status code check");
		
		assertTrue(Res.getBody().jsonPath().getList("id").contains(101));
	}
	
	
	@Test
	
	public void GetSpecificRecord() {
		String url= "http://ezifyautomationlabs.com:6565/educative-rest/students";
		String url1= url+"/100";
		Response res= RestAssured
				.given()
				.get(url1)
				.andReturn();
		
		res.getBody().prettyPrint();
		String name= res.jsonPath().getString("first_name");
		int id= res.jsonPath().getInt("id");
		String gen= res.jsonPath().getString("gender");
		System.out.println(" Name is :" + name +" " + id+ "  "+ gen);
		//res.getBody().print();
		
		
		Response resp= RestAssured.given().queryParam("gender","male").get(url).andReturn();
		resp.getBody().prettyPrint();
		
	}
	
}
