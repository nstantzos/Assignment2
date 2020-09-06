package sample;

import java.util.Map;

public class RemoveFromList
{
    /**
     * Method for removing items from the to-do list
     * @param userList The main list used for storing the user's items.
     * @param itemKey The primary key identifier for each to do list item.
     */
    public RemoveFromList(Map<Integer,String> userList, int itemKey)
    {
        // Use the item key to remove the to-do list item
        userList.remove(itemKey);
    }

}
