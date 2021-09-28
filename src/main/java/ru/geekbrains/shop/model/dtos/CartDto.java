package ru.geekbrains.shop.model.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.shop.model.entities.Cart;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class CartDto {

    private List<OrderItemDto> items;
    private double totalCost;

    public CartDto(Cart cart){
        this.totalCost = cart.getTotalCost();
        this.items = cart.getItems().stream().map(OrderItemDto::new).collect(Collectors.toList());
    }
}
