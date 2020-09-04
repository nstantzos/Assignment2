package sample;

import java.util.ArrayList;
import java.util.Map;

public class AddToList
{

    public int AddItemToList(String itemToAdd, Map<Integer,String> userList, int itemKey)
    {
        ArrayList<String> toDoWordList = new ArrayList<>();
        userList.put(itemKey,itemToAdd);

        /*
        userList.entrySet().forEach(entry ->{
            toDoWordList.add(entry.getValue());
        });
         */

        itemKey++;
        return itemKey;
    }

}
