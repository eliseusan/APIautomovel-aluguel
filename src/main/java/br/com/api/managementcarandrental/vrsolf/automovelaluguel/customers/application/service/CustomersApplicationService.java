package br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api.CustomersAlteracaoRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api.CustomersDetalhadoResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api.CustomersListResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api.CustomersRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api.CustomersResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.repository.CustomersRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.domain.Customers;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomersApplicationService implements CustomersService {

	private final CustomersRepository customersRepository;

	@Override
	public CustomersResponse criaCustomers(CustomersRequest customersRequest) {
		log.info("[start] CustomersApplicationService - criaCustomers ");
		Customers customers = customersRepository.salva(new Customers(customersRequest));
		log.info("[finish] CustomersApplicationService - criaCustomers ");
		return CustomersResponse.builder()
				.id(customers.getId())
				.build();
	}

	@Override
	public List<CustomersListResponse> buscaTodosCustomers() {
		log.info("[start] CustomersApplicationService - buscaTodosCustomers ");
		List<Customers>customers = customersRepository.buscaTodosCustomers();
		log.info("[finish] CustomersApplicationService - buscaTodosCustomers ");
		return CustomersListResponse.converte(customers);
	}

	@Override
	public CustomersDetalhadoResponse buscaCustomersAtravesId(UUID id) {
		log.info("[start] CustomersApplicationService - buscaCustomersAtravesId ");
		Customers customers = customersRepository.buscaCustomersAtravesId(id);
		log.info("[finish] CustomersApplicationService - buscaCustomersAtravesId ");
		return new CustomersDetalhadoResponse(customers);
	}

	@Override
	public void deletaCustomersAtravesId(UUID id) {
		log.info("[start] CustomersApplicationService - deletaCustomersAtravesId ");
		Customers customers = customersRepository.buscaCustomersAtravesId(id);
		customersRepository.deletaCustomers(customers);
		log.info("[finish] CustomersApplicationService - deletaCustomersAtravesId ");

	}

	@Override
	public void patchAlteraCustomers(UUID id, CustomersAlteracaoRequest customersAlteracaoRequest) {
		log.info("[start] CustomersApplicationService - patchAlteraCustomers ");
		Customers customers = customersRepository.buscaCustomersAtravesId(id);
		customers.altera(customersAlteracaoRequest);
		customersRepository.salva(customers);
		log.info("[finish] CustomersApplicationService - patchAlteraCustomers ");

	}

}
