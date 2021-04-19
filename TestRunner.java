package wiremockTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.TestNG;
import org.testng.annotations.Test;

import utils.UtilitiesForApplication;

public class TestRunner {


	//static UtilitiesForApplication utils = new UtilitiesForApplication();
	static String env;
	static String wireMockValue;
	
	@Test
	public void runTestSuite() throws IOException {
		
		
			Properties props = new Properties();
			
			FileInputStream inStream;
				String path = System.getProperty("user.dir");
				//System.out.println(path);
				inStream = new FileInputStream(path+"\\config.properties");
				props.load(inStream);
				inStream.close();
				
				//env = utils.getPropertyvalue("environment");
				//System.out.println(env);
				wireMockValue = props.getProperty("WireMock");
				//System.out.println(wireMockValue);
					
				TestNG testng = new TestNG();
				List<String> suites = new ArrayList<String>();
				if(wireMockValue.equalsIgnoreCase("on"))
				suites.add(path+"//WireMockTestNG.xml");
				else
				{
					suites.add(path+"//RealApiTestNG.xml");
				}
				testng.setTestSuites(suites);
				testng.run();
				
			}
	
	
}
