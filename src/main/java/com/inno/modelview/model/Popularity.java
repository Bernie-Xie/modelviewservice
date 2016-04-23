package com.inno.modelview.model;

import javax.persistence.*;

@Entity
@Table(name="MV_POPULARITY")
public class Popularity {

    public Popularity(Integer views, Integer likes) {
        this.views = views;
        this.likes = likes;
    }

    public Popularity() {}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private int id;

    private Integer views;
    private Integer likes;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="COREENTITY_ID", nullable = false)
    private CoreEntity owner;

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Popularity{" +
                "views=" + views +
                ", likes=" + likes +
                '}';
    }
}
