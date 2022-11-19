package com.example.backlab1.service;

import com.example.backlab1.model.Category;
import com.example.backlab1.model.Customer;
import com.example.backlab1.model.Record;
import com.example.backlab1.repository.Repository;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {
    @Qualifier("inMemory")
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public Customer addCustomer(Customer customer) {
        return repository.addCustomer(customer);
    }

    public Record addRecord(Record record) {
        verifyRecordUserAndCategory(record);
        return repository.addRecord(record);
    }

    public Category addCategory(Category category) {
        return repository.addCategory(category);
    }

    public List<Category> getCategories() {
        return repository.getCategories();
    }

    public List<Record> getRecordsForCustomer(Long userId) {
        return repository.getRecords().stream()
                .filter(record -> record.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    public List<Record> getCategoricalRecordsForCustomer(Long userId, Long categoryId) {
        return repository.getRecords().stream()
                .filter(record -> record.getUserId().equals(userId))
                .filter(record -> record.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
    }


    private void verifyRecordUserAndCategory(Record record) {
        if(repository.getCategories().stream()
                .noneMatch(category -> category.getId().equals(record.getCategoryId()))) {
            throw new ValidationException("Given record's category doesn't exist");
        }

        if(repository.getCustomers().stream()
                .noneMatch(customer -> customer.getId().equals(record.getUserId()))) {
            throw new ValidationException("Given record's customer doesn't exist");
        }
    }
}
