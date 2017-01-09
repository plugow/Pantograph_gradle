package controllerPackage;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mainPackage.MainModel;

import java.net.URL;
import java.util.ResourceBundle;

public class LoadController implements Initializable{
    @FXML private TextField nameField;
    @FXML private Button cancelButton;
    private Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        stage=MainModel.getInstance().getLoadStage();
        stage.initModality(Modality.APPLICATION_MODAL);


    }


    @FXML private void loadButtonClicked(){

        MainModel.getInstance().setNameFile(nameField.getText()+".txt");
        stage.close();

    }

    @FXML private void cancelButtonClicked(){
        stage.close();

    }



}
