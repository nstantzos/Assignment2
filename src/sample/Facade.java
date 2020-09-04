package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Facade ()
{
    //private Map<Integer,String> userList = new HashMap<>();
    private ArrayList<String> listOfStrings = new ArrayList<>();

    public Facade(Map<Integer, String> userList)
    {
        System.out.println("What would you like to do? Enter A to add an item, R to remove an item, P to " +
                "print the list to the console window, or E to exit.");
        // get user input, then decide what to do
        String userItemToAdd = "newString";
        AddToList(userItemToAdd, userList);

    }

    public Map<Integer,String> getToDoList()
    {
        return userList;
    }

    public void AddItemToList (String addition, Map<Integer,String> userList)
    {
        AddToList addItemToList = new AddToList();
        listOfStrings = addItemToList.AddItemToList(addition, userList);
    }

    public ArrayList<String> RemoveItemFromList (int itemKey)
    {
        // pass
        return
    }

    public void PrintList (ArrayList<String> listToPrint)
    {
        PrintToDoList printList = new PrintToDoList();
        printList.PrintList(listToPrint);
    }

    Map<Integer,String> bobDole = getToDoList();

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
