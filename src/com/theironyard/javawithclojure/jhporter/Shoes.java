package com.theironyard.javawithclojure.jhporter;

/**
 * Created by jeffryporter on 5/24/16.
 */
public class Shoes extends InventoryItem
{
    public Shoes(String name, int qty)
    {
        this.name = name;
        this.quantity = qty;
        this.category = "Shoes";
    }

    @Override
    public String toString()
    {
        return category;
    }
}
