package mainPackage;

import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.zu.ardulink.Link;

public class MainModel {
    private final static MainModel instance = new MainModel();

    public static MainModel getInstance() {
        return instance;
    }

    private Label label=new Label();
    public Label currentLabel() {
        return label;
    }

    public Link link=Link.getDefaultInstance();
    public Link currentLink() {
        return link;
    }

    private Stage stage=new Stage();
    public Stage currentStage() {
        return stage;
    }

    public Label value1=new Label("1");
    public Label currentValue1(){return value1;}



}