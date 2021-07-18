package ru.geekbrains.shop.model.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.shop.model.entities.Product;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private double cost;

    public ProductDto(Product p) {
        this.id = p.getId();
        this.name = p.getName();
        this.cost = p.getCost();
    }
}
