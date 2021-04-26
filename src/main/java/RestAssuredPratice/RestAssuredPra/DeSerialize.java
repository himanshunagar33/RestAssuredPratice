package RestAssuredPratice.RestAssuredPra;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import org.testng.annotations.Test;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class DeSerialize {

	private static final ObjectMapper Mapper= new ObjectMapper();
	
	@Test(enabled=false)
	public void Deserial() throws IOException {
	String json="{\"id\":10,\"gender\":\"Female\",\"first_name\":\"same\",\"last_name\":\"Asms\"}";
	
	Employee emp2= Mapper.readValue(json, Employee.class);
	
	System.out.println(emp2);
	String url= "http://ezifyautomationlabs.com:6565/educative-rest/students/{id}";
	Employee emp3= 	RestAssured.given()
					.pathParams("id", "200")
					.get(url)
					.as(Employee.class);
	
	System.out.println(emp3);
	}
	@Test
	public void dataStructureDeserl() {
	String Url="http://ezifyautomationlabs.com:6565/educative-rest/students";
	
	Response res = RestAssured.given()
			.get(Url)
			.andReturn();
	res.getBody().prettyPrint();
	
	Employee[] EmplArray = RestAssured.given()
			.accept("Application/json")
			.get(Url)
			.as(Employee[].class);

for(int i=0;i<EmplArray.length;i++) {
	System.out.println(EmplArray[i]);
}
	
	
	Type type = new TypeReference<List<Employee>>() {}.getType();
	
	List<Employee> emp = RestAssured.given()
			.accept("Application/json")
			.contentType("Application/json")
			.get(Url)
			.as(type);
	System.out.print(" Employee in List format ");
	System.out.println(emp);
	}
	}
