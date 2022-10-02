package br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.domain.Customers;

public interface CustomersRepository {
	Customers salva(Customers customers);
	List<Customers> buscaTodosCustomers();
	Customers buscaCustomersAtravesId(UUID id);
	void deletaCustomers(Customers customers);
}
