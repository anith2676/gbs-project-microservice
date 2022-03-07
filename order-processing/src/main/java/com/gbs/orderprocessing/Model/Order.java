package com.gbs.orderprocessing.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("order") // Ignore this property when converting to JSON
    private List<Item> items;


    @Column(name = "address")
    private String address;

    


}