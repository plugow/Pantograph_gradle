package mainPackage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.zu.ardulink.Link;

public class MainModel{
    private final static MainModel instance = new MainModel();

    public static MainModel getInstance() {
        return instance;
    }



    //Label in main stage to show actual mode
    private Label label=new Label();
    public Label currentLabel() {
        return label;
    }

    private Link link=Link.getDefaultInstance();
    public Link currentLink() {
        return link;
    }

    // main stage!
    private Stage stage=new Stage();
    public Stage currentStage() {
        return stage;
    }

    private Stage editStage=new Stage();
    public Stage getEditStage() {
        return editStage;
    }

    private Stage loadStage=new Stage();
    public Stage getLoadStage() {
        return loadStage;
    }

    private Stage saveStage=new Stage();
    public Stage getSaveStage() {
        return saveStage;
    }

    private Stage aboutStage=new Stage();
    public Stage getAboutStage() {
        return aboutStage;
    }



    // flag to check mode of programm(simulation/connect)
    private boolean checkMode=false;
    public void setCheckMode(boolean checkMode) {
        this.checkMode = checkMode;
    }
    public boolean isCheckMode() {
        return checkMode;
    }


    // Observable for aktual angles values
    private ObservableList<Integer> integerList = FXCollections.observableArrayList(90,90,90,90);
    public ObservableList<Integer> getIntegerList() {return integerList;}




    // observable to list of Points
    private ObservableList<Points> pointsList = FXCollections.observableArrayList();
    public ObservableList<Points> getPointsList() {
        return pointsList;
    }


    // number to create name of points
    private Integer numberOfPoint=0;
    public void setNumberOfPoint(Integer numberOfPoint) {
        this.numberOfPoint = numberOfPoint;
    }
    public Integer getNumberOfPoint() {
        return numberOfPoint;
    }

    //actual path to save and load files
    private String path="C:\\Users\\Pawel\\Desktop\\temp\\";
    public String getPath() {return path;}
    public void setPath(String path) {this.path = path;}


//    // actual name of file
//    private String nameFile="file.txt";
//    public String getNameFile() {return nameFile;}
//    public void setNameFile(String nameFile) {this.nameFile = nameFile;}

    private StringProperty nameFile =new SimpleStringProperty("name");

    public String getNameFile() {
        return nameFile.get();
    }

    public StringProperty nameFileProperty() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile.set(nameFile);
    }

    private StringProperty commandLine=new SimpleStringProperty();

    public String getCommandLine() {
        return commandLine.get();
    }

    public StringProperty commandLineProperty() {
        return commandLine;
    }

    public void setCommandLine(String commandLine) {
        this.commandLine.set(commandLine);
    }
}