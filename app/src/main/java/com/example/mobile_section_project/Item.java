package com.example.mobile_section_project;

public class Item{
    //name, description, price, image, id, category
    int id, image;
    String name, description, category;
    double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Item(int id, int image, String name, String description, double pri) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = pri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
