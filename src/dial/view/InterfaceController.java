package dial.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import dial.Main;
import dial.model.User;

import javax.xml.soap.Text;

public class InterfaceController {
    @FXML
    private TextField userName;
    @FXML
    private TextField passWord;
    @FXML
    private CheckBox CMC;
    @FXML
    private CheckBox CTC;
    @FXML
    private CheckBox CUC;
    @FXML
    private Button Login;


    private Main main;

    /**
     * default empty constructor
     * */
    public InterfaceController(){}

    /**
     * initializes some part of application
     * eg:
     * */
    @FXML
    private  void initialize(){}

    public void setMain(Main main){
        this.main = main;
    }
}
