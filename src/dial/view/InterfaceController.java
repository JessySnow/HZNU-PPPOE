package dial.view;
import dial.ConfigDial;import dial.model.Connection;import javafx.application.Platform;import javafx.fxml.FXML;import dial.WritePBK;import javafx.scene.control.ToggleGroup;import dial.Main;import dial.model.User;import dial.RunCmd;import javafx.scene.control.Button;import javafx.scene.control.Label;import javafx.scene.control.TextField;import javafx.scene.control.RadioButton;import javafx.scene.image.ImageView;import javafx.scene.input.MouseEvent;import javafx.stage.Stage;import java.awt.TrayIcon;import java.awt.SystemTray;import java.awt.Toolkit;import java.awt.TrayIcon.MessageType;import java.awt.AWTException;import java.awt.Image;import java.util.Timer;
import java.util.TimerTask;

public class InterfaceController {
    @FXML
    protected Label HeaderLabel;
    @FXML
    protected ImageView Win_close;
    @FXML
    protected Button Login;
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
    private ImageView ZeroTwo;
    @FXML
    private ImageView STATUS;


    private Main main;
    private User user;
    private RunCmd runCmd;
    private ConfigDial configDial;
    private Connection connection;
    private Stage primaryStage = null;
    Thread cmdThread;
    private String connectionInfo = null;

    double x_offset = 0;
    double y_offset = 0;



    /**
     * default empty constructor
     * */
    public InterfaceController(){}
    private void Win_close_show(){
        javafx.scene.image.Image image = new javafx.scene.image.Image("file:resources\\images\\close-white.png");
        Win_close.setImage(image);
        Win_close.setCache(true);
    }
    @FXML
    private void Win_close_handler(){
        Platform.exit();
    }
    @FXML
    private void Win_close_hover_handler(){
        javafx.scene.image.Image image = new javafx.scene.image.Image("file:resources\\images\\close-red.png");
        Win_close.setImage(image);
    }
    @FXML
    private void Win_close_out_handler(){
        javafx.scene.image.Image image = new javafx.scene.image.Image("file:resources\\images\\close-white.png");
        Win_close.setImage(image);
        Win_close.setCache(true);
    }
    @FXML
    private void Win_close_press_handler(){
        javafx.scene.image.Image image = new javafx.scene.image.Image("file:resources\\images\\grey.png");
        Win_close.setImage(image);
        Win_close.setCache(true);
    }

    /**
     * drag the header label to move the entire windows
     * @param event: mouse event
     */
    @FXML
    private void Win_Drag_handler(MouseEvent event){
        if(this.primaryStage == null){
            this.primaryStage = main.getPrimaryStage();
        }
        event.consume();
        if(event.getEventType() == MouseEvent.MOUSE_PRESSED){
            x_offset = event.getSceneX();
            y_offset = event.getSceneY();
        }
        if(event.getEventType() == MouseEvent.MOUSE_DRAGGED){
            primaryStage.setX(event.getScreenX() - x_offset);
            if(event.getScreenX() - y_offset < 0){
                primaryStage.setY(0);
            }else{
                primaryStage.setY(event.getScreenY() - y_offset);
            }
        }
    }

