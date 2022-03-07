package com.gbs.orderprocessing.Model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor

public class Item {
    
    @Id
    @Column(name="id",nullable = false)
    private Integer id;

    @Column( name = "item_name")
    private String name;

    @Column(name = "item_description")
    private String description;

    @Column(name = "item_ingredients")
    private String ingredients;

    @Column(name = "item_category")
    private String category;  // veg or non veg

    @Column( name = "item_quantity")
    private Integer quantity;

    @Column(name = "item_price")
    private Double price;

    @Column( name = "item_image_url")
    @Lob 
    private String imageUrl;
    
    @Column( name = "item_updated_on")
    private LocalDate updatedDate;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    
}

