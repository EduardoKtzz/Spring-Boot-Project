package com.klitzke.aula.repositories;

import com.klitzke.aula.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
