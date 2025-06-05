package com.klitzke.aula.repositories;

import com.klitzke.aula.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoty extends JpaRepository<Order, Long> {
}
