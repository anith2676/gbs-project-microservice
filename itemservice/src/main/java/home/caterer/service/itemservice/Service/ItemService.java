package home.caterer.service.itemservice.Service;

import java.util.List;
import java.util.Optional;

import home.caterer.service.itemservice.Model.Item;

public interface ItemService {

    Item create(Item items);

    Optional<Item>findByname(String name);

    Optional<Item> findById(Integer id);

    List<Item> findAll();
 
    Item save(Item items);

    //Item update(Item items);
    List<Item> findById(List<Integer> ids);

    List<Item> findItemById(List<Integer> ids);
    
    
}
    
