package com.example.backlab1.controller;

import com.example.backlab1.model.Category;
import com.example.backlab1.model.Customer;
import com.example.backlab1.model.Record;
import com.example.backlab1.service.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api")
public class APIController {
    private final Service service;

    public APIController(Service service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<String> getDefault() {
        return ResponseEntity.ok("Hello from expense record api");
    }

    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody @Valid Customer customer) {
        return service.addCustomer(customer);
    }

    @PostMapping("/record")
    public Record addRecord(@RequestBody @Valid Record record) {
        return service.addRecord(record);
    }

    @PostMapping("/category")
    public Category addCategory(@RequestBody @Valid Category category) {
        return service.addCategory(category);
    }

    @GetMapping("/category")
    public Collection<Category> getCategories() {
        return service.getCategories();
    }

    @GetMapping("/record")
    public Collection<Record> getRecordsForCustomer(@RequestParam Long customerId) {
        return service.getRecordsForCustomer(customerId);
    }

    @GetMapping("/record/{categoryId}")
    public List<Record> getCategoryRecordsForCustomer(@RequestParam Long customerId,
                                                     @PathVariable Long categoryId) {
        return service.getCategoricalRecordsForCustomer(customerId, categoryId);
    }
}
