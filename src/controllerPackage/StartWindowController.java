package controllerPackage;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import mainPackage.MainModel;
import org.zu.ardulink.Link;
import java.util.List;
import static javafx.application.Platform.exit;


public class StartWindowController {




    public Link link= MainModel.getInstance().currentLink();
    public List<String> portList;
    //Stage mainWindow=new Stage();
    @FXML public Label label;
    @FXML private Button connectButton;



    @FXML public void initialize(){
        System.out.println("włączanie");


    }

    @FXML private void checkButtonClicked(){
        System.out.println("wyjdx");
        exit();
    }

    @FXML private void connectButtonClicked(){
        System.out.println("connect");
        try {

            //link = Link.getDefaultInstance();
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
                //final Parent root = FXMLLoader.load(getClass().getResource("../ViewPackage/mainWindowStyle.fxml"));
                MainModel.getInstance().currentStage().show();
                //mainWindow.show();
                //final FXMLLoader loader=new FXMLLoader(getClass().getResource("../ViewPackage/mainWindowStyle.fxml"));
                //final MainWindowController controller = loader.getController();
                //controller.setStage(this.mainWindow);

            }
            else label.setText("port niedostepny");

        }catch (Exception e){
            e.printStackTrace();
        }
    }





}
