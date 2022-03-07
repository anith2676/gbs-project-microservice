package com.gbs.orderprocessing.Controller;

import java.util.List;

import com.gbs.orderprocessing.Model.Item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private List<Item> items;
    
}
