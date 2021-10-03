package ru.geekbrains.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.shop.model.dtos.CartDto;
import ru.geekbrains.shop.model.entities.Cart;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final Cart cart;


    @GetMapping
    public CartDto getCart(){
        return new CartDto(cart);
    }

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id){
        cart.addToCart(id);
    }

    @GetMapping("/clear")
    public void clearCart(){
        cart.clear();
    }
}
