package com.gbs.caterermenuservice.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity 
@Table(name = "Menu") 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Menu {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, name = "name")
    private String name; 

    @Column(nullable = false, name = "user_name")
    private String userName; 
    @Column(nullable = false, name = "password")
    private String password; 
}