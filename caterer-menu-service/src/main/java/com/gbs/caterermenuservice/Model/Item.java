package com.gbs.caterermenuservice.Model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
@Getter @Setter @NoArgsConstructor @AllArgsConstructor


public class Item {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, name = "item_name")
    private String name;

    @Column(nullable = false, name = "item_price")
    private Double price;

    @Column(nullable = false, name = "item_description")
    private String description;

    @Column(nullable = false, name = "item_image_url")
    @Lob
    private String imageUrl;
    
    @Column(nullable = false, name = "updated_on")
    private LocalDate updatedDate;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Menu menu;
    
}
