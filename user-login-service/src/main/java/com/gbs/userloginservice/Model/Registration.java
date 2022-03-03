package com.gbs.userloginservice.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "regist") 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Registration {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, name = "name")
    private String name; 
    @Column(nullable = false, name = "mobile_no")
    private String mobile; 
    @Column(nullable = false, name = "user_name")
    private String userName; 
    @Column(nullable = false, name = "password")
    private String password; 
    @Column(nullable = false, name = "email_id")
    private String email; 
    
}
