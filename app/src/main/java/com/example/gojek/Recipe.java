package com.example.gojek;

public class Recipe {
    int id;
    String name;
    String description;
    double price;
    String thumbnail;
    String chef;
    String author;
    String timestamp;

    public String getLanguageColor() {
        return languageColor;
    }

    public String getForks() {
        return forks;
    }

    public String getStars() {
        return stars;
    }

    String avatar;
    String language;
    String url,languageColor,forks,stars;

    public String getUrl() {
        return url;
    }

    public String getLanguage() {
        return language;
    }

    public String getAuthor() {
        return author;
    }


    public String getAvatar() {
        return avatar;
    }

    public Recipe() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getChef() {
        return chef;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
