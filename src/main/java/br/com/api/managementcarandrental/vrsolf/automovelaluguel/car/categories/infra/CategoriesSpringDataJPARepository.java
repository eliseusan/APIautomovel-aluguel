package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.domain.Categories;

public interface CategoriesSpringDataJPARepository extends JpaRepository<Categories, UUID> {

}
