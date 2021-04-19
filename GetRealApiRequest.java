package wiremockTestCases;

import org.junit.Before;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.UtilitiesForApplication;

public class GetRealApiRequest {

	static UtilitiesForApplication utils = new UtilitiesForApplication();
	static String env;
	static String wireMockValue;

	
/*	@BeforeTest
	public void getEnvironment() {
		env = utils.getPropertyvalue("environment");
		//System.out.println(env);
		wireMockValue = utils.getPropertyvalue("WireMock");
		//System.out.println(wireMockValue);
	}*/
	
	@Test
	public void getRealApiRequest()
	{
				System.out.println("Wiremock is off --> Executing Real API Env");
			// 1) End Point
			
				RestAssured.baseURI = "https://api-mar2020.atlassian.net/rest/api/2/search";
					
					// 2) Authorization
					
					RestAssured.authentication = RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com", "kEJxzmhkQzvdeP8iysWN2D1B");
					
					
					// 3) Get the request
					
					Response response = RestAssured.given().relaxedHTTPSValidation().get(); 
					
					//Print the response
					//response.prettyPrint();
					
					
					//Print the Status Code
					System.out.println(response.getStatusCode());
					
					//Content Type
					String contentType = response.getContentType();
					System.out.println(contentType);
					
				}
	}

	