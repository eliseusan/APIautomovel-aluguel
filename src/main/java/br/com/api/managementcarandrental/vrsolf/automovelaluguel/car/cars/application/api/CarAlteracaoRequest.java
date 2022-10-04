package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import lombok.Value;
@Value
public class CarAlteracaoRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private BigDecimal daily_rate;
    private Double avaliable;
    private String license_plate;
    private String color;
}
