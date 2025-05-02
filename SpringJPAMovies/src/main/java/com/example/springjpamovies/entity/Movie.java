package com.example.springjpamovies.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.util.Date;

@Entity
@Table(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id",nullable = false)
    private Integer id;

    @Column(name = "Title", nullable = false, length = 150)
    @Nationalized
    private String title;

    @Column(name = "release_date",nullable = false)
    private Date releaseDate;

    //@Column(name = "director")
    //@ForeignKey(name = "FK_Movies_Directors",ConstraintMode.CONSTRAINT, foreignKeyDefinition = Director)
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "director", nullable = false)
    private Director director;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", director=" + director +
                '}';
    }
}
