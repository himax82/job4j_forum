package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ForumMem {

    private final Map<Integer, Authority> authorities = new HashMap<>();

    private final Map<Integer, Post> posts = new HashMap<>();

    private final Map<Integer, User> users = new HashMap<>();

    private final AtomicInteger userId = new AtomicInteger(0);

    private final AtomicInteger postId = new AtomicInteger(0);

    private final AtomicInteger commentId = new AtomicInteger(0);

    public Authority findByName(String name) {
        return authorities.values().stream()
                .filter(authority -> Objects.equals(authority.getName(), name))
                .findFirst().orElse(null);
    }

    public void savePost(Post post) {
        if (post.getId() == 0) {
            post.setId(postId.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public void saveComment(Comment comment, int postId) {
        if (!posts.containsKey(postId)) {
            throw new IllegalArgumentException("Couldn't find post");
        }
        if (comment.getId() == 0) {
            comment.setId(commentId.incrementAndGet());
        }
        posts.get(postId).addComment(comment);
    }

    public boolean deletePost(int id) {
        return posts.remove(id, findPostById(id));
    }

    public Post findPostById(int id) {
        return posts.get(id);
    }

    public Collection<Post> findAllPost() {
        return posts.values();
    }

    public void save(User user) {
        if (user.getId() == 0) {
            user.setId(userId.incrementAndGet());
        }
        users.put(user.getId(), user);
    }

    public boolean existsByUsername(String username) {
        return users.values().stream()
                .anyMatch(user -> user.getUsername().equals(username));
    }

    public User findByUsername(String username) {
        return users.values().stream()
                .filter(user -> Objects.equals(user.getUsername(), username))
                .findFirst()
                .orElse(null);
    }
}
