package ru.job4j.forum.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Post;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Integer> {
    @Override
    @Query("SELECT DISTINCT p FROM Post p "
            + "LEFT JOIN FETCH p.comments c "
            + "ORDER BY p.id DESC")
    Iterable<Post> findAll();

    @Override
    @Query("SELECT DISTINCT p FROM Post p "
            + "LEFT JOIN FETCH p.comments c "
            + "WHERE p.id = ?1 "
            + "ORDER BY c.id")
    Optional<Post> findById(Integer integer);

}