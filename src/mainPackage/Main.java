package mainPackage;



import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;



public class Main extends Application {


    @Override
    public void start(Stage startWindow) throws Exception {

        MainModel.getInstance().currentStage().setOnCloseRequest(event -> Platform.exit());

        Parent root2 = FXMLLoader.load(getClass().getResource("../ViewPackage/startWindowStyle.fxml"));
        Parent root3 = FXMLLoader.load(getClass().getResource("../ViewPackage/previewStyle.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("../ViewPackage/mainWindowStyle.fxml"));



        // set startWindow
        startWindow.setTitle("Pantograph");
        startWindow.setScene(new Scene(root3, 300, 300));
        //startWindow.initModality(Modality.APPLICATION_MODAL);
        startWindow.show();

        //Pause for Preview
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(event -> startWindow.setScene(new Scene(root2, 300, 300)));
        delay.play();

        MainModel.getInstance().currentStage().setTitle("Pantograph");
        MainModel.getInstance().currentStage().setScene(new Scene(root, 500, 500));





    }






    public static void main(String[] args) {
        launch(args);
    }
}
