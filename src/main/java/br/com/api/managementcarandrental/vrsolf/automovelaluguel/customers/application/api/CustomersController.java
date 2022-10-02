package br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.service.CustomersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CustomersController implements CustumersAPI {

	private final CustomersService customersService;

	@Override
	public CustomersResponse postCustomers(CustomersRequest customersRequest) {

		log.info("[start] CustomersController - postCustomers");
		CustomersResponse customersCriado = customersService.criaCustomers(customersRequest);
		log.info("[finish] CustomersController - postCustomers");
		return customersCriado;
	}

	@Override
	public List<CustomersListResponse> getTodosCustomers() {
		log.info("[start] CustomersController - getTodosCustomers");
		List<CustomersListResponse> customers = customersService.buscaTodosCustomers();
		log.info("[finish] CustomersController - getTodosCustomers");
		return customers;
	}

	@Override
	public CustomersDetalhadoResponse getCustomersAtravesId(UUID id) {
		log.info("[start] CustomersController - getCustomersAtravesId");
		log.info("[idCustomers] {}", id);
		CustomersDetalhadoResponse clienteDetalhado = customersService.buscaCustomersAtravesId(id);
		log.info("[finish] CustomersController - getCustomersAtravesId");
		
		return clienteDetalhado;
	}

	@Override
	public void deletaCustomerseAtravesId(UUID id) {
		log.info("[start] CustomersController - deletaCustomerseAtravesId");
		log.info("[idCustomers] {}", id);
		customersService.deletaCustomersAtravesId(id);
		log.info("[finish] CustomersController - deletaCustomerseAtravesId");

	}

	@Override
	public void patchAlteraCustomers(UUID id, @Valid CustomersAlteracaoRequest clienteAlteracaoRequest) {
		log.info("[start] CustomersController - patchAlteraCustomers");
		log.info("[idCustomers] {}", id);
		customersService.patchAlteraCustomers(id, clienteAlteracaoRequest);
		log.info("[finish] CustomersController - patchAlteraCustomers");
		
	}

}
