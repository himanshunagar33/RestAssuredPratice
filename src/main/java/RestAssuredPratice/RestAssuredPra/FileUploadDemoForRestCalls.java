package RestAssuredPratice.RestAssuredPra;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FileUploadDemoForRestCalls {

	@Test
	public void TestOne() throws IOException {
		String json= "[{\"first_name\":\"Himanshu\",\"last_name\":\"Nagar\",\"gender\":\"male\"},{\"first_name\":\"Neha\",\"last_name\":\"Nagar\",\"gender\":\"female\"}]";
		File file= new File("Student.json");
		Files.write(file.toPath(), json.getBytes());	
		
		String url="http://ezifyautomationlabs.com:6565/educative-rest/students/upload";
		
		Response resp= RestAssured.given()
				.multiPart("file",file)
				.multiPart("name", "Educative")
				.post(url).andReturn();
		assertEquals(resp.getStatusCode(),201,"http status code check failed");
		resp.body().prettyPrint();
				
	}
}
