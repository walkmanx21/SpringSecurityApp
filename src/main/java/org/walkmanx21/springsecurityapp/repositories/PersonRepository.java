package org.walkmanx21.springsecurityapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.walkmanx21.springsecurityapp.models.Person;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository <Person, Integer> {
    Optional<Person> findByUsername(String username);

}
