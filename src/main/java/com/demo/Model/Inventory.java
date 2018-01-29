package com.demo.Model;

/**
 * Created by gsati on 1/17/2018.
 */
public class Inventory implements  Comparable<Inventory> {
    String itemName;
    double sellingPrice;
    double buyPrice;
    int quantity;

    public Inventory(String token, String s) {
    }


    public Inventory(String itemName, double buyPrice,double sellingPrice, int quantity) {
        this.itemName = itemName;
        this.sellingPrice = sellingPrice;
        this.buyPrice = buyPrice;
        this.quantity = quantity;
    }


    public String getItemName() {
        return itemName;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inventory inventory = (Inventory) o;

        return itemName.equals(inventory.itemName);
    }

    @Override
    public int hashCode() {
        return itemName.hashCode();
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "itemName='" + itemName + '\'' +
                ", sellingPrice=" + sellingPrice +
                ", buyPrice=" + buyPrice +
                ", quantity=" + quantity +
                '}';
    }

    public int compareTo(Inventory o) {
        return this.getItemName().compareTo(o.getItemName());
    }
}
