package org.eclipse.jakarta.hello.Models;

public class Product {

    private double price;
    private String name;
    private int quantity;
    public Product(double _price,String _name,int _quantity)
    {
        quantity=_quantity;
        price=_price;
        name=_name;
    }
    public Product() {}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
