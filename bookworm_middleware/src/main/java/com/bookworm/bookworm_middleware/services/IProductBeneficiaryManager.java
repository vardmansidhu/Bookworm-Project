package com.bookworm.bookworm_middleware.services;

import java.util.List;
// import com.bookworm.bookworm_middleware.entities.Beneficiary;
import com.bookworm.bookworm_middleware.entities.ProductBeneficiary;

public interface IProductBeneficiaryManager {
    List<ProductBeneficiary> findByProductId(Integer productId);
}
