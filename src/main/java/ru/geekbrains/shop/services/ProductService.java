package ru.geekbrains.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.shop.model.Product;
import ru.geekbrains.shop.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllByPrice(double min, double max) {
        return productRepository.findAllByCostBetween(min, max);
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
}

