package Dial.view;
import javafx.fxml.FXML; import javafx.scene.control.Label;
public class InterfaceViewController {
    @FXML
    private Label userName;
    @FXML
    private Label passWord;
    @FXML
    private Label ISP_CTC;
    @FXML
    private Label ISP_CMCC;
    @FXML
    private Label ISP_CUC;
    //Main.java
    private Main main;

    /**
     * default constructor
     * */
    public InterfaceViewController(){}

    /**
     * called by Main to give a reference to itself
     *
     * @param main
     * */
    public void setMain(Main main){
        this.main = main;
    }
}
