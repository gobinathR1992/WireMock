package wiremockTestCases;


import org.junit.BeforeClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import io.restassured.RestAssured;
	import io.restassured.response.Response;
import utils.UtilitiesForApplication;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


		
		public class PostWiremockRequest {
			

			static UtilitiesForApplication utils = new UtilitiesForApplication();
			static String env;
			static String wireMockValue;
			//static WireMockRule wireMockRule1;
			static WireMockServer server1;
			
			//@Rule
			//public WireMockRule wireMockRule = new WireMockRule(8082);

			
			@BeforeTest()
			public void mockForIssue() {
				
				//wireMockRule1 = new WireMockRule(8080);
				//wireMockRule1.start();
				server1 = new WireMockServer(WireMockConfiguration.wireMockConfig().port(8089));
				server1.start();
				stubFor(post(urlEqualTo("/api/table/issues"))
						.willReturn(aResponse()
								.withStatus(201)
								.withHeader("Content-Type", "application/json")
								.withBody("{ \"data\" : \"success\" }")
								));
				//}

			}


			@Test()
			public void testCreateIssues() {
					System.out.println("Wiremock TEst Case is Onn");
				// Step 1: base URL
				RestAssured.baseURI = "http://localhost:8089/api/table/issues";

				// Step 2: body content
				Response response = RestAssured
						.given()
						.body("{ \"number\" : \"INC2019292\" }")
						.post();

				// Step 3: verify the response	
				response.prettyPrint();

				System.out.println(response.getStatusCode());
			//	}


			}
			
			@AfterTest
			public void shutDown()
			{
				server1.stop();
			}

}
	
	
