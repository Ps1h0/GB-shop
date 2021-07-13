package ru.geekbrains.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.shop.model.Product;
import ru.geekbrains.shop.repositories.ProductRepository;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productRepository.findById(id).get();
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
        productRepository.deleteById(id);
    }

    @GetMapping("/cost")
    public List<Product> getProductGreaterAndLessThan(@RequestParam Double min, @RequestParam(defaultValue = "0") Double max){
        return productRepository.findAllByCostGreaterThanAndCostLessThan(min, max);
    }

    @GetMapping("/cost_greater_than")
    public List<Product> getProductGreaterThan(@RequestParam Double min){
        return productRepository.findAllByCostGreaterThanEqual(min);
    }

    @GetMapping("/cost_less_than")
    public List<Product> getProductLessThan(@RequestParam Double max){
        return productRepository.findAllByCostLessThanEqual(max);
    }
}
