package ru.geekbrains.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.shop.model.Product;
import ru.geekbrains.shop.repositories.ProductRepository;
import ru.geekbrains.shop.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(
            @RequestParam(name = "min_price", defaultValue = "0") Double minPrice,
            @RequestParam(name = "max_price", required = false) Double maxPrice
    ){
        if (maxPrice == null){
            maxPrice = Double.MAX_VALUE;
        }
        return productService.findAllByPrice(minPrice, maxPrice);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.findProductById(id).get();
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        return productService.saveOrUpdate(product);
    }

//    @DeleteMapping("/delete/{id}")
    @DeleteMapping
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

}
