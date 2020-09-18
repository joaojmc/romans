package com.romans.Repository;

import com.romans.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
