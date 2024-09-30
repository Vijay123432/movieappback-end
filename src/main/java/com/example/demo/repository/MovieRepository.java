package com.example.demo.repository;
import java.util.List;

import java.time.LocalDate;
import com.example.demo.entity.movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<movie, Long> {
    
    @Query("select m from movie m where m.title=:name")
    movie findByname(@Param("name")String name);

    @Query("SELECT m FROM movie m WHERE m.title LIKE :name%")
    List<movie> Search(@Param("name")String name);

    List<movie> findByGenre(String genre);
    List<movie> findByIsPopularTrue();

    @Query("select m from movie m where m.relesedate >= :today")
    List<movie> findUpMovies(@Param("today")LocalDate today);

    @Query("select m from movie m where m.relesedate >= :today order by m.relesedate desc")
    List<movie> findUpcomingMoviesDescending(@Param("today")LocalDate today);
    
    @Query("from movie ")
    List<movie> findallMovies();
    
    
}