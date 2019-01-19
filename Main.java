package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;
import java.util.ServiceLoader;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("sample.fxml"));
        VBox rootnode=loader.load();


        MenuBar Menu=createMenu();
        rootnode.getChildren().add(0,Menu);

        primaryStage.setTitle("Temperature Converter");
        primaryStage.setScene(new Scene(rootnode));
        primaryStage.show();
    }
    public MenuBar createMenu(){
        //File menu
        Menu fileMenu=new Menu("File");
        MenuItem NewFile=new MenuItem("New");
        MenuItem QuitFile=new MenuItem("Quit");
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        fileMenu.getItems().addAll(NewFile,separatorMenuItem,QuitFile);

        //ONCLICK of new
        NewFile.setOnAction(event ->  {


                System.out.println("NEW BUTTON IS CLICKED");
            });

        //onclick of quit
        QuitFile.setOnAction(event -> {Platform.exit();
            System.exit(1);

        });

        //help menu
        Menu HelpMenu=new Menu("help");
        MenuItem helpAbout=new MenuItem("About");
        HelpMenu.getItems().addAll(helpAbout);

        helpAbout.setOnAction(event -> { aboutApp();});

        //about menu

        MenuBar root=new MenuBar();
        root.getMenus().addAll(fileMenu,HelpMenu);

        return root;
    }

    public static void aboutApp(){
        Alert AD=new Alert(Alert.AlertType.INFORMATION);
        AD.setTitle("Temperature Converter");
        AD.setHeaderText("MY FIRST APP");
        AD.setContentText("This is basic tool that converts the temperature and thats it");

        //BUTTONs
        ButtonType no =new ButtonType("NO");
        ButtonType yes =new ButtonType("YES");
        AD.getButtonTypes().setAll(yes,no);

        Optional<ButtonType> clickedbtn=AD.showAndWait();
        //check condition
        if(clickedbtn.get()==yes){
            System.out.println("Yes button was clicked");

        }
        else {
            System.out.println("No button was clicked");

        }
    }


    public static void main(String[] args) {
        launch(args);
    }


}
