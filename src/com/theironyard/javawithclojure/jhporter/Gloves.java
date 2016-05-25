package com.theironyard.javawithclojure.jhporter;

/**
 * Created by jeffryporter on 5/24/16.
 */
public class Gloves extends InventoryItem
{
    public Gloves(String name, int qty)
    {
        this.name = name;
        this.quantity = qty;
        this.category = "Gloves";
    }

    @Override
    public String toString()
    {
        return category;
    }
}
