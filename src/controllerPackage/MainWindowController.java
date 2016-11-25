package controllerPackage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.zu.ardulink.protocol.IProtocol;
import mainPackage.MainModel;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable{
    private int power=IProtocol.LOW;
    Stage jogWindow=new Stage();
    @FXML
    Label informationBar;
    @FXML Button ledOn;


    //public Stage stage=(Stage) informationBar.getScene().getWindow();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //informationBar.setText("Status: "+MainModel.getInstance().currentLabel().getText());


    }


    @FXML private void ledOnClicked() {

        power = IProtocol.HIGH;

        MainModel.getInstance().currentLink().sendPowerPinSwitch(3,power);



    }

    @FXML private void ledOffClicked() {
        power = IProtocol.LOW;

        MainModel.getInstance().currentLink().sendPowerPinSwitch(3,power);




    }


    @FXML private void jogOperationClicked() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../ViewPackage/jogWindowStyle.fxml"));
        jogWindow.setTitle("Pantograph");
        jogWindow.setScene(new Scene(root, 400, 400));
        jogWindow.show();


    }

    @FXML private void disconnectButtonClicked(){
        //MainModel.getInstance().currentLink().disconnect();
        //Link.destroyInstance(MainModel.getInstance().currentLink().getName());
    }











}
