package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Facade
{
    /**
     * Facade accepts a Map of type Integer,String as the to-do list.
     * @param userList The main list used for storing the user's items. This gets passed to all other objects.
     */
    public Facade(Map<Integer, String> userList)
    {
        // Initialize the object's primary key
        int itemKey = 1;

        // Pass the primary key and Map to the input handler method
        ParseUserInput(userList, itemKey);
    }

    /**
     * This method will handle all user input, and pass control to other objects depending on what the user wants to do.
     * @param userList The main list used for storing the user's items.
     * @param itemKey The primary key identifier for each to do list item.
     */
    private void ParseUserInput(Map<Integer, String> userList, int itemKey)
    {
        // Create new scanner object, initialize to null
        Scanner inputScanner = new Scanner(System.in);
        String userInput = "";

        // Prompt the user for input
        System.out.println("What would you like to do? Enter A to add an item, R to remove an item, P to " +
                "print the list to the console window, or E to exit and show a list graphic .");

        // Collect user input, assign to string
        userInput = inputScanner.nextLine();

        // Control structure to determine what to do based on the user's input
        // If the user wants to add an item
        if (userInput.toUpperCase().equals("A"))
        {
            String userItemToAdd = "";
            System.out.println("Enter an item to add");

            // Try catch statement to check for error in user input
            try
            {
                // Collect user input, assign to string
                userItemToAdd = inputScanner.nextLine();
                // Pass control to the AddItemToList method. Pass the user list, the user input, and the primary key
                itemKey = AddItemToList(userItemToAdd, userList, itemKey);
            }
            catch (Exception e)
            {
                System.out.println("Error. Invalid entry");
            }
        }
        // If the user wants to print the list to the console window
        else if (userInput.toUpperCase().equals("P"))
        {
            // Print to-do list
            System.out.println("To-Do List:");
            System.out.println("***************************");
            PrintList(userList);
        }
        // If the user wants to remove an item from the to-do list
        else if(userInput.toUpperCase().equals("R"))
        {
            // Check if the list is empty, if yes then print an error message
            if (userList.size() < 1)
            {
                System.out.println("Error: Cannot remove item. There are no items in the list.");
            }
            else
            {
                System.out.println("Which item would you like to remove? Enter the number associated with the item");
                String userItemToRemove = "";
                // Try catch statement to check for error in user input
                try
                {
                    // Collect user input, assign to string
                    userItemToRemove = inputScanner.nextLine();

                    // Parse the input as an integer
                    int removalKey = Integer.parseInt(userItemToRemove);

                    // Pass the primary key and to-do list to the remove item method
                    RemoveItemFromList(removalKey, userList);
                }
                catch (Exception e)
                {
                    System.out.println("Error. Invalid entry. Please enter a valid integer");
                }
                // get user input, then decide what to do
            }

        }
        // If the user wants to exit the program and display the GUI
        else if(userInput.toUpperCase().equals("E"))
        {
            System.out.println("Exiting program, displaying list graphic.");
            return;
        }

        // Recursive call to continue gathering user input
        ParseUserInput(userList,itemKey);
    }

    /**
     * Method for adding a user defined item to the to-do list
     * @param addition String to be added to the list
     * @param userList The main list used for storing the user's items.
     * @param itemKey The primary key identifier for each to do list item.
     * @return
     */
    public int AddItemToList (String addition, Map<Integer,String> userList, int itemKey)
    {
        // Create new AddToList object and call the method that adds items to the list
        AddToList addItemToList = new AddToList();

        // Update the primary key after the newest item was added
        itemKey = addItemToList.AddItemToList(addition, userList, itemKey);

        // Return the primary key
        return itemKey;
    }

    /**
     * Method for removing an item from the to-do list
     * @param userList The main list used for storing the user's items.
     * @param itemKey The primary key identifier for each to do list item.
     */
    public void RemoveItemFromList (int itemKey, Map<Integer,String> userList)
    {
        // Create a new RemoveFromList object and pass the to-do list and primary key value
        RemoveFromList removeItemFromList = new RemoveFromList(userList,itemKey);

        System.out.println("Item removed. The to-do list is now:");

        // Print the updated to-do list
        PrintList(userList);
    }

    /**
     * Method for printing the to-do list
     * @param listToPrint The main list used for storing the user's items.
     */
    public void PrintList (Map<Integer,String> listToPrint)
    {
        PrintToDoList printList = new PrintToDoList();
        printList.PrintList(listToPrint);
    }
}
