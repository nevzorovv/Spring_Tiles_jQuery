package ru.vnevzorov.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vnevzorov.model.Product;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

    List<Product> findAllByManufacturer(String manufacturer);
    List<Product> findAllByModel(String model);
    List<Product> findAllByColor(String color);
    List<Product> findAllByPriceBetween(Double from, Double to);

}
