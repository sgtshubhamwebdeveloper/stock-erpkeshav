package com.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.item.entity.Item;
import com.item.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;
 
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
    @PatchMapping("/{id}/increment")
    public void incrementQuantity(@PathVariable Long id) {
        itemService.incrementQuantity(id);
    }
    @PatchMapping("/{id}/decrement")
    public void decrementQuantity(@PathVariable Long id) {
        itemService.decrementQuantity(id);
    }
}