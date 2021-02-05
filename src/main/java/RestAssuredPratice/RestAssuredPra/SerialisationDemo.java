package RestAssuredPratice.RestAssuredPra;

import java.io.IOException;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SerialisationDemo {

	private static final ObjectMapper Mapper= new ObjectMapper();
	private Integer id;
	@Test 	
	public void demoSerial() throws IOException {
		
	Employee emp = new Employee("Sdasasde", "Bghjaskadil", "Female");
	
	byte[] data= Mapper.writeValueAsBytes(emp);
	String json= Mapper.writeValueAsString(emp);
	System.out.println(json);
	
	String bdyInJson="{\"id\":0,\"gender\":\"Female\",\"first_name\":\"Sqwam\",\"last_name\":\"Baileasy\"}";
	
	String url= "http://ezifyautomationlabs.com:6565/educative-rest/students";
	Response res = RestAssured.given()
			.contentType("Application/json")
			//.header("content-type","Application/json")
			//.header("accept","Application/json")
			.log().all(true)
			.accept("Application/json")
			.body(json)
			.post(url)
			.andReturn();
		
		res.getBody().prettyPrint();
		id = res.path("id");
		
		
	}
	
}
