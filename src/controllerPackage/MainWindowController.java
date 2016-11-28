package controllerPackage;


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
import mainPackage.ForwardKin;
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
    double pi=Math.PI;
    Plot3DPanel plot3=new Plot3DPanel();
    ForwardKin forwardKin=new ForwardKin();
    double[][] results=new double[4][3];
    double[] x = new double[5];
    double[] y = new double[5];
    double[] z = new double[5];
    double alfa1=pi/2;
    double alfa2=pi/2;
    double alfa3=pi/2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MainModel.getInstance().currentLabel().textProperty().addListener((observable, oldValue, newValue) -> informationBar.setText(newValue));
        MainModel.getInstance().currentValue1().textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(Integer.parseInt(newValue));
            informationBar.setText(newValue);
            alfa1-=pi/180;
            setForwardKin(alfa1,alfa2,alfa3);



        });





        setForwardKin(alfa1,alfa2,alfa3);
        pane.getChildren().add(swingNode);




    }


    @FXML private void ledOnClicked() {

        power = IProtocol.HIGH;

//        MainModel.getInstance().currentLink().sendPowerPinSwitch(3,power);
//        point1[0]+=100;
//        point1[1]+=100;
//        point1[2]+=100;
//        double[] x = { 0, point1[0], 50, 100};
//        double[] y = { 0, point1[1], 100, 100};
//        double[] z = { 0, point1[2], 200, 100};
//        plot3.removeAllPlots();
//        plot3=new Plot3DPanel();
//        plot3.addLinePlot("plot", Color.BLACK,x,y,z);
//        plot3.setPreferredSize(new Dimension(500,500));
//
//        swingNode.setContent(plot3);





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


    public void setForwardKin(double theta1, double theta2, double theta3){
        results=forwardKin.forward(theta1,theta2,theta3);
        x[1]=results[0][0];
        y[1]=results[0][1];
        z[1]=results[0][2];

        x[2]=results[1][0];
        y[2]=results[1][1];
        z[2]=results[1][2];

        x[3]=results[2][0];
        y[3]=results[2][1];
        z[3]=results[2][2];

        x[4]=results[3][0];
        y[4]=results[3][1];
        z[4]=results[3][2];

        plot3=new Plot3DPanel();

        plot3.addLinePlot("plot", Color.BLACK,x,y,z);
        plot3.addScatterPlot("plot2",Color.BLUE,x,y,z);
        plot3.setFixedBounds(0,-600,500);
        plot3.setFixedBounds(1,-500,500);
        plot3.setFixedBounds(2,0,1000);
        plot3.setPreferredSize(new Dimension(500,500));

        swingNode.setContent(plot3);

    }











}
