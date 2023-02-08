package calculafrete.stepdefs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.runner.RunWith;

import com.addressByCEP.project.model.Address;
import com.addressByCEP.project.service.AddressService;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/features"
	)
public class StepDefinitions {
	
	private AddressService addressService = new AddressService();
	private String cep;
	private Address address = new Address();
	
	@Dado("que eu faça uma requisição com o CEP válido") //@Given
	  public void requisicao_com_cep_valido() {
	    // passos aqui
		this.cep = cep;
	  }

	  @Quando("a API retornar os dados do endereço") // @When
	  public void api_retorna_dados_do_endereco() {
	    //  passos aqui
		  address = addressService.findAddress(this.cep);
	  }

	  @Então("o retorno deve ser o endereço completo") //Then
	  public void retorno_deve_ser_endereco() {
		  assertEquals(this.address.getCep(), this.cep);
	  }
	  
	  

}
