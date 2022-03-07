package com.gbs.orderprocessing.Services;

import com.gbs.orderprocessing.Model.Order;

public interface OrderService {

    Order create(Order order);

    Iterable<Order> getOrderById(Integer id);

    Order save(Order entity);

}
