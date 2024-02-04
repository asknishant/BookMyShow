package com.bms.bookmyshow.repositories;

import com.bms.bookmyshow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findByName(String name); // LIMIT 1
    Optional<Movie> findAllByName(String name); // no limit, searches for all movie with name: name
}
