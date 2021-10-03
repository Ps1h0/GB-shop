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

    public static class ProductDtoBuilder{
        private final ProductDto productDto;

        private ProductDtoBuilder(){
            productDto = new ProductDto();
        }

        public ProductDtoBuilder withName(String name){
            productDto.name = name;
            return this;
        }

        public ProductDtoBuilder withCost(double cost){
            productDto.cost = cost;
            return this;
        }

        public ProductDto build(){
            return productDto;
        }
    }

    public static ProductDtoBuilder builder(){
        return new ProductDtoBuilder();
    }
}
