package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    Integer id;

    @Size(min = 3, max = 50)
    String name;

    @Min(value = 0, message = "The value must be positive")
    double price;

    @OneToOne
    ProductType productType;

    public Product() {}

    public Product(String name, Double price, ProductType productType) {
        this.name = name;
        this.price = price;
        this.productType = productType;
    }
}
