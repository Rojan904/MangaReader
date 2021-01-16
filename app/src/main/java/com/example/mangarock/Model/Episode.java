package com.example.mangarock.Model;

public class Episode {
    private String episode, date,img,likes;
    public Episode() {
    }

    public Episode(String episode, String date, String img,String likes) {
        this.episode = episode;
        this.date = date;
        this.img = img;
        this.likes=likes;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode= episode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