    /**
     * create a new thread to execute rasdial command in cmd
     */
    private void runRasdial_thread(RunCmd runCmd, ConfigDial configDial){
        cmdThread = new runShellThread(runCmd, configDial, STATUS);
        cmdThread.start();
    }

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
    public void setMain(Main main){
        this.main = main;
    }
    private void showUserInfo(){
        if(user.getConfigured().equals("true")){
            this.userName.setText(user.getUserName());
            this.passWord.setText(user.getPassWord());
            switch (user.getType()){
                case 0:
                    this.CTC.setSelected(true);
                    break;
                case 1:
                    this.CMC.setSelected(true);
                    break;
                case 2:
                    this.CUC.setSelected(true);
                    break;
                default:
            }
        }
    }
    private void setUserInfo(){
        user.setUserName(userName.getText());
        user.setPassWord(passWord.getText());
        user.setType(getType());
        user.setConfigured("true");
    }
    private void Init_CMD(){
        runCmd = new RunCmd(user);
    }
    private void initConfig(){
        configDial = new ConfigDial();
        configDial.loadProps();
    }
    private void loadUserInfo(){
        user.setUserName(configDial.getUserName());
        user.setPassWord(configDial.getPassWord());
        user.setConfigured(configDial.getConfigured());
        user.setType(configDial.getType());
    }
    private void showMyWife(){
        try {
            javafx.scene.image.Image image = new javafx.scene.image.Image("file:resources\\images\\ZeroTwo.png");
            ZeroTwo.setImage(image);
            ZeroTwo.setCache(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void setCMDUser(){
        runCmd.setUser(user);
    }

    @FXML
    private void handleDial(){
        if(isFilled() && isSelected()){
            setUserInfo();
            configDial.setConfigured(user);
            configDial.setPassword(user);
            configDial.setType(user);
            configDial.setUserName(user);
            setCMDUser();
            runRasdial_thread(runCmd, configDial);
        }
    }

    /**
     * initializes the controller class and all object needed.
     * if there is no pbk file in c disk, then create one
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

        showMyWife();

        Win_close_show();
        handleDial();

        Init_CMD();
        initConfig();
        loadUserInfo();
        showUserInfo();

        WritePBK.writingPbk();
    }
}

/**
 * create a new thread to execute
 * a rasdial command and show notification
 * on it's main thread
 */
class runShellThread extends Thread{

    @FXML
    private ImageView STATUS;

    private int switchTag = 0;


    private String ERRO_ICON_PATH = "file:resources\\images\\icons8-error-cloud-48.png";
    private String FAIL_ICON_PATH = "file:resources\\images\\icons8-fail-cloud-48.png";
    private String CONN_ICON_PATH = "file:resources\\images\\icons8-cloud-connection-48.png";
    private String SUCC_ICON_PATH = "file:resources\\images\\icons8-cloud-checked-48.png";
    javafx.scene.image.Image errorImage = new javafx.scene.image.Image(ERRO_ICON_PATH);
    javafx.scene.image.Image conntingImage = new javafx.scene.image.Image(CONN_ICON_PATH);
    javafx.scene.image.Image failImage = new javafx.scene.image.Image(FAIL_ICON_PATH);
    javafx.scene.image.Image successImage = new javafx.scene.image.Image(SUCC_ICON_PATH);
    javafx.scene.image.Image targetImage;
    Timer statusTimer = new Timer();


    /**
     * show status of connection
     * this is a function called by timer
     */
    private void showStatus(){
        System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
//        if(this.connection.getStatus().getStatusInfo().equals("认证成功,已连接")){
//            targetImage = successImage;
//        }else if(this.connection.getStatus().getStatusInfo().equals("发生了未知错误_-10")){
//            targetImage = conntingImage;
//        }else if(this.connection.getStatus() == null){
//            targetImage = failImage;
//        }
//        if(switchTag++ % 2 == 0) {
//            targetImage = failImage;
//        }else {
//            targetImage = conntingImage;
//        }

        if(this.connection == null){
            targetImage = failImage;
        }else if (!this.connection.getStatus().getStatusInfo().equals("认证成功,已连接")){
            this.targetImage = errorImage;
        }else {
            this.targetImage = successImage;
        }


        System.out.println(targetImage);
        STATUS.setImage(targetImage);
        STATUS.setCache(true);
    }
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            showStatus();
        }
    };




    private final RunCmd runCmd;
    private Connection connection;
    private final ConfigDial configDial;

    SystemTray systemTray;
    TrayIcon trayIcon;

    public runShellThread(RunCmd runCmd, ConfigDial configDial, ImageView STATUS){
        this.runCmd = runCmd;
        this.configDial = configDial;
        this.STATUS = STATUS;
    }

    /**
     * show status of pppoe connection through
     * java awt notification
     */
    private void showAwtNotification(){
        systemTray = SystemTray.getSystemTray();
        try{
            Image notiImage = Toolkit.getDefaultToolkit().createImage("resources/images/ApplicationIcon.png");
            trayIcon = new TrayIcon(notiImage, "Status");
            trayIcon.setImageAutoSize(true);
            systemTray.add(trayIcon);
            if(connection.getStatus().getStatusInfo().equals("认证成功,已连接")){
                trayIcon.displayMessage("连接状态", connection.getStatus().getStatusInfo(), MessageType.INFO);
            }
            else{
                trayIcon.displayMessage("连接状态", connection.getStatus().getStatusInfo(), MessageType.WARNING);
            }
        }catch (AWTException e){
            System.exit(-2);
        }
    }

    private void setConnectionInfo(){
        connection = new Connection();
        connection.setStatus(runCmd.getStatus());

    }
    /**
     * wait console to return a dial result
     */
    @Override
    public void run() {
        statusTimer.scheduleAtFixedRate(task, 0, 1000);
        runCmd.runRasdial();
        setConnectionInfo();
        if(connection.getStatus().getStatusInfo().equals("认证成功,已连接")){
            configDial.saveProps();
        }
        showAwtNotification();
        systemTray.remove(trayIcon);
    }
}