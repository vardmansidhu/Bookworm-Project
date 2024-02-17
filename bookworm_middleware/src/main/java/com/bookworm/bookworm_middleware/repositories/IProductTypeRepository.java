package com.bookworm.bookworm_middleware.repositories;
	import org.springframework.stereotype.Repository;

	import com.bookworm.bookworm_middleware.entities.ProductType;

	import jakarta.transaction.Transactional;

	import java.util.Optional;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Modifying;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.query.Param;

	@Repository
	@Transactional
	public interface IProductTypeRepository  extends JpaRepository<ProductType,Integer> {

		@Modifying
		@Query("update ProductType p set p.typeDesc = :desc where p.typeId = :id")
	    void update(@Param("desc") String typeDesc, @Param("id") Integer typeId);

		@Query("SELECT p FROM ProductType p WHERE p.typeDesc = :typeDesc")
	    Optional<ProductType> findByTypeDesc(@Param("typeDesc") String typeDesc);
	
}
