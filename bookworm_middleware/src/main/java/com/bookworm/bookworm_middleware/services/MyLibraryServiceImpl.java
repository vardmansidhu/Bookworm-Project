package com.bookworm.bookworm_middleware.services;

import com.bookworm.bookworm_middleware.entities.MyLibrary;
import com.bookworm.bookworm_middleware.entities.Product;
import com.bookworm.bookworm_middleware.repositories.IMyLibraryRepository;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyLibraryServiceImpl {

    private final IMyLibraryRepository myLibraryRepository;

    @Autowired
    public MyLibraryServiceImpl(IMyLibraryRepository myLibraryRepository) {
        this.myLibraryRepository = myLibraryRepository;
    }

    public MyLibrary addToMyLibrary(MyLibrary myLibrary) {
      
        if (myLibrary.getTransactionType().getTransaction_desc() == 'L' || myLibrary.getTransactionType().getTransaction_desc() == 'R') {
           
            return myLibraryRepository.save(myLibrary); 
        }
    
        return null;
    }
    public List<MyLibrary> getByType(int type) {
		return myLibraryRepository.getLibByType(type);
	}
}
