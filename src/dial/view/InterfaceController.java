package dial.view;

import dial.ConfigDial;
import dial.model.Connection;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import dial.Main;
import dial.model.User;
import dial.RunCmd;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.TrayIcon.MessageType;

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

    private SystemTray systemTray;
    private TrayIcon trayIcon;

    private Main main;
    private User user;
    private RunCmd runCmd;
    private Connection connection;
    private ConfigDial configDial;


    /**
     * pop notification
     * */
    private void showAwtNotification(){
        systemTray = SystemTray.getSystemTray();
        try{
            Image notiImage = Toolkit.getDefaultToolkit().createImage("resources/images/Noti.png");
            trayIcon = new TrayIcon(notiImage, "Status");
            trayIcon.setImageAutoSize(true);
            systemTray.add(trayIcon);
            trayIcon.displayMessage("连接状态", connection.getStatus().getStatusInfo(), MessageType.INFO);
        }catch (AWTException e){
            System.exit(-2);
        }
    }

    /**
     * default empty constructor
     * */
    public InterfaceController(){}

    /* judge if all blank is filled */
    private boolean isFilled(){
        return (!userName.getText().trim().equals("") &&
                !passWord.getText().trim().equals(""));
    }
    /* judge if any radius button is selected */
    private boolean isSelected(){
        RadioButton selectedRadioButton = (RadioButton) ISP.getSelectedToggle();
        return selectedRadioButton != null;
    }
    /* get user type from the radio button selected */
    private int getType(){
        RadioButton selectedRadioButton = (RadioButton) ISP.getSelectedToggle();
        if(selectedRadioButton == CTC)  {
            return 0;
        }
        else if (selectedRadioButton == CMC){
            return 1;
        }
        else {
            return 2;
        }
    }

    /**
     * get main from Main.java
     * */
    public void setMain(Main main){
        this.main = main;
    }

    /**
     * show info of user in text_field and check_box if application is configured before
     * */
    @FXML
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
     * */
    private void setUserInfo(){
        user.setUserName(userName.getText());
        user.setPassWord(passWord.getText());
        user.setType(getType());
    }
    private void setCMDInfo(){
        runCmd = new RunCmd(user);
    }
    private void setConnectionInfo(){
        connection = new Connection();
        connection.setStatus(runCmd.getStatus());
        if(connection.getStatus().equals("认证成功,已连接")){
            configDial.saveProps();
        }
    }
    private void initConfig(){
        configDial = new ConfigDial();
        configDial.loadProps();
    }
    /**
     * get user's info from config file
     */
    private void loadUserInfo(){
        user.setUserName(configDial.getUserName());
        user.setPassWord(configDial.getPassWord());
        user.setType(configDial.getType());
    }

    /**
     * try to dial
     * */
    @FXML
    private void handleDial(){
        if(isFilled() && isSelected()){
            setUserInfo();
            setCMDInfo();
            runCmd.runRasdial();
            setConnectionInfo();
            showAwtNotification();
            systemTray.remove(trayIcon);
        }
    }

    /**
     * Initializes the controller class and all object needed.
     * This method is automatically called
     * after the fxml file has been loaded
     */
    @FXML
    private  void initialize(){
        user = new User();
        ISP = new ToggleGroup();
        CMC.setToggleGroup(ISP);
        CTC.setToggleGroup(ISP);
        CUC.setToggleGroup(ISP);

        initConfig();
        handleDial();
        loadUserInfo();
        showUserInfo();
    }
}
