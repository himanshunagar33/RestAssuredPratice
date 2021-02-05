package RestAssuredPratice.RestAssuredPra;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FileDownloadDemo {

	@Test
	public void TestFileDownload() throws IOException {
		String Url= "http://ezifyautomationlabs.com:6565/educative-rest/students";
		Response resp= RestAssured.given().get(Url).andReturn();
		assertEquals(resp.getStatusCode(), 200,"Status failed");
		byte [] bytes= resp.getBody().asByteArray();
		assertTrue(bytes.length>0);
		File file= new File("String.json");
		Files.write(file.toPath(), bytes);
		assertTrue(file.exists());
		assertTrue(file.length()>0);
		assertTrue(file.length()==bytes.length);
		String fileContent= new String(Files.readAllBytes(file.toPath()));
		System.out.println(fileContent);
		
	}
}
