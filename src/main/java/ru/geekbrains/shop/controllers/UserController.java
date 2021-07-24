package ru.geekbrains.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.shop.model.entities.User;
import ru.geekbrains.shop.services.UserService;

import java.security.Principal;
import java.util.Optional;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public Page<User> usersPage(){
        return (Page<User>) userService.findAll();
    }

    @GetMapping("/score/get/{id}")
    public int getUserScore(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        return user.get().getScore();
    }

    @GetMapping("/score/get/current")
    public int getCurrentUserScore(Principal principal){
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        return user.getScore();
    }

    @GetMapping("/score/inc")
    public int incrementScore(Principal principal){
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        user.setScore(user.getScore() + 1);
        return user.getScore();
    }

    @GetMapping("/score/dec")
    public int decrementScore(Principal principal){
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        user.setScore(user.getScore() - 1);
        return user.getScore();
    }
}
