package TestCases;

import org.testng.annotations.Test;

import groovyjarjarasm.asm.commons.Method;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Test {
	
	@Test
	public void GetWeatherDetails() {
		
		String city = "Mumbai";
		//Response response = RestAssured.get("https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=7fe67bf08c80ded756e598d6f8fedaea");
		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.queryParam("q",city).queryParam("appid","7fe67bf08c80ded756e598d6f8fedaea").get("/weather");
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
	}

}
