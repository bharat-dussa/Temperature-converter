package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Float.parseFloat;

public class Controller implements Initializable {

    @FXML
    public Label IDLabel;
    @FXML
    public ChoiceBox IDConverter;
    @FXML
    public TextField IDText;
    @FXML
    public Button IDButton;

    private String  C_F="Degree to Fehernheit";
    private String F_C="Fehernheit to Degree";

    private boolean isC_F=true;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        IDConverter.getItems().add(C_F);
        IDConverter.getItems().add(F_C);
        IDConverter.setValue(C_F);

        IDConverter.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue.equals(C_F)){
                isC_F=true;

            }else{
                isC_F=false;
            }

        });
        IDButton.setOnAction(event -> {
            convert();
        });

    }

    private void convert(){
       //gather input info
       String input= IDText.getText();

       float inTemp=0.0f;
       try {
           inTemp = Float.parseFloat(input);
       }catch (Exception e){
           warn();
           return;
        }



      float newTemp=0.0f;
      if(isC_F){
          newTemp=(inTemp*9/5)*32;
      //      unit=C;
      }else {
          newTemp=(inTemp-32)*5/3;
        //    unit=F;
      }
      String unit=isC_F? "F":"C";

        Alert AD=new Alert(Alert.AlertType.INFORMATION);
      AD.setTitle("Results");
      AD.setContentText("Converted Temperature is "+newTemp+unit);
      AD.show();





    }

    private void warn() {
    Alert A=new Alert(Alert.AlertType.ERROR);
    A.setTitle("Error Occured");
    A.setContentText("Enter a valid Temperature");
    A.show();
    }
}
