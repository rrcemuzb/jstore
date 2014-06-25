package uz.micros.jstore.entity.store;

import uz.micros.jstore.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {
    @Column(unique = true, nullable = false, columnDefinition = "varchar(200)")
    private String title;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private short year;

    @Column(nullable = false)
    private short pages;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private short isbn;

    @Column(name = "description", columnDefinition = "varchar(3072)")
    private String desc;

    @Column(insertable = false, updatable = false)
    private int author_id;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Column(insertable = false, updatable = false)
    private int genre_id;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @Column(insertable = false, updatable = false)
    private int series_id;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series series;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public short getPages() {
        return pages;
    }

    public void setPages(short pages) {
        this.pages = pages;
    }

    public short getIsbn() {
        return isbn;
    }

    public void setIsbn(short isbn) {
        this.isbn = isbn;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }
}
