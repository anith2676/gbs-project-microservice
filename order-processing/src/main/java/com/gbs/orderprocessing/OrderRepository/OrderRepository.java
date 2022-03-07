package com.gbs.orderprocessing.OrderRepository;

import com.gbs.orderprocessing.Model.Order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    boolean existsById(Integer id);
}
    

