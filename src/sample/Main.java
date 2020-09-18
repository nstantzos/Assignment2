/*
Program written by Nick Stantzos, 9-6-2020
This program will allow the user to create a to-do list, add items to the list, remove items from the list, and print
the list to the console window. As a bonus, this list will also be printed to a listview object in the primary stage
when the user exits the program. The program is structured as having a Main.java class that quickly passes control to
a facade, which then directs control to three different objects, depending on the user's input. The console will
continuously prompt the user for input until the exit key is specified. An Integer, String map is passed to each object
to retain memory of the to-do list.
*/

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

    /**
     * Launches the window containing the list view graphic
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // Set the title of the primary stage
        primaryStage.setTitle("To-Do List. Better get on it!");

        // Create a listview object
        ListView listView = new ListView();

        // Populate the listview object with the to-do list's items
        toDoList.entrySet().forEach(entry ->
        {
            listView.getItems().add(entry.getValue());
        });

        // Create a vertical box for symmetry
        VBox vbox = new VBox(listView);

        // Define scene default dimensions
        Scene scene = new Scene(vbox, 300, 420);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * Main method to execute code
     * @param args
     */
    public static void main(String[] args)
    {
        // Start new to-do list and initialize objects used to store and manage the list
        System.out.println("Starting a new to-do list.");

        // Pass the <Integer,String> map into the Facade object for construction
        // Control passes to this object, where user input is handled
        Facade manageUserList = new Facade(toDoList);

        // Launch the primary stage
        launch(args);
        System.out.println("A job well done!");
    }
}
