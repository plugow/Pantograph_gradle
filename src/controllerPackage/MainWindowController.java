package controllerPackage;

import javafx.beans.value.ChangeListener;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.math.plot.Plot3DPanel;
import org.zu.ardulink.protocol.IProtocol;
import mainPackage.MainModel;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable{
    private int power=IProtocol.LOW;
    private Stage jogWindow=new Stage();
    SwingNode swingNode = new SwingNode();
    @FXML Label informationBar;
    @FXML Button ledOn;
    @FXML Pane pane;
    double[] point1={50,50,50};
    Plot3DPanel plot3=new Plot3DPanel();
    double[] x = { 0, point1[0], 50, 100};
    double[] y = { 0, point1[1], 100, 100};
    double[] z = { 0, point1[2], 200, 100};


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MainModel.getInstance().currentLabel().textProperty().addListener((observable, oldValue, newValue) -> informationBar.setText(newValue));
        MainModel.getInstance().currentValue1().textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(Integer.parseInt(newValue));
            informationBar.setText(newValue);
            point1[0]-=1;
            double[] x = { 0, point1[0], 50, 100};
            double[] y = { 0, point1[1], 100, 100};
            double[] z = { 0, point1[2], 200, 100};

            plot3=new Plot3DPanel();
            plot3.addLinePlot("plot", Color.BLACK,x,y,z);
            plot3.setPreferredSize(new Dimension(500,500));
            swingNode.setContent(plot3);


        });





        plot3.addLinePlot("plot", Color.BLACK,x,y,z);
        plot3.addScatterPlot("plot2",Color.BLUE,x,y,z);
        plot3.setPreferredSize(new Dimension(500,500));
        swingNode.setContent(plot3);
        pane.getChildren().add(swingNode);




    }


    @FXML private void ledOnClicked() {

        power = IProtocol.HIGH;

        MainModel.getInstance().currentLink().sendPowerPinSwitch(3,power);
        point1[0]+=100;
        point1[1]+=100;
        point1[2]+=100;
        double[] x = { 0, point1[0], 50, 100};
        double[] y = { 0, point1[1], 100, 100};
        double[] z = { 0, point1[2], 200, 100};

        plot3=new Plot3DPanel();
        plot3.addLinePlot("plot", Color.BLACK,x,y,z);
        plot3.setPreferredSize(new Dimension(500,500));
        swingNode.setContent(plot3);





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

    }











}
