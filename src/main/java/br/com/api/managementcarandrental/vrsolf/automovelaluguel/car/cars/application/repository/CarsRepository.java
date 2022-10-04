package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.repository;

import java.util.List;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain.Cars;

public interface CarsRepository {

    Cars salvaCar(Cars cars);

    List<Cars> buscaTodosCars();

   

}
