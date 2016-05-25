package com.theironyard.javawithclojure.jhporter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jeffryporter on 5/23/16.
 */
public class GameManager
{
    //Declare Variables
    private static GameManager theGameManager;
    private ArrayList<Player> Players = new ArrayList<>();
    //constructor
    private GameManager()
    {
    }

    //methods
    public static GameManager getTheGameManager()
    {
        if(theGameManager == null)
        {
            theGameManager = new GameManager();
        }
        return theGameManager;
    }

    public void loadPlayers(String fileLoc)
    {
        Player newPlayer;

//        try
//        {
//            Scanner input = new Scanner(new File(fileLoc));
//            while (input.hasNext())
//            {
//                String line = input.nextLine();
//                String[] fields = line.split(",");
//                String userName = fields[0];
//                String password = fields[1];
//                newPlayer = new Player(userName, password);
//                if(fields.length>2)
//                {
//                    for(int i = 2; i<(fields.length-1); i+=3)
//                    {
//                        int qty = Integer.valueOf(fields[i+1]);
//                        newPlayer.addItem(fields[i], qty, fields[i+2]);
//                    }
//                }
//                Players.add(newPlayer);
//            }
//        }
//        catch(Exception e)
//        {
//            System.err.printf("\nNot a Valid File!\n");
//        }
        newPlayer = new Player("James", "1234");
        newPlayer.addItem("T-shirt of Anti-Glistening", 6, "Shirt");
        newPlayer.addItem("High-Tops of Height Gains", 12, "Shoes");
        newPlayer.addItem("Boots of MudHole Stomping", 2, "Shoes");
        Players.add(newPlayer);
        newPlayer = new Player("Anna", "1234");
        newPlayer.addItem("Purse of Thief-Beating", 1, "Bag");
        newPlayer.addItem("Blouse of Distraction", 2, "Shirt");
        newPlayer.addItem("Jeans of Power-Kicking", 2, "Pants");
        newPlayer.addItem("Acupuncturist High-Heels", 6, "Shoes");
        Players.add(newPlayer);
        newPlayer = new Player("Jeff", "1234");
        newPlayer.addItem("Satchel of Everything", 6, "Bag");
        newPlayer.addItem("Gauntlets of Slapping", 1, "Gloves");
        newPlayer.addItem("Tattered Shirt of the Miser", 5, "Shirt");
        newPlayer.addItem("Sandals of Speed", 15, "Shoes");
        Players.add(newPlayer);
        //System.out.printf("\nPlayers loaded.");
    }

    public void savePlayers(String fileLoc)
    {
        try
        {
            PrintWriter output = new PrintWriter(fileLoc, "UTF-8");
            for (int i = 0; i < Players.size(); i++)
            {
                //PrintWriter output = new PrintWriter(fileLoc);
                output.printf("%s, %s, ",Players.get(i).getName(), Players.get(i).getPassword());

                for (int j =0;j<Players.get(i).getInventoryLength();j++)
                {
                    if ((Players.get(i).getInventoryLength()-1) == j)
                    {
                        output.printf("%s, %d, %s\n", Players.get(i).getInventoryItem(j).getName(),
                                Players.get(i).getInventoryItem(j).getQuantity(), Players.get(i).getInventoryItem(j).getCategory());
                    }
                    else
                    {
                        output.printf("%s, %d, %s", Players.get(i).getInventoryItem(j),
                                Players.get(i).getInventoryItem(j).getQuantity(), Players.get(i).getInventoryItem(j).getCategory());
                    }
                }
            }
            output.close();
        }
        catch(Exception e)
        {
            System.err.printf("\nNot a Valid File!");
        }
    }

