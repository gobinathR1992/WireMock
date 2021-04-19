package wiremockTestCases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRealApiRequest {


		@Test
		public void postRealApiRequest()
		{
		
		// 1) Add the End Point
		RestAssured.baseURI = "https://dev96572.service-now.com/api/now/table/incident";
		
		// 2) Add the Authorization
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// 3) Send the request and get the response
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post();
		
		// Print the response
		//response.prettyPrint();
		
		// Status code
		System.out.println(response.getStatusCode());

	}

	
	
	
}
