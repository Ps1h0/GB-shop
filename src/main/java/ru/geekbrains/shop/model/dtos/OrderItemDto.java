package ru.geekbrains.shop.model.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.shop.model.entities.OrderItem;

@NoArgsConstructor
@Data
public class OrderItemDto {

    private String productName;
    private int quantity;
    private double costPerProduct;
    private double cost;

    public OrderItemDto(OrderItem orderItem){
        this.productName = orderItem.getProduct().getName();
        this.quantity = orderItem.getQuantity();
        this.costPerProduct = orderItem.getCostPerProduct();
        this.cost = orderItem.getCost();
    }
}
