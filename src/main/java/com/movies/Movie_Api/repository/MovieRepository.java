package com.movies.Movie_Api.repository;

import com.movies.Movie_Api.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
