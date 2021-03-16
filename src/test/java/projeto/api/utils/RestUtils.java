package projeto.api.utils;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtils {
	
	public  String getNome() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John" + generatedString);	
	}
	
	public  String getSobrenome() {
		String generatedString = RandomStringUtils.randomAlphabetic(2);
		return ("Jho" + generatedString);	
	}
	
	public  String getEmail() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return (generatedString + "@halliburton.com");	
	}

	public  String getCompany() {
		
		String company = "Halliburton";
		return company;
	}


	
	
	
}
