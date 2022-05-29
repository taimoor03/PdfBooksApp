package com.example.pdfbooks.models;

public class Product {
    private final int id;
    private final String title;
    private final int image;
    private String link;


    public Product(int id, String title,  double price, int image, String link) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.link=link;


    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public int getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }


}