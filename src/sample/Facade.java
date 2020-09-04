package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Facade
{
    //private Map<Integer,String> userList = new HashMap<>();
    private ArrayList<String> listOfStrings = new ArrayList<>();

    public Facade(Map<Integer, String> userList)
    {
        int itemKey = 1;

        ParseUserInput(userList, itemKey);
    }

    private void ParseUserInput(Map<Integer, String> userList, int itemKey) {
        // Prompt the user for a file path, while giving an example
        //System.out.println("Enter a valid directory path, like C:\\Users\\BobD\\Desktop\\Folder");

        // Create new scanner object, initialize to null
        Scanner inputScanner = new Scanner(System.in);
        String userInput = "";

        System.out.println("What would you like to do? Enter A to add an item, R to remove an item, P to " +
                "print the list to the console window, or E to exit.");
        // get user input, then decide what to do
        // Collect user input, assign to string
        userInput = inputScanner.nextLine();

        if (userInput.toUpperCase().equals("A"))
        {
            String userItemToAdd = "";
            System.out.println("Enter an item to add");
            // Try catch statement to check for error in user input
            try
            {
                // Collect user input, assign to string
                userItemToAdd = inputScanner.nextLine();
                itemKey = AddItemToList(userItemToAdd, userList, itemKey);
            }
            catch (Exception e)
            {
                System.out.println("Error. Invalid entry");
            }
            // get user input, then decide what to do
        }
        else if (userInput.toUpperCase().equals("P"))
        {
            // Print to-do list
            System.out.println("To-Do List:");
            System.out.println("***************************");
            PrintList(userList);
            // get user input, then decide what to do
        }
        else if(userInput.toUpperCase().equals("R"))
        {
            System.out.println("Which item would you like to remove? Enter the number associated with the item");
            String userItemToRemove = "";
            // Try catch statement to check for error in user input
            try
            {
                // Collect user input, assign to string
                userItemToRemove = inputScanner.nextLine();
                int removalKey = Integer.parseInt(userItemToRemove);
                RemoveItemFromList(removalKey, userList);
            }
            catch (Exception e)
            {
                System.out.println("Error. Invalid entry. Please enter a valid integer");
            }
            // get user input, then decide what to do
        }
        else if(userInput.toUpperCase().equals("E"))
        {
            System.out.println("Exiting program.");
            return;
        }
        System.out.println("This happens after E is entered");
        ParseUserInput(userList,itemKey);
    }

    public void getToDoList()
    {
    }

    public int AddItemToList (String addition, Map<Integer,String> userList, int itemKey)
    {
        AddToList addItemToList = new AddToList();
        itemKey = addItemToList.AddItemToList(addition, userList, itemKey);
        return itemKey;
    }

    public void RemoveItemFromList (int itemKey, Map<Integer,String> userList)
    {
        // pass

        RemoveFromList removeItemFromList = new RemoveFromList(userList,itemKey);


        System.out.println("Item removed. The to-do list is now:");
        PrintList(userList);
    }

    public void PrintList (Map<Integer,String> listToPrint)
    {
        PrintToDoList printList = new PrintToDoList();
        printList.PrintList(listToPrint);
    }


    /*
    private static ToDoList uniqueInstance = null;

    private ToDoList()
    {

    }

    public static ToDoList getInstance()
    {
        if(uniqueInstance == null)
        {
            uniqueInstance = new ToDoList();
        }
        return uniqueInstance;
    }
    */

}
