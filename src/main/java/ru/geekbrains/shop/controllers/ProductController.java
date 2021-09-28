package ru.geekbrains.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.shop.exceptions.ResourceNotFoundException;
import ru.geekbrains.shop.model.dtos.ProductDto;
import ru.geekbrains.shop.model.entities.Product;
import ru.geekbrains.shop.repositories.specifications.ProductSpecifications;
import ru.geekbrains.shop.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<ProductDto> findAllProducts(
            @RequestParam MultiValueMap<String, String> params,
            @RequestParam(name = "p", defaultValue = "1") Integer page
    ){
        if (page < 1){
            page = 1;
        }
        return productService.findAll(ProductSpecifications.build(params), page, 5);
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id){
        return productService.findProductById(id).orElseThrow(() -> new ResourceNotFoundException("Не существует продукта с id: " + id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product save(@RequestBody Product product){
        product.setId(null);
        return productService.saveOrUpdate(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return productService.saveOrUpdate(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteById(id);
    }

}
