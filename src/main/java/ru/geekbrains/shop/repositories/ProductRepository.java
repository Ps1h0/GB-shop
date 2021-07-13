package ru.geekbrains.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.shop.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCostGreaterThanAndCostLessThan(double min, double max);

    List<Product> findAllByCostGreaterThanEqual(double min);

    List<Product> findAllByCostLessThanEqual(double max);

}
