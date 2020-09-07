package com.romans.Repository;

import com.romans.Model.Emperor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RRepository extends JpaRepository<Emperor, String> {

    Optional<Emperor> findByName(String name);

}
