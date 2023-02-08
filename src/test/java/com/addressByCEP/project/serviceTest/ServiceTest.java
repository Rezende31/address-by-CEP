package com.addressByCEP.project.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.addressByCEP.project.exception.InvalidCepException;
import com.addressByCEP.project.model.Address;
import com.addressByCEP.project.model.AddressViaCep;
import com.addressByCEP.project.repository.AddressRepository;
import com.addressByCEP.project.service.AddressService;

public class ServiceTest {

	@MockBean
	private AddressRepository repository;

	@Mock
	private AddressService service;

	@Before
	public void setUp() {
		service = new AddressService();
		repository = mock(AddressRepository.class);
	}

	@Test
	public void testFindAddress() {
		String cep = "12345678";
		boolean result = service.isCepValid(cep);
		assertThat(result).isTrue();
	}

	@Test
	public void testthrowsInvalidCepException() {
		String cep = null;
		assertThrows(InvalidCepException.class, () -> service.isCepValid(cep));
	}

	@Test
	public void testIsCepValid() {
		String cep = "123456789";
		assertThrows(InvalidCepException.class, () -> service.isCepValid(cep));
	}

	@Test
	public void testFindAddressNotNull() {
		String cep = "12345678";
		AddressViaCep addressViaCep = new AddressViaCep();
		addressViaCep.setUf("SP");
		when(repository.findAddress(cep)).thenReturn(addressViaCep);
		Address result = new Address(cep, null, null, null, null, "SP", 7.85);
		assertThat(result).isNotNull();
	}

}
