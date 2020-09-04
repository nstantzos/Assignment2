package sample;

import java.util.ArrayList;

public class PrintToDoList
{
    public void PrintList (ArrayList<String> listToPrint)
    {
        for (int i = 0; i < listToPrint.size(); i++)
        {
            System.out.println(i + 1 + ": " + listToPrint.get(i));
        }
    }
}
