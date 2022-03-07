package com.gbs.orderprocessing.Controller;


import com.gbs.orderprocessing.Model.Order;
import com.gbs.orderprocessing.Services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/createOrder")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDto, 
            @RequestHeader(name = "Authorization") String token) {

        Integer userId = Integer.parseInt(token.split(" ")[1].trim());
        System.err.println("userId: " + userId);

        // add a rest template call to signup service to find user by id
        // add a model class called user
        // add a one to one unidirectional realtionship from order -> user
        
        ItemDto itemDto = restTemplate.postForObject(
                "http://localhost:9000/api/items/findItemById", orderDto.getItems(),
                ItemDto.class);

        System.err.println(" itemDto.getItems()" + itemDto.getItems());

        Order entity = new Order();
        entity.setAddress(orderDto.getAddress());
        entity.setItems(itemDto.getItems());
        itemDto.getItems().forEach(p -> p.setOrder(entity));

        System.err.println("entity" + entity);

        Order savedOrder = orderService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }

}
