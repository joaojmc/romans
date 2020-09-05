package com.romans.Repositories;

import com.romans.Models.Emperor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RRepository extends MongoRepository<Emperor, String> {

    Optional<Emperor> findBy_id(String id);

    Optional<Emperor> findByName(String name);

}
