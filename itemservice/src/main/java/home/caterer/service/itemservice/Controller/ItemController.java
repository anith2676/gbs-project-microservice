package home.caterer.service.itemservice.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import home.caterer.service.itemservice.Model.Item;
import home.caterer.service.itemservice.Service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired 
    private ItemService itemService;

    // http://localhost:5000/api

@GetMapping("/getItems")
    public ResponseEntity<Map<Object, Object>> getAllItems() {
        var items = itemService.findAll();
        var response = new HashMap<Object, Object>();
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

    @GetMapping("/getId/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Integer id) {
        return ResponseEntity.ok(itemService.findById(id).orElseThrow());
    }

    @GetMapping("/getName/{name}")
    public ResponseEntity<Item> getItemByname(@PathVariable String name) {
        return ResponseEntity.ok(itemService.findByname(name).orElseThrow());
    }    
    
    @PostMapping("/saveItem")
    public ResponseEntity<Map<Object, Object>> createItems(@RequestBody Item item) {
        Map<Object, Object> response = new HashMap<>();
        var it = itemService.save(item);
        response.put("status", HttpStatus.CREATED);
        response.put("item", itemService.save(item));
        response.put("location", "/api/saveItem/" + it.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PostMapping("/list")

    public ResponseEntity<Map<Object, Object>> createItems(@RequestBody List<Integer> ids) {
        Map<Object, Object> response = new HashMap<>();

        List<Item> items = (List<Item>) itemService.findById(ids);
        if (items.isEmpty()) {
            response.put("message", "No items found");
            response.put("status", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("status", HttpStatus.OK);
        response.put("items", items);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    
    @PostMapping("/findItemById")

    public ResponseEntity<Map<Object, Object>> findProductsByIdList(@RequestBody List<Integer> ids) {
        Map<Object, Object> response = new HashMap<>();

        List<Item> items = (List<Item>) itemService.findItemById(ids);
        if (items.isEmpty()) {
            response.put("message", "No items found");
            response.put("status", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("status", HttpStatus.OK);
        response.put("items", items);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}