package com.theironyard.javawithclojure.jhporter;

/**
 * Created by jeffryporter on 5/24/16.
 */
public class Shirt extends InventoryItem
{

    public Shirt(String name, int qty)
    {
        this.name = name;
        this.quantity = qty;
        this.category = "Shirt";
    }
}

