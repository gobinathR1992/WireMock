package wiremockTestCases;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.BeforeClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
//import com.github.tomakehurst.wiremock.junit.WireMockRule;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.UtilitiesForApplication;

import static com.github.tomakehurst.wiremock.client.WireMock.*;



	public class GetWiremockRequest {
		

		static UtilitiesForApplication utils = new UtilitiesForApplication();
		static String env;
		static String wireMockValue;
		//static WireMockRule wireMockRule ;
		static WireMockServer server;
		
		//@Rule
		//public WireMockRule wireMockRule = new WireMockRule(8081);
		
				@BeforeTest()
		public void mockForIssue() {
				// wireMockRule = new WireMockRule(8080);
					server = new WireMockServer(WireMockConfiguration.wireMockConfig().port(8080));
					server.start();
					//wireMockRule.start();
							stubFor(get(urlEqualTo("/api/table/issues"))
									.willReturn(aResponse()
											.withStatus(200)
											.withHeader("Content-Type", "application/json")
											.withBody("{ \"data\" : \"success\" }")
											));
					//}
		}

		@Test(alwaysRun = true)
		public void testCreateIssues() {
				System.out.println("Wiremock TEst Case is Onn");
			// Step 1: base URL
			RestAssured.baseURI = "http://localhost:4000/api/table/issues";

			// Step 2: body content
			Response response = RestAssured
					.given()
					.get();

			// Step 3: verify the response	
			response.prettyPrint();
			System.out.println(response.getStatusCode());
			//}


		}
		
		@AfterTest
		public void shutDownServer()
		{
			server.shutdownServer();
		}



	}

