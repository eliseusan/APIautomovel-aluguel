package br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.specification.domain.Specification;

public interface SpecificationSpringDataJPARepository extends JpaRepository<Specification, UUID> {

}
