package com.lucas.techchallenge.external.repositories;

import com.lucas.techchallenge.common.daos.OrderDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepositoryImpl extends MongoRepository<OrderDao, UUID> {
}
