package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.brand.domain.Brand;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.application.api.CarRequest;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.categories.domain.Categories;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
@Table(name = "car")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id_cars", updatable = false, unique = true, nullable = false)
    private UUID id;
    private String name;
    private String description;
    private Double daily_rate;
    private String avaliable;
    private String license_plate;
    
    @OneToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id_brand", nullable = false)
    private Brand brand;

    @OneToOne
    @JoinColumn(name = "categories_id", referencedColumnName = "id_categories", nullable = false)
    private Categories categories;
    private String color;
    private LocalDateTime created_at;
    private LocalDateTime update_at;
    
    
    public Cars(@Valid CarRequest carRequest) {
        this.name = carRequest.getName();
        this.description = carRequest.getDescription();
        this.daily_rate = carRequest.getDaily_rate();
        this.avaliable = carRequest.getAvaliable();
        this.license_plate = carRequest.getLicense_plate();
        this.brand = carRequest.getBrand();
        this.categories = carRequest.getCategories();
        this.color = carRequest.getColor();
        this.created_at = LocalDateTime.now();
        
    }


    
    
    
}