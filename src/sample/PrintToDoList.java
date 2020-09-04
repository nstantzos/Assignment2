package sample;

import java.util.Map;

public class PrintToDoList
{
    public void PrintList (Map<Integer,String> listToPrint)
    {
        listToPrint.entrySet().forEach(entry ->{
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });
    }
}
