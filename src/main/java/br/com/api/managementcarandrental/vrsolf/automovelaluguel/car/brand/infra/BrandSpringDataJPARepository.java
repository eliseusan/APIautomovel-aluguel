package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.domain.Brand;

public interface BrandSpringDataJPARepository extends JpaRepository<Brand, UUID>{

}
