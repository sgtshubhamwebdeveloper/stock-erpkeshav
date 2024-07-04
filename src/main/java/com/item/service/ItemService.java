package com.item.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.item.entity.Item;
import com.item.repository.ItemRepository;

@Service
public class ItemService {
    
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }
    public Item updateItem(Long id, Item item) {
        Optional<Item> existingItem = itemRepository.findById(id);
        if(existingItem.isPresent()) {
            Item updatedItem = existingItem.get();
            updatedItem.setName(item.getName());
            updatedItem.setQuantity(item.getQuantity());
            updatedItem.setPrice(item.getPrice());
            return itemRepository.save(updatedItem);
        } else {
            return null;
        }
    }
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
    public void incrementQuantity(Long id) {
        Optional<Item> existingItem = itemRepository.findById(id);
        if(existingItem.isPresent()) {
            Item item = existingItem.get();
            item.setQuantity(item.getQuantity() + 1);
            itemRepository.save(item);
        }
    }
    public void decrementQuantity(Long id) {
        Optional<Item> existingItem = itemRepository.findById(id);
        if(existingItem.isPresent()) {
            Item item = existingItem.get();
            if(item.getQuantity() > 0) {
                item.setQuantity(item.getQuantity() - 1);
                itemRepository.save(item);
            }
        }
    }
}