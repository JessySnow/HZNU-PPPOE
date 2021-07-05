package config;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Properties;

public class Config{
    private static String UserName, PassWord, Configed;
    private static final Scanner keyIn = new Scanner(System.in);

    private static final String userdir = System.getProperty("user.dir");
    private static final String filePath = userdir + "\\config.properties";
    public static Properties props = new Properties();

    public static void writeProps() throws Exception{
        FileOutputStream propsOut =  new FileOutputStream(filePath);
        props.store(propsOut, "NULL");
        propsOut.close();
    }
    //Load Properties
    public static void loadProps(){
        try{
            FileInputStream propsIn = new FileInputStream(filePath);
            props.load(new java.io.FileInputStream(filePath));
            propsIn.close();
        }catch (Exception e){
            System.out.println("### 配置文件丢失或打开错误，请检查配置文件是否位于当前的运行目录,或配置文件的读写权限\n\n");
            System.out.println("### 输入回车退出");
            String _ = keyIn.nextLine();
            System.exit(1);
        }
    }

    //Set UserName
    public static void setUserName(){
        props.setProperty("UserName", UserName);
    }
    //Set PassWord
    public static void setPassWord(){
        props.setProperty("PassWord", PassWord);
    }
    //Set Configured
    public static void setConfiged(){
        props.setProperty("Configured", Configed);
    }
    //Return UserName
    public static String returnUserName(){
        return props.getProperty("UserName");
    }
    //Return PassWord
    public static String returnPassWord(){
        return props.getProperty("PassWord");
    }
    //Return Configed and Set Configed from "false" to "true"
    public static boolean returnConfiged(){
        return props.getProperty("Configured").equals("true");
    }

    //Show config Interface and Init Dial
    public static void InitDial(){
        System.out.println("######## Init #########");
        System.out.println("# 分行输入学号的密码");
        UserName = keyIn.nextLine();
        PassWord =  keyIn.nextLine();
        System.out.println("# 输入运营商");
        System.out.println("# 1.中国电信");
        System.out.println("# 2.中国移动\n");
        Configed = "true";

        int ISP = keyIn.nextInt();
        if(ISP == 1)    UserName += props.getProperty("CT");
        else if(ISP == 2)   UserName += props.getProperty("CM");

        setPassWord();
        setUserName();
        setConfiged();
    }
}