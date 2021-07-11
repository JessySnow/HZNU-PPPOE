package dial;

import dial.view.InterfaceController;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/* start javafx application */
public class Main extends Application {
    private Stage primaryStage;
    private Pane Interface;

    /**
     * this method will run automatically
     * when application is run
     * */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        /**
         * set title of application
         * set icon of application
         * set application un resizable
         * */
        this.primaryStage.setTitle("HZNU-Dial");
        this.primaryStage.getIcons().add(new Image("file:resources/images/Icon.png"));
        this.primaryStage.setResizable(false);
        initInterface();
    }

    /**
     * init interface layout
     * load pane from Interface.fxml file
     * and show in on screen
     * */
    public void initInterface(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Interface.fxml"));
            Interface = (Pane) loader.load();

            Scene scene = new Scene(Interface);
            primaryStage.setScene(scene);
            primaryStage.show();

            /**
             *  Give the controller to the Main so that
             *  Main can get access of the controller on the pane
             *
             *  the controller is get from fxml file
             *  so it's using fxml api to load
             *  */
            InterfaceController controller = loader.getController();
            controller.setMain(this);
        }catch (IOException e){
            System.exit(1);
        }
    }

    /**
     * Returns the main stage.
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
