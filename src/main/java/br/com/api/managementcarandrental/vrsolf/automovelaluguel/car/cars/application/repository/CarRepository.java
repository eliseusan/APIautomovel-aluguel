package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain.Cars;

public interface CarRepository {

    Cars salva(Cars cars);

    Cars buscaCarAtravesId(UUID id);

    void deletaCarAtravesId(Cars car);

    List<Cars> buscaTodasCars();

}
