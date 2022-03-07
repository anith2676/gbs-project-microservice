package home.caterer.service.itemservice.Service;

import java.util.List;
import java.util.Optional;

import home.caterer.service.itemservice.Model.Item;
import home.caterer.service.itemservice.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item create(Item items) {
        
        return itemRepository.save(items);
    }

    @Override
    public Optional<Item> findById(Integer id) {
        
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> findAll() {
        
        return itemRepository.findAll();
    }

    @Override
    public Item save(Item items) {
        
        return itemRepository.save(items);
    }

    @Override
    public List<Item> findById(List<Integer> ids) {
        
        return itemRepository.findAllById(ids);
    }


    @Override
    public Optional<Item> findByname(String name) {
        return itemRepository.findByName(name);
    }

    @Override
    public List<Item> findItemById(List<Integer> ids) {
        return itemRepository.findAllById(ids);
        }

    

    
   
    
   
    
}

