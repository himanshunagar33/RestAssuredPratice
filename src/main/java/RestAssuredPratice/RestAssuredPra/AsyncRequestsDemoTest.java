package RestAssuredPratice.RestAssuredPra;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.asynchttpclient.Dsl;
import org.asynchttpclient.Response;
import org.testng.annotations.Test;

public class AsyncRequestsDemoTest {

	@Test
	public void AsyncRequestsDemoTest() throws InterruptedException, ExecutionException, TimeoutException {
		
		
		String URL="https://reqres.in/api/users?delay=3";
		Future <Response> whenResponse= Dsl.asyncHttpClient().prepareGet(URL).execute();
		Response resp= whenResponse.get(10,TimeUnit.SECONDS);
		assertEquals(resp.getStatusCode(),200," Response status checked failed");
		System.out.println(resp.getResponseBody());
	}
}
