package br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.categories.domain.Categories;

public interface CategoriesSpringDataJPARepository extends JpaRepository<Categories, UUID> {

}
