package RestAssuredPratice.RestAssuredPra;

import com.fasterxml.jackson.annotation.JsonProperty;

public class studentDemoFile {
	
		
		public studentDemoFile(String firstname,String lastname,String gender, int marks) {
			this.firstName=firstname;
			this.lastName=lastname;
			this.Gender=gender;
			this.marks=marks;
		}
		
	    @JsonProperty("id")
	    Long id;

	    @JsonProperty("first_name")
	    String firstName;

	    @JsonProperty("last_name")
	    String lastName;

	    @JsonProperty("gender")
	    String Gender;
	    
	    @JsonProperty("marks")
	    int marks;
		
	}

