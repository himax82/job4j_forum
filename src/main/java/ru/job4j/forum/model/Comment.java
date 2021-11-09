package ru.job4j.forum.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Calendar created;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

        public static Comment of(String text, Post post, User author) {
            Comment comment = new Comment();
            comment.setText(text);
            comment.setPost(post);
            comment.setAuthor(author);
            comment.setCreated(Calendar.getInstance());
            return comment;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }
        public Calendar getCreated() {
            return created;
        }
        public void setCreated(Calendar created) {
            this.created = created;
        }

        public Post getPost() {
            return post;
        }

        public void setPost(Post post) {
            this.post = post;
        }

        public User getAuthor() {
            return author;
        }
        public void setAuthor(User author) {
            this.author = author;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Comment comment = (Comment) o;
            return id == comment.id;
        }
        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }