package br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.application.repository.CustomersRepository;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.domain.Customers;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CustomersInfraRepository implements CustomersRepository {

	private final CustomersSpringDataJPARepository customersSpringDataJPARepository;

	@Override
	public Customers salva(Customers customers) {
		log.info("[start] CustomersInfraRepository salva");
		try {
			customersSpringDataJPARepository.save(customers);
		}catch (DataIntegrityViolationException e) {
			throw APIException.build(HttpStatus.BAD_REQUEST,"Existem dados duplicados", e);
		}
		log.info("[finish] CustomersInfraRepository salva");
		return customers;
	}

	@Override
	public List<Customers> buscaTodosCustomers() {
		log.info("[start] CustomersInfraRepository buscaTodosCustomers");
		List<Customers> todosCustomers = customersSpringDataJPARepository.findAll();
		log.info("[finish] CustomersInfraRepository buscaTodosCustomers");
		return todosCustomers;
	}

	@Override
	public Customers buscaCustomersAtravesId(UUID id) {
		log.info("[start] CustomersInfraRepository buscaCustomersAtravesId");
		Customers customers = customersSpringDataJPARepository.findById(id)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado !")) ;
		log.info("[finish] CustomersInfraRepository buscaCustomersAtravesId");
		return customers;
	}
	
	@Override
	public void deletaCustomers(Customers customers) {
		log.info("[start] CustomersInfraRepository deletaCustomers");
		customersSpringDataJPARepository.delete(customers);
		log.info("[finish] CustomersInfraRepository deletaCustomers");
	}

}
