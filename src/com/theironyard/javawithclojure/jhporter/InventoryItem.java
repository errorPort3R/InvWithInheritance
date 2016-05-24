package com.theironyard.javawithclojure.jhporter;

/**
 * Created by jeffryporter on 5/24/16.
 */
public class InventoryItem
{
    //declare variables
    protected String name;
    protected int quantity;
    protected String category;

    public InventoryItem(String name, int qty, String category)
    {
       this.name = name;
       this.quantity = qty;
       this.category = String.format("Unknown '%s' category", category);
    }
    public InventoryItem(){}

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public String getCategory()
    {
        return category;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setQuantity(int qty)
    {
        this.quantity = qty;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }
}

