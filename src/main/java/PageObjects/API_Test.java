package PageObjects;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import PageObjects.Weather;
import groovyjarjarasm.asm.commons.Method;
import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_Test {
	
	
	public Weather GetWeatherDetails() {
		
		String city = "Mumbai";
		//Response response = RestAssured.get("https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=7fe67bf08c80ded756e598d6f8fedaea");
		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.queryParam("q",city).queryParam("appid","7fe67bf08c80ded756e598d6f8fedaea").get("/weather");
		String json = response.asString();
		System.out.println(json);
		int humidity = JsonPath.read(json, "$.main.humidity");
		double temp_in_Kelvin = JsonPath.read(json, "$.main.temp");
		int temp_in_celsius = (int) (temp_in_Kelvin - 273.15);
		System.out.println(temp_in_celsius);
		
		Weather obj2 = new Weather(humidity,temp_in_celsius);
		return obj2;
		
		//String humidity = JsonPath.parse(response.getBody()).read("$.main[?(@.humidity=='79')].state").toString();
		
		
		
	}

}
