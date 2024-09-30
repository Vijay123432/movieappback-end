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
    
    @Query("select m from movie m where m.titel=:name")
    movie findByname(@Param("name")String name);

    @Query("SELECT m FROM movie m WHERE m.titel LIKE :name%")
    List<movie> Search(@Param("name")String name);

    List<movie> findByGenre(String genre);
    List<movie> findByIsPopularTrue();

    @Query("select m from movie m where m.releasedate >= :today")
    List<movie> findUpMovies(@Param("today")String today);

    @Query("select m from movie m where m.releasedate >= :today order by m.releasedate desc")
    List<movie> findUpcomingMoviesDescending(@Param("today")LocalDate today);
}