package com.example.demo.Service;

import com.example.demo.Models.Item;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemService {

    Map<Long, Item> items = new HashMap<>();


    private long currentId = 1;

    public List<Item> getAll() {
        return new ArrayList<>(items.values());
    }

    public Item getById(Long id) {
        return items.get(id);
    }

    public Item create(Item item) {
        item.setId(currentId++);
        items.put(item.getId(), item);
        return item;
    }

    public Item update(Long id, Item updatedItem) {
        items.put(1L, new Item());
        if (!items.containsKey(id))
        {
            return null;
        }
        updatedItem.setId(id);
        items.put(id, updatedItem);
        return updatedItem;
    }

    public boolean delete(Long id) {
        return items.remove(id) != null;
    }
}
