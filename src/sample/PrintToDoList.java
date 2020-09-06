package sample;

import java.util.Map;

public class PrintToDoList
{
    /**
     * Method for printing the to-do list to the console
     * @param listToPrint The main list used for storing the user's items.
     */
    public void PrintList (Map<Integer,String> listToPrint)
    {
        // Loop through the map and print each key and value pair to the console
        listToPrint.entrySet().forEach(entry ->
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });
    }
}
