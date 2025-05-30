package com.itheima;

public class Phone {
    private String brand;
    private double price;
    private String color;
    public Phone(){

    }
    public Phone(String brand,double price,String color)
    {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }
    public String getBrand()
    {
        return brand;
    }
    public void setColor(String color)
    {
        this.color = color;
    }
    public String getColor()
    {
        return color;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public double getPrice()
    {
        return price;
    }
}
