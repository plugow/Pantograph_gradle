package controllerPackage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import mainPackage.MainModel;
import org.zu.ardulink.Link;

import java.io.IOException;
import java.util.List;
import static javafx.application.Platform.exit;


public class StartWindowController {

    private Link link= MainModel.getInstance().currentLink();
    private List<String> portList;
    @FXML public Label label;
    @FXML private Button connectButton;




    @FXML public void initialize() throws IOException {
        System.out.println("włączanie");


    }

    @FXML private void checkButtonClicked(){
        System.out.println("wyjdx");
        exit();
    }

    @FXML private void connectButtonClicked(){
        System.out.println("connect");
        try {

            portList = link.getPortList();
            if(portList != null && portList.size() > 0) {
                String port = portList.get(0);
                label.setText("dostepny port: "+port);
                boolean connected = link.connect(port);
                System.out.println("Connected:" + connected);
                System.out.println(link.isConnected());

                //close this window
                Stage startWindow=(Stage) connectButton.getScene().getWindow();
                startWindow.close();

                //send is connected to main window

                MainModel.getInstance().currentLabel().setText("connected");

                //set mainWindow
                MainModel.getInstance().currentStage().show();


            }
            else label.setText("port niedostepny");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML private void simulationModeClicked(){
        Stage startWindow=(Stage) connectButton.getScene().getWindow();
        startWindow.close();
        MainModel.getInstance().currentLabel().setText("simulation mode");
        MainModel.getInstance().currentStage().show();
    }





}