    public Player verifyIdentity(Scanner input)
    {
        String userName;
        String password;
        char createNewPlayer = 'z';
        Player tempPlayer = null;

        System.out.printf("\nEnter User Name: ");
        userName = input.nextLine();
        for (int i = 0; i < Players.size(); i++) {
            if (Players.get(i).getName().equals(userName)) {
                System.out.printf("\nEnter Password: ");
                password = input.nextLine();
                if (Players.get(i).getPassword().equals(password)) {
                    tempPlayer = Players.get(i);
                    i = Players.size();
                } else {
                    System.err.printf("Invalid Credentials!\n");
                }
            }
        }
        if (tempPlayer ==  null)
        {
            System.out.printf("\nWould you like to create a new player?[y/n]");
            createNewPlayer = input.nextLine().toLowerCase().charAt(0);
            if (createNewPlayer == 'y')
            {
                System.out.printf("\nEnter User Name(type quit to exit): ");
                userName = input.nextLine();
                System.out.printf("\nEnter Password: ");
                password = input.nextLine();
                tempPlayer = new Player(userName, password);
                Players.add(tempPlayer);
            }
        }
        return tempPlayer;
    }

    public void addItemMenuOption(Player player, Scanner input)
    {
        String name;
        String tempInt;
        int qty;
        String category;

        System.out.printf("\nWhat is the name of the item you wish to add? ");
        name = input.nextLine();
        System.out.printf("\nAnd how many %s's are we stockpiling? ", name);
        tempInt = input.nextLine();
        System.out.printf("\nUnder what category does this item fall?");

        category = input.nextLine();

        try
        {
            qty = Integer.valueOf(tempInt);
            player.addItem(name, qty, category);
        }
        catch(Exception e)
        {
            System.err.printf("\nNot a Valid amount!");
        }
    }

    public void removeItemFromInventory(Player player, Scanner input)
    {
        InventoryItem remInv;
        String tempInt;
        int choice;

        System.out.printf("\nWhich of the following would you like to remove?\n");
        this.showInventory(player, input);
        tempInt = input.nextLine();
        try
        {
            choice = Integer.valueOf(tempInt);
            choice--;
            remInv = player.removeItem(choice);
            System.out.printf("You have dropped %d %s(s) from your inventory.", remInv.getQuantity(), remInv.getName());
        }
        catch (Exception e)
        {
            System.err.printf("Not a Valid Selection!");
        }
    }

    public void updateItemQuantity(Player player, Scanner input)
    {
        InventoryItem remInv;
        String tempInt;
        int choice;
        int qty;

        System.out.printf("\nWhich of the following would you like to change the inventory quantity?\n");
        this.showInventory(player, input);
        tempInt = input.nextLine();
        try
        {
            choice = Integer.valueOf(tempInt);
            choice--;
            System.out.printf("\nWhat would you like the new quantity to be?");
            tempInt = input.nextLine();
            try
            {
                qty = Integer.valueOf(tempInt);
                if (qty>0)
                {
                    player.updateInventoryQty(choice, qty);
                }
                else if (qty<=0)
                {
                    remInv = player.removeItem(choice);
                    System.out.printf("You have dropped %d %s(s) from your inventory.", remInv.getQuantity(), remInv.getName());
                }
                else
                {
                    System.err.printf("\nNot a valid quantity!");
                }
            }
            catch (Exception e)
            {
                System.err.printf("\nNot a valid quantity!");
            }
        }
        catch (Exception e)
        {
            System.err.printf("Not a Valid Selection!");
        }
    }

    public void Save(String fileLoc)
    {
        savePlayers(fileLoc);
    }

    public void showInventory(Player player, Scanner input)
    {
        System.out.printf("\n\n%4s %28s - %-3s - %-10s\n", "Slot", "Item", "Qty", "Category");
        System.out.printf("__________________________________________________\n");
        for(int i=0;i<player.getInventoryLength();i++)
        {
            System.out.printf("%3d.%28s - [%-2d] - %-10s\n", i+1, player.getInventoryItem(i).getName(),
                    player.getInventoryItem(i).getQuantity(), player.getInventoryItem(i).getCategory() );
        }
    }
}

