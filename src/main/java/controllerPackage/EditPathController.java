package controllerPackage;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mainPackage.MainModel;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class EditPathController implements Initializable{
    @FXML private TextField pathField;
    private Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        stage=MainModel.getInstance().getEditStage();
        stage.initModality(Modality.APPLICATION_MODAL);


    }


    @FXML private void okButtonClicked(){
        StringBuilder str=new StringBuilder();
        StringTokenizer stringTokenizer=new StringTokenizer(pathField.getText(),"\\");
        while (stringTokenizer.hasMoreTokens()){
            str.append(stringTokenizer.nextToken());
            str.append("\\\\");
        }

        MainModel.getInstance().setPath(str.toString());

        stage.close();

    }

    @FXML private void cancelButtonClicked(){
        stage.close();

    }



}
