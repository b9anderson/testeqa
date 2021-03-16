package projeto.api.pages;

import static org.junit.Assert.assertTrue;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Metodos {
	
	public  Response cadastrar(int idade, String nome, String company, String email) {

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("name", nome);
		json.put("age", idade);
		json.put("company", company);
		json.put("email", email);
		request.body(json.toJSONString());
		Response response = request.post("http://localhost:8080/users");
		System.out.println("Funcionario: " + response.asString() +", cadastrado com sucesso");
		return response;
	}
	
	
	public  Response atualizar(int idade, String nome, String company, String email,String funcionario) {

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("name", "Stefanny");
		json.put("age", idade);
		json.put("company", company);
		json.put("email", email);
		request.body(json.toJSONString());
		Response response = request.put("http://localhost:8080/users/"+funcionario);
		System.out.println("Funcionario: " + response.asString() +", atualizado com sucesso");
		return response;
	}
	
	
	

}
