package com.bookworm.bookworm_middleware.services;

import java.util.List;
import java.util.Optional;

import com.bookworm.bookworm_middleware.entities.Beneficiary;

public interface IBenificiaryManager {
void addBeneficiary(Beneficiary b);
List <Beneficiary> getallBen();
void deleteById(long id);
Optional<Beneficiary> getBen(long id);
void update(Beneficiary updateBen,long id);
}
