package controllerPackage;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mainPackage.MainModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditPathController implements Initializable{
    @FXML private TextField pathField;
    @FXML private Button cancelButton;
    private Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        stage=MainModel.getInstance().getEditStage();
        stage.initModality(Modality.APPLICATION_MODAL);


    }


    @FXML private void okButtonClicked(){
        MainModel.getInstance().setPath(pathField.getText());

        stage.close();

    }

    @FXML private void cancelButtonClicked(){
        stage.close();

    }



}
