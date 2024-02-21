package com.bookworm.bookworm_middleware.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bookworm.bookworm_middleware.entities.Beneficiary;
import com.bookworm.bookworm_middleware.entities.ProductBeneficiary;

import jakarta.transaction.Transactional;

@Repository
@Transactional

public interface IProductBeneficiaryRepository extends JpaRepository<ProductBeneficiary, Integer> {

    @Query(value = "select ben_name from Beneficiary b,Product_beneficiary p where b.ben_id=p.ben_id and product_id=:pro", nativeQuery = true)
    List<String> findBeneficiarynameByProductId(@Param("pro") Integer productId);

    @Query(value = "select * from Product_beneficiary p where p.product_id =:pro1", nativeQuery = true)
    List<ProductBeneficiary> findBeneficiariesByProductId(@Param("pro1") Integer product_Id);

}
