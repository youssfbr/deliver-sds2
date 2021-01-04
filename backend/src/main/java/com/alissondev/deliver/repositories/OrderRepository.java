package com.alissondev.deliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alissondev.deliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
