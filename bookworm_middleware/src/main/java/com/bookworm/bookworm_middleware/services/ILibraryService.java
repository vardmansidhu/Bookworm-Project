package com.bookworm.bookworm_middleware.services;

import java.util.List;

import org.apache.el.stream.Optional;

import com.bookworm.bookworm_middleware.entities.MyLibrary;

public interface ILibraryService {
	 public MyLibrary getById(Long libId);

	    public List<MyLibrary> getByCustomerId(Long id);
	    
	   public MyLibrary addToShelf(MyLibrary lib);

	
}
