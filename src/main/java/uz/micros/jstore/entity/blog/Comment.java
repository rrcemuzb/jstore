package uz.micros.jstore.entity.blog;


import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false)
    private String author;

    @Column(insertable = false,updatable = false)
    private int post_id;

    @ManyToOne
    @JoinColumn(name = "post_id",nullable = false)
    private Post post;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
