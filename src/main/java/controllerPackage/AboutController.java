package controllerPackage;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import mainPackage.MainModel;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutController implements Initializable{
    private Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        stage=MainModel.getInstance().getAboutStage();


    }


    @FXML private void okButtonClicked(){

        stage.close();

    }



}
