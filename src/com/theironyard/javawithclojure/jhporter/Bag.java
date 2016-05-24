package com.theironyard.javawithclojure.jhporter;

/**
 * Created by jeffryporter on 5/24/16.
 */
public class Bag extends InventoryItem
{
    public Bag(String name, int qty)
    {
        this.name=name;
        this.quantity=qty;
        this.category="Bag";
    }

}
