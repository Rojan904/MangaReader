package com.example.mangarock.Model;

public class Anime {
    private String name ;
    private String description;
    private String rating ;
    private int nb_episode;
    private String image_url;
    private String categorie;
//    private String studio;
    private String author;
    private String status;
    public Anime() {
    }

    public Anime(String name, String description, String rating, int nb_episode, String image_url, String categorie, String author,String status) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.nb_episode = nb_episode;
        this.image_url = image_url;
        this.categorie = categorie;
//        this.studio = studio;
        this.author=author;
        this.status=status;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public int getNb_episode() {
        return nb_episode;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getCategorie() {
        return categorie;
    }

//    public String getStudio() {
//        return studio;
//    }
    public String getAuthor() {
        return author;
    }

    public String getStatus(){
        return status;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setNb_episode(int nb_episode) {
        this.nb_episode = nb_episode;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

//    public void setStudio(String studio) {
//        this.studio = studio;
//    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setStatus(String status) {
        this.status= status;
    }
}
