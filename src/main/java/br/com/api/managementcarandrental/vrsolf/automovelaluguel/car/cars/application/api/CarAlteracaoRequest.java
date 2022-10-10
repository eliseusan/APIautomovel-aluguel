package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api;

import lombok.Value;

@Value
public class CarAlteracaoRequest {

    private String name;
    private String description;
    private Double daily_rate;
    private String avaliable;
    private String license_plate;
    private String color;
}
