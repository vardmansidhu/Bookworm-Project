package com.bookworm.bookworm_middleware.services;

import java.util.List;

import com.bookworm.bookworm_middleware.entities.MyShelf;

public interface IMyShelfManager {
    List<MyShelf> getAllMyShelfItems();
    MyShelf getMyShelfItemById(Integer id);
    MyShelf saveMyShelfItem(MyShelf myShelf);
    void deleteMyShelfItem(Integer id);
}