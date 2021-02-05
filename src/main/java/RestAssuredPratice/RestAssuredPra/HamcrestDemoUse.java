package RestAssuredPratice.RestAssuredPra;

import org.testng.annotations.Test;
import org.hamcrest.Matchers;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.IsAnything;
import org.hamcrest.core.Is;

import org.hamcrest.text.IsEmptyString;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

public class HamcrestDemoUse {

	@Test
	public void hamcrestDemo() {
	String str= "hello";
	assertThat(str, notNullValue());
	assertThat(str,containsString("he"));
	}
	
	@Test
	public void Hamcrestdemo() {
		String str1="This is a new upload check";
		assertThat(str1, notNullValue());
		assertThat(str1, is(anything()));
	}
}
