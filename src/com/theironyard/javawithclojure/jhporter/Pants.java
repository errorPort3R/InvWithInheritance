package com.theironyard.javawithclojure.jhporter;

/**
 * Created by jeffryporter on 5/24/16.
 */
public class Pants extends InventoryItem
{
    public Pants(String name, int qty)
    {
        this.name = name;
        this.quantity = qty;
        this.category = "Pants";
    }

    @Override
    public String toString()
    {
        return category;
    }
}
