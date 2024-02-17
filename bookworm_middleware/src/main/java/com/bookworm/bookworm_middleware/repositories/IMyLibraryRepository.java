package com.bookworm.bookworm_middleware.repositories;

import com.bookworm.bookworm_middleware.entities.MyLibrary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMyLibraryRepository extends JpaRepository<MyLibrary, Integer> {
	
	@Query(value = "SELECT * FROM mylibrary l WHERE l.transaction_type = :transactionType", nativeQuery = true)
	List<MyLibrary> getLibByType(@Param("transactionType") int transactionType);


}
