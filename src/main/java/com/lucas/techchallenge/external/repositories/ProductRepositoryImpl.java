package com.lucas.techchallenge.external.repositories;

import com.lucas.techchallenge.common.daos.ProductDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepositoryImpl extends MongoRepository<ProductDao, UUID> {
}
