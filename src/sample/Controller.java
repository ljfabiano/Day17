package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    ListView todoList;//As you are adding items to the list view you are adding .to string for the non string lines in the list, and so you override to get the desired output because we know the list is not strings

    @FXML
    TextField todoText;

    ObservableList<ToDoItem> todoItems = FXCollections.observableArrayList();//factory method//why interfaces are so powerful
    //we are getting the interface only even though the object being returned iis of a different type, but implements the interface

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        todoList.setItems(todoItems);//two way data binding between observable list and the observable list
    }

    public void addItem() {
        System.out.println("Adding item ...");
        todoItems.add(new ToDoItem(todoText.getText()));
        todoText.setText("");
        //todoItems.add(new ToDoItem("Sample"));
    }

    public void removeItem() {
        //System.out.println("Removing item ...");
        //todoList.
        ToDoItem todoItem = (ToDoItem)todoList.getSelectionModel().getSelectedItem();//returns the selected item(not just the text, but all of the elements of the item/object). It is cast to the to do item
        System.out.println("Removing " + todoItem.text + " ...");
        todoItems.remove(todoItem);
    }

    public void toggleItem() {
        System.out.println("Toggling item ...");
        ToDoItem todoItem = (ToDoItem)todoList.getSelectionModel().getSelectedItem();
        if (todoItem != null) {
            todoItem.isDone = !todoItem.isDone;
            todoList.setItems(null);//refreshing the list
            todoList.setItems(todoItems);
        }
    }

    public void allDone() {
        System.out.println("Marking all items as done ...");
        //todoList.getSelectionModel().getSelectedItem();
        for (ToDoItem todoItem : todoItems)
        {
            todoItem.isDone = true;
            todoList.setItems(null);//refreshing the list
            todoList.setItems(todoItems);

        }

    }

    public void allIncomplete() {
        System.out.println("Marking all items as incomplete ...");
        //ToDoItem todoItem = (ToDoItem)todoList.getSelectionModel().getSelectedItem();
        for (ToDoItem todoItem : todoItems)
        {
            todoItem.isDone = false;
            todoList.setItems(null);//refreshing the list
            todoList.setItems(todoItems);
        }
    }

    public void toggleAll() {
        System.out.println("Toggling all items ...");
        //ToDoItem todoItem = (ToDoItem)todoList.getSelectionModel().getSelectedItem();
        for (ToDoItem todoItem : todoItems) {
            //todoItem.isDone = false;

            if (todoItem != null) {
                todoItem.isDone = !todoItem.isDone;
                todoList.setItems(null);//refreshing the list
                todoList.setItems(todoItems);
            }
        }
    }


}
