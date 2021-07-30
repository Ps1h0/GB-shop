package ru.geekbrains.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.shop.model.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
