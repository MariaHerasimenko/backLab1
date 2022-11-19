package com.example.backlab1.repository.implementation;

import com.example.backlab1.model.Category;
import com.example.backlab1.model.Customer;
import com.example.backlab1.model.Record;
import com.example.backlab1.repository.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@org.springframework.stereotype.Repository("inMemory")
public class RepInMemory implements Repository {
    private final HashSet<Record> records = new HashSet<>();
    private final HashSet<Customer> customers = new HashSet<>();
    private final HashSet<Category> categories = new HashSet<>();

    public synchronized Customer addCustomer(Customer customer) {
        customers.add(customer);
        customer.setId((long) customer.hashCode());
        return customer;
    }

    public synchronized Record addRecord(Record record) {
        records.add(record);
        record.setId((long) record.hashCode());
        return record;
    }

    public synchronized Category addCategory(Category category) {
        categories.add(category);
        category.setId((long) category.hashCode());
        return category;
    }

    public List<Record> getRecords() {
        return new ArrayList<>(records);
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }
}
