package br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars_specifications.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.cars.domain.Cars;
import br.com.api.managementcarandrental.vrsolf.automovelaluguel.car.specification.domain.Specification;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
@Table(name = "car_specifications")
public class CarSpecifications {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id_car_specification", updatable = false, unique = true, nullable = false)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id_cars", nullable = false)
    private Cars car;

    @OneToOne
    @JoinColumn(name = "specification_id", referencedColumnName = "id_specification", nullable = false)
    private Specification specification;
    
}
