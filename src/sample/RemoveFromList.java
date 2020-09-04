package sample;

import java.util.ArrayList;
import java.util.Map;

public class RemoveFromList
{
    public RemoveFromList(Map<Integer,String> userList, int itemKey)
    {
        // Use the item key to remove the to-do list item
        ArrayList<String> toDoWordList = new ArrayList<>();
        userList.remove(itemKey);
    }

}
