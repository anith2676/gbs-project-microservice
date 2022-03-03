package com.gbs.caterermenuservice.Controller;

import java.util.HashMap;
import java.util.Map;

import com.gbs.caterermenuservice.Repo.ItemRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.var;

@RestController
@RequestMapping("/item")

public class itemController {

    @Autowired 
    private ItemRepo itemRepo;
    
    
    @GetMapping("/getItems")
    public ResponseEntity<Map<Object,Object>>getAllItems(){
        var response = new HashMap<Object, Object>();
        
        var items = itemRepo.findAll();
        if (items.isEmpty()) {
            response.put("message", "No items found");
            response.put("status", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("message", "Items found");
        response.put("items", items);
        response.put("status", HttpStatus.OK);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PostMapping("insert")
    public ResponseEntity<Map<Object, Object>> createItem(@RequestBody Item item) {
        // return ResponseEntity.status(HttpStatus.CREATED).body(itemRepository.save(item));
        Map<Object, Object> response = new HashMap<>();
        var it = itemRepository.save(item);

        response.put("status", HttpStatus.CREATED);
        response.put("item", itemRepository.save(item));
        response.put("message", "Item created successfully");
        response.put("location", "/store/items/" + it.getId());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}
