package com.example.backlab1.repository;

import com.example.backlab1.model.Category;
import com.example.backlab1.model.Customer;
import com.example.backlab1.model.Record;

import java.util.List;

public interface Repository {

    Customer addCustomer(Customer customer);

    Record addRecord(Record record);

    Category addCategory(Category category);

    List<Record> getRecords();

    List<Customer> getCustomers();

    List<Category> getCategories();
}
