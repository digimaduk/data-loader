package org.digimad.dataloader.repositories;

import org.digimad.dataloader.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
