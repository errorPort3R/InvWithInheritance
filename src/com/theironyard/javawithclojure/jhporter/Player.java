package com.theironyard.javawithclojure.jhporter;

import java.util.ArrayList;

/**
 * Created by jeffryporter on 5/24/16.
 */
public class Player
{
    private String name;
    private String password;
    private ArrayList<InventoryItem> inventory;

    public Player(String name, String password)
    {
        this.name=name;
        this.password=password;
        inventory = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return password;
    }

    public InventoryItem getInventoryItem(int index)
    {
        return inventory.get(index);
    }

    public void updateInventoryQty(int index, int qty)
    {
        inventory.get(index).setQuantity(qty);
    }

    public InventoryItem removeItem(int index)
    {
        return inventory.remove(index);
    }

    public void addItem(String name, int quantity, String category)
    {
        inventory.add(Main.createItem(name, quantity, category));
    }

    public void changePlayerName(String name)
    {
        this.name = name;
    }

    public void changePassword(String password)
    {
        this.password = password;
    }

    public int getInventoryLength()
    {
        return inventory.size();
    }

}
