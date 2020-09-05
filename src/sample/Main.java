package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application
{

    public static Map<Integer,String> toDoList = new HashMap<>();

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        /*
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        */
        primaryStage.setTitle("To-Do List. Better get on it!");

        ListView listView = new ListView();

        toDoList.entrySet().forEach(entry ->
        {
            listView.getItems().add(entry.getValue());
        });

        /*
        listView.getItems().add("Item 1");
        listView.getItems().add("Item 2");
        listView.getItems().add("Item 3");
        */

        //HBox hbox = new HBox(listView);
        VBox vbox = new VBox(listView);

        Scene scene = new Scene(vbox, 300, 420);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args)
    {
        System.out.println("Starting a new to-do list.");

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
