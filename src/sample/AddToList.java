package sample;

import java.util.ArrayList;
import java.util.Map;

public class AddToList
{
    private int primaryKey = 0;
    public ArrayList<String> AddItemToList(String itemToAdd, Map<Integer,String> userList)
    {
        ArrayList<String> toDoWordList = new ArrayList<>();
        userList.put(primaryKey,itemToAdd);

        userList.entrySet().forEach(entry ->{
            toDoWordList.add(entry.getValue());
        });

        primaryKey++;
        return toDoWordList;
    }

}
