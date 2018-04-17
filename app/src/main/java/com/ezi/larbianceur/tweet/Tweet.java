package com.ezi.larbianceur.tweet;


public class Tweet {
    private String auteur;
    private String tweet;
    private String idImage;

    public Tweet(String auteur, String tweet) {
        this.auteur = auteur;
        this.tweet = tweet;
    }


    public String getAuteur() {
        return auteur;
    }

    public String getTweet() {
        return tweet;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }


    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}
