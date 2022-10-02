package br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.service;

import java.util.List;
import java.util.UUID;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api.CustomersAlteracaoRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api.CustomersDetalhadoResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api.CustomersListResponse;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api.CustomersRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.api.CustomersResponse;

public interface CustomersService {
	CustomersResponse criaCustomers(CustomersRequest customersRequest);
	List<CustomersListResponse> buscaTodosCustomers();
	CustomersDetalhadoResponse buscaCustomersAtravesId(UUID id);
	void deletaCustomersAtravesId(UUID id);
	void patchAlteraCustomers(UUID id, CustomersAlteracaoRequest customersAlteracaoRequest);
}
