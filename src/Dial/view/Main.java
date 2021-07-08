package Dial.view;

import javafx.application.Application; import javafx.fxml.FXMLLoader; import javafx.scene.layout.AnchorPane; import javafx.stage.Stage; import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void showInterfaceView(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Interface.fxml"));
            AnchorPane InterfaceView = (AnchorPane) loader.load();

            InterfaceViewController IntView = loader.getController();
            IntView.setMain(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
