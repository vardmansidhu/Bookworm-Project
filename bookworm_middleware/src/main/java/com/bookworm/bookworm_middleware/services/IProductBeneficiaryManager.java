package com.bookworm.bookworm_middleware.services;

import java.util.List;
import com.bookworm.bookworm_middleware.entities.Beneficiary;

public interface IProductBeneficiaryManager {
    List<String> findByProductId(Integer productId);
}
