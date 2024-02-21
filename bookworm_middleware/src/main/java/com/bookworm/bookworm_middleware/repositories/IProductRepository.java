package com.bookworm.bookworm_middleware.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookworm.bookworm_middleware.entities.Genre;
import com.bookworm.bookworm_middleware.entities.Language;
import com.bookworm.bookworm_middleware.entities.Product;
import com.bookworm.bookworm_middleware.entities.ProductType;
import com.bookworm.bookworm_middleware.entities.Publisher;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p WHERE p.productId = :id")
	Product getById(int id);

	@Query(value = "SELECT * FROM Product p WHERE p.type_id = :typeId", nativeQuery = true)
	List<Product> findByProductType(@Param("typeId") int typeId);

	@Query(value = "SELECT * FROM Product p WHERE p.language_id = :language_id", nativeQuery = true)
	List<Product> findByProductLanguage(@Param("language_id") int language_id);

	@Query(value = "SELECT * FROM Product p WHERE p.genre_id =:genre_id", nativeQuery = true)
	List<Product> findByProductGenre(@Param("genre_id") int genreId);

	@Query(value = "SELECT * FROM Product p WHERE p.language_id = :language_id AND p.type_id = :type_id", nativeQuery = true)
	List<Product> findByProductLanguageAndType(@Param("language_id") int language_id, @Param("type_id") int type_id);

	@Query(value = "SELECT p.product_eng_name FROM Product p WHERE p.product_id = :id", nativeQuery = true)
	String findProductNameById(@Param("id") int id);

	// @Modifying
	// @Query("UPDATE Product p SET p.productName = :productName, p.productEngName =
	// :productEngName, " +
	// "p.typeId = :typeId, p.basePrice = :basePrice, p.specialCost = :specialCost,
	// p.offerPrice = :offerPrice, " +
	// "p.offerExpDate = :offerExpDate, p.shortDesc = :shortDesc, p.longDesc =
	// :longDesc, p.ISBN = :ISBN, " +
	// "p.author = :author, p.publisher = :publisher, p.languageId = :languageId,
	// p.genreId = :genreId, " +
	// "p.isRentable = :isRentable, p.isLibrary = :isLibrary, p.rentPerDay =
	// :rentPerDay, p.minRentDays = :minRentDays " +
	// "WHERE p.productId = :productId")
	// void updateProduct(
	// String productName, String productEngName, ProductType typeId, float
	// basePrice, float specialCost, float offerPrice,
	// Date offerExpDate, String shortDesc, String longDesc, String ISBN, String
	// author, Publisher publisher,
	// Language languageId, Genre genreId, boolean isRentable, boolean isLibrary,
	// float rentPerDay, int minRentDays, int productId);

	@Query(value = "SELECT * FROM product p WHERE p.type_id = :typeId AND p.product_id NOT IN (SELECT ms.product_id FROM myshelf ms WHERE ms.customer_id = :customerId)", nativeQuery = true)
	List<Product> findProductsByTypeNotInShelf(@Param("typeId") int typeId, @Param("customerId") int customerId);

	@Query(value = "SELECT * FROM product p WHERE p.language_id = :language_id AND p.type_id = :type_id AND p.product_id NOT IN (SELECT ms.product_id FROM myshelf ms WHERE ms.customer_id = :customerId)", nativeQuery = true)
	List<Product> findProductsByLanguageAndTypeNotInShelf(@Param("language_id") int language_id,
			@Param("type_id") int type_id, @Param("customerId") int customerId);

}
