package com.bookworm.bookworm_middleware.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookworm.bookworm_middleware.entities.MyShelf;
import com.bookworm.bookworm_middleware.entities.Product;
import com.bookworm.bookworm_middleware.repositories.IMyShelfRepository;

import java.util.List;

@Service
public class MyShelfManagerImpl implements IMyShelfManager {

    @Autowired
    private IMyShelfRepository myShelfRepository;

    @Override
    public List<MyShelf> getAllMyShelfItems() {
        return myShelfRepository.findAll();
    }

    @Override
    public MyShelf getMyShelfItemById(Integer id) {
        return myShelfRepository.findById(id).orElse(null);
    }

    @Override
    public MyShelf saveMyShelfItem(MyShelf myShelf) {
        return myShelfRepository.save(myShelf);
    }

    @Override
    public void deleteMyShelfItem(Integer id) {
        myShelfRepository.deleteById(id);
    }

    @Override
    public List<Product> findByCustomerId(Integer customerId) {
        // TODO Auto-generated method stub
        return myShelfRepository.findByCustomerId(customerId);
    }
}