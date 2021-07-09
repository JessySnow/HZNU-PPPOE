package dial.view;

import dial.model.Connection;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import dial.Main;
import dial.model.User;
import dial.model.Win_CMD;
import dial.RunCmd;

public class InterfaceController {
    @FXML
    private ToggleGroup ISP;
    @FXML
    private TextField userName;
    @FXML
    private TextField passWord;
    @FXML
    private RadioButton CMC;
    @FXML
    private RadioButton CTC;
    @FXML
    private RadioButton CUC;
    @FXML
    private Button Login;

    private Main main;
    private User user;
    private RunCmd runCmd;
    private Connection connection;

    /**
     * default empty constructor
     * */
    public InterfaceController(){}

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private  void initialize(){
        CMC.setToggleGroup(ISP);
        CTC.setToggleGroup(ISP);
        CUC.setToggleGroup(ISP);
    }

    /**
     * if one of three RadioButton is selected
     * return true
     * else return false
     *
     * @return selected
     * */
    private boolean isSelected(){
        boolean selected = false;
        return selected;
    }

    public void setMain(Main main){
        this.main = main;
    }

    /**
     * show info of user in text_field and check_box if application is configured before
     *
     * */
    private void showUserInfo(){
        if(!user.getUserName().equals("null") && !user.getPassWord().equals("null") && user.getType() != 3){
            this.userName.setText(user.getUserName());
            this.passWord.setText(user.getPassWord());
            switch (user.getType()){
                case 0:
                    this.CMC.setSelected(true);
                    break;
                case 1:
                    this.CTC.setSelected(true);
                    break;
                case 2:
                    this.CUC.setSelected(true);
                    break;
                default:
                    System.exit(1);
            }
        }
    }

    /**
     * set user's info if user click the Login button
     * but not write the info to props util the dial is
     * success
     *
     * @param user
     * */
    public void setUserInfo(User user){
        if(isSelected() && !passWord.getText().trim().equals("" ) && !userName.getText().trim().equals(" ")){
            user.setUserName(userName.getText());
            user.setPassWord(passWord.getText());
        }
    }

    /**
     * try to dial
     * */
    @FXML
    private void handleDial(){}
}
