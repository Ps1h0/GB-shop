package ru.geekbrains.shop.model.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;
import ru.geekbrains.shop.exceptions.ResourceNotFoundException;
import ru.geekbrains.shop.services.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Data
public class Cart {

    private final ProductService productService;
    private List<OrderItem> items;
    private int totalCost;

    @PostConstruct
    public void init(){
        this.items = new ArrayList<>();
    }

    public void addToCart(Long id){
        for (OrderItem o : items){
            if (o.getProduct().getId().equals(id)){
                o.incrementQuantity();
                recalculate();
                return;
            }
        }
        Product p = productService.findProductById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find product with id: " + id + " (add to cart)"));
        OrderItem orderItem = new OrderItem(p);
        items.add(orderItem);
        recalculate();
    }

    public void clear(){
        items.clear();
        recalculate();
    }

    public void recalculate(){
        totalCost = 0;
        for (OrderItem o : items){
            totalCost += o.getCost();
        }
    }
}
