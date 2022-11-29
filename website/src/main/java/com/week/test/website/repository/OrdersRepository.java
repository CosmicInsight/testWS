package com.week.test.website.repository;

import com.week.test.website.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OrdersRepository extends JpaRepository<Orders,Integer> {
}
