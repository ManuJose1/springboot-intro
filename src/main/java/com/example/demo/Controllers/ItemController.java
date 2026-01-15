package com.example.demo.Controllers;

import com.example.demo.Models.Item;
import com.example.demo.Service.ItemService;
import com.example.demo.Validation.EmailValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    
    private final ItemService itemService;
    private final EmailValidator emailValidator = new EmailValidator();

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //Get All Items
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAll();
    }

    //Get Item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemService.getById(id);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(item);
    }

    //Create New Item
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.create(item);
    }

    //Update Item
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        Item updatedItem = itemService.update(id, item);
        if (updatedItem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedItem);
    }

    //Delete Item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        boolean deleted = itemService.delete(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    //Sum of two numbers
    @GetMapping("/sum")
    public ResponseEntity<Integer> sum(@RequestParam int a, @RequestParam int b) {
        int result = a + b;
        System.out.println("Sum: " + a + "+" + b + "=" + result);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/sumandemail")
    public ResponseEntity<String> sumandemail(@RequestParam int a, @RequestParam int b, @RequestParam String email) {
        if (!emailValidator.isValid(email, null)) {
            return ResponseEntity.badRequest().body("Invalid email address");
        }
        int result = a + b;
        System.out.println("Sum: " + a + "+" + b + "=" + result);
        return ResponseEntity.ok("I have sent €" + result + " to this email: " + email);
    }
}
