package controllerPackage;


import javafx.collections.ListChangeListener;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mainPackage.Compiler;
import mainPackage.ForwardKin;
import mainPackage.Points;
import org.math.plot.Plot3DPanel;
import mainPackage.MainModel;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


public class MainWindowController implements Initializable{
    private Stage jogWindow=new Stage();
    private Stage pathWindow=new Stage();
    private SwingNode swingNode = new SwingNode();
    @FXML Label informationBar;
    @FXML Pane pane;
    @FXML  private TextArea codeArea;
    @FXML Button compiledButton;
    @FXML TableView<Points> savedTableView;
    @FXML TableColumn<Points,String> nameColumn;
    @FXML TableColumn<Points,String> coordinatesColumn;

    private float pi=(float)Math.PI;
    private ForwardKin forwardKin=new ForwardKin();
    private double[] x = new double[5];
    private double[] y = new double[5];
    private double[] z = new double[5];
    private float alfa1=pi/2;
    private float alfa2=pi/2;
    private float alfa3=-pi/2;
    private int effector;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MainModel.getInstance().currentLabel().textProperty().addListener((observable, oldValue, newValue) -> informationBar.setText(newValue));



        MainModel.getInstance().getIntegerList().addListener((ListChangeListener.Change<? extends Integer> c)-> {
                    c.next();

                    if (c.wasReplaced())updatePlot(MainModel.getInstance().getIntegerList());

                }
        );


        nameColumn.setCellValueFactory(cellData-> cellData.getValue().mNameProperty());
        coordinatesColumn.setCellValueFactory(cellData->cellData.getValue().mCoordinatesProperty());
        savedTableView.setItems(MainModel.getInstance().getPointsList());







        setForwardKin(alfa1,alfa2,alfa3,effector);
        pane.getChildren().add(swingNode);





    }





    @FXML private void jogOperationClicked() throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("jogWindowStyle.fxml"));
        jogWindow.setTitle("Pantograph");
        jogWindow.setScene(new Scene(root, 380, 280));
        jogWindow.getIcons().add(new javafx.scene.image.Image("manipulator_logo.png"));
        jogWindow.show();


    }




    private void setForwardKin(float theta1, float theta2, float theta3,int eff){
        float[][] results;
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

        Plot3DPanel plot3=new Plot3DPanel();

        plot3.addLinePlot("plot", Color.BLACK, y,x,z);     //zmienione x-y żeby ze schematem kinematycznym się zgadzało :P
        plot3.addScatterPlot("plot2",Color.BLUE,y,x,z);
        if (eff==118) plot3.getPlot(1).setColor(Color.RED);
        else plot3.getPlot(1).setColor(Color.BLUE);
        plot3.setFixedBounds(0,-50,250);
        plot3.setFixedBounds(1,-300,300);
        plot3.setFixedBounds(2,0,300);
        plot3.setPreferredSize(new Dimension(500,500));


        swingNode.setContent(plot3);


    }


    private void updatePlot(List<Integer> list){
        //System.out.println(list.get(0)+ list.get(1) +list.get(2));
        alfa1=(float)Math.toRadians(list.get(0));
        alfa2=(float)Math.toRadians(list.get(1));
        alfa3=-(float)Math.toRadians(list.get(2));
        effector=list.get(3);
        setForwardKin(alfa1,alfa2,alfa3,effector);



    }



    @FXML private void compiledButtonClicked(){
        String str=codeArea.getText();
        String temp;
        ArrayList<String> commandList=new ArrayList<>();


        StringTokenizer stringTokenizer=new StringTokenizer(str," ,\n");
        while (stringTokenizer.hasMoreTokens()){
            temp=stringTokenizer.nextToken();
            commandList.add(temp);
            System.out.println(temp);
        }
        runMethod(commandList);



//        System.out.println(commandList.size());
//        System.out.println(commandList.get(3));




    }



    @FXML private void clearButtonClicked(){
        MainModel.getInstance().currentStage().close();
    }



    private void runMethod(ArrayList<String> list){
        class CompilerTask implements Runnable{
            Compiler compiler=new Compiler();
            ArrayList<String> list;
            CompilerTask(ArrayList<String> l){list=l;}
            @Override
            public void run() {
                compiler.compile(list);

            }
        }
        Thread thread = new Thread(new CompilerTask(list));
        thread.start();
    }



    @FXML private void openButtonClicked() throws IOException {
        String path=MainModel.getInstance().getPath()+"file.txt";
        String contents = Files.lines(Paths.get(path)).collect(Collectors.joining("\n"));
        codeArea.setText(contents);
    }

    @FXML private void pathDirectoryClicked() throws IOException {

        pathWindow=MainModel.getInstance().getEditStage();
        pathWindow.getIcons().add(new javafx.scene.image.Image("manipulator_logo.png"));
        pathWindow.show();

    }










}
