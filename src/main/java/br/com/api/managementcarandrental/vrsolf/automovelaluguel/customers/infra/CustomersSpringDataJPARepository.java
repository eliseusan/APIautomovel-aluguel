package br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.customers.domain.Customers;

public interface CustomersSpringDataJPARepository extends JpaRepository<Customers, UUID>{

}
