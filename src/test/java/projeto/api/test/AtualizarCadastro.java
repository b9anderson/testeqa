package projeto.api.test;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import projeto.api.pages.Metodos;
import projeto.api.utils.RestUtils;

public class AtualizarCadastro {

	Metodos metodos = new Metodos();
	Consultas consulta = new Consultas();
	RestUtils utils = new RestUtils();
	Response response;

	String nome = utils.getNome();
	String company = utils.getCompany();
	String email = utils.getEmail();

	public boolean validarExiste(String email) {
		boolean existe = false;
		int code = consulta.consulta("users/" + email).getStatusCode();
		if (code == 200) {
			existe = true;
		}
		return existe;
	}

	public void atualizar() {

		if (!validarExiste("atualizar.naoexiste@halliburton.com")) {
			metodos.cadastrar(33, "Anderson Atualiza", "Halliburton", "atualizar.usuario@halliburton.com");
			this.response = metodos.atualizar(33, "Anderson Atualiza", "halliburton", utils.getEmail(),
					"atualizar.usuario@halliburton.com");
		} else {
			this.response = metodos.atualizar(25, "Anderson Atualiza", "halliburton",
					"atualizar.usuario@halliburton.com", "atualizar.usuario@halliburton.com");
			;
		}
	}

	@Given("que esteja usando o verbo put para atualizar um funcionario")
	public void que_esteja_usando_o_verbo_put_para_atualizar_um_funcionario() {
		atualizar();
	}

	@Then("retorna status code {int} da atualizacao")
	public void retorna_status_code_da_atualizacao(int code) {

		assertEquals(code, this.response.getStatusCode());

	}

}
