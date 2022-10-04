package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarsRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Cars {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
    private UUID id;
    @NotBlank
    private String name;
    private String description;
    private BigDecimal daily_rate;
    private Double avaliable;
    @Column(unique = true)
    private String license_plate;
    
    @NotNull
    @Column(columnDefinition = "uuid", name = "brand_id", nullable = false, unique = true)
    private UUID brand_id ;
    @NotNull
    @Column(columnDefinition = "uuid", name = "category_id", nullable = false, unique = true)
    private UUID categories_id ;
    private String color;
    
    private LocalDateTime created_at;
    private LocalDateTime update_at;
  
    public Cars(UUID brand_id, UUID categories_id, @Valid CarsRequest carsRequest) {
        this.name = carsRequest.getName();
        this.description = carsRequest.getDescription();
        this.daily_rate = carsRequest.getDaily_rate();
        this.avaliable = carsRequest.getAvaliable();
        this.license_plate = carsRequest.getLicense_plate();
        this.brand_id = brand_id;
        this.categories_id = categories_id;
        this.color = carsRequest.getColor();
        this.created_at = LocalDateTime.now();
    }

}
