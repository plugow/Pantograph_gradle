package mainPackage;



import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;




public class Main extends Application {

    @Override
    public void start(Stage startWindow) throws Exception {


        MainModel.getInstance().currentStage().setOnCloseRequest(event -> Platform.exit());

        Parent root2 = FXMLLoader.load(getClass().getClassLoader().getResource("startWindowStyle.fxml"));
        Parent root3 = FXMLLoader.load(getClass().getClassLoader().getResource("previewStyle.fxml"));
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("mainWindowStyle.fxml"));
        Parent root4 = FXMLLoader.load(getClass().getClassLoader().getResource("editPathStyle.fxml"));

        MainModel.getInstance().currentStage().getIcons().add(new Image("manipulator_logo.png"));


        // set startWindow
        startWindow.getIcons().add(new Image("manipulator_logo.png"));
        //startWindow.
        startWindow.setTitle("Pantograph");
        startWindow.setScene(new Scene(root3, 340, 200));
        startWindow.show();

        //Pause for Preview
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(event -> startWindow.setScene(new Scene(root2, 340, 200)));
        delay.play();

        MainModel.getInstance().currentStage().setTitle("Pantograph");
        MainModel.getInstance().currentStage().setScene(new Scene(root, 900, 600));

        MainModel.getInstance().currentStage().setTitle("Pantograph");
        MainModel.getInstance().getEditStage().setScene(new Scene(root4, 340, 200));










    }






    public static void main(String[] args) {
        launch(args);
    }
}
