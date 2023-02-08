package com.addressByCEP.project.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.addressByCEP.project.controller.AddressController;
import com.addressByCEP.project.model.Address;
import com.addressByCEP.project.model.CepRequest;
import com.addressByCEP.project.service.AddressService;


@RunWith(SpringRunner.class)
@WebMvcTest(AddressController.class)
@Execution(ExecutionMode.CONCURRENT)
public class ControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private AddressService service;
	
	
	@Test
	public void testFindAddress() {
		CepRequest cep = new CepRequest("12345678");
		Address address = new Address(cep.getCep(), "@test-Rua", null, null, null, null, null);
		Address address2 = new Address("01001000", null, null, null, null, null, null);
		
		when(service.findAddress(cep.getCep())).thenReturn(address);
		assertThat(address).isNotNull();
		assertThat(address).isNotEqualTo(address2);
	}
	

	

}
