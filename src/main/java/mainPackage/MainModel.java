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

    private Label label=new Label();
    public Label currentLabel() {
        return label;
    }

    private Link link=Link.getDefaultInstance();
    public Link currentLink() {
        return link;
    }

    private Stage stage=new Stage();
    public Stage currentStage() {
        return stage;
    }

    private Stage editStage=new Stage();
    public Stage getEditStage() {
        return editStage;
    }


    public void setCheckMode(boolean checkMode) {
        this.checkMode = checkMode;
    }

    private boolean checkMode=false;

    private ObservableList<Integer> integerList = FXCollections.observableArrayList(1,2,3,0);

    public ObservableList<Integer> getIntegerList() {

        return integerList;
    }


    public boolean isCheckMode() {
        return checkMode;
    }

    private ObservableList<Points> pointsList = FXCollections.observableArrayList();


    public ObservableList<Points> getPointsList() {
        return pointsList;
    }

    public void setNumberOfPoint(Integer numberOfPoint) {
        this.numberOfPoint = numberOfPoint;
    }

    public Integer getNumberOfPoint() {
        return numberOfPoint;
    }

    private Integer numberOfPoint=0;


    private StringProperty path=new SimpleStringProperty("C:\\Users\\Pawel\\Desktop\\temp\\");

    public String getPath() {
        return path.get();
    }

    public void setPath(String path) {
        this.path.set(path);
    }

    public StringProperty pathProperty() {
        return path;

    }
}