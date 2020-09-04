package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        System.out.println("Hello World");
        System.out.println("Do you want to start a new to-do list?");

        // if yes, create a map and pass it to the facade
        Map<Integer,String> toDoList = new HashMap<>();
        ToDoList List = new ToDoList();
        Facade manageUserList = new Facade(toDoList);
        ArrayList<String> printedList = new ArrayList<>();


        // if no, then say goodbye and exit program

        /*
        String test = "bobdole";
        String test1 = "robdole";
        String test2 = "cobdole";
        printedList.addAll(manageUserList.AddItemToList(test));
        printedList.addAll(manageUserList.AddItemToList(test1));
        printedList.addAll(manageUserList.AddItemToList(test2));
         */

        launch(args);
    }
}
