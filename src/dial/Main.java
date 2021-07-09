package dial;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage primaryStage;
    private Pane Interface;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        /**
         * set title of application
         * set icon of application
         * */
        this.primaryStage.setTitle("HZNU-Dial");
        this.primaryStage.getIcons().add(new Image("file:resources/images/Icon.png"));
        this.primaryStage.setResizable(false);
        initInterface();
    }

    /**
     * init interface
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
        }catch (IOException e){
            System.exit(1);
        }
    }

    /**
     * Returns the main stage.
     * @return primaryStage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
