package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();

    @Query("SELECT DISTINCT pt FROM ProductType pt")
    List<ProductType> findAllProductTypes();
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);

    @Query("SELECT pt from ProductType pt WHERE pt.name = ?1")
    ProductType findByProductTypeName(String Name);

    @Query("SELECT pr from Product pr WHERE pr.price < ?1")
    List<Product> findCheaperThan(Double price);
}
