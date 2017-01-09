package controllerPackage;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mainPackage.MainModel;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class SaveController implements Initializable{
    @FXML private TextField nameField;

    private Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        stage=MainModel.getInstance().getSaveStage();
        stage.initModality(Modality.APPLICATION_MODAL);


    }


    @FXML private void saveButtonClicked(){
        StringTokenizer stringTokenizer=new StringTokenizer(MainModel.getInstance().getCommandLine(),"\n");

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(MainModel.getInstance().getPath()+nameField.getText()+".txt"), StandardCharsets.UTF_8))) {

            while (stringTokenizer.hasMoreTokens()){
                writer.write(stringTokenizer.nextToken());
                writer.newLine();


            }

            System.out.println(MainModel.getInstance().getCommandLine());
        } catch (IOException ex) {
            // handle me
        }

        stage.close();

    }

    @FXML private void cancelButtonClicked(){
        stage.close();

    }



}
