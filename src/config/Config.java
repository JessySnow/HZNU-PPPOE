package config;

import java.io.*;
import java.util.*;

public class Config{
    //Basic variable
    private static String UserName, PassWord, Configed;
    private static final Scanner keyIn = new Scanner(System.in);

    //Properties
    private static final String filePath = "config.properties";
    static Properties props = new Properties();

    //Write Properties
    public static void writeProps() throws Exception{;}
    //Load Properties
    public static void loadProps() throws Exception{
        InputStream propsIn = Config.class.getResourceAsStream(filePath);
        props.load(propsIn);
        propsIn.close();
    }

    //Set UserName
    public static void setUserName() {props.setProperty("UserName", UserName);}
    //Set PassWord
    public static void setPassWord() {props.setProperty("PassWord", PassWord);}
    //Set Configured
    public static void setConfiged() {props.setProperty("Configured", Configed);}
    //Return UserName
    public static String returnUserName(){return props.getProperty("UserName");}
    //Return PassWord
    public static String returnPassWord(){return props.getProperty("PassWord");}
    //Return Configed and Set Configed from "false" to "true"
    public static boolean returnConfiged(){ return props.getProperty("Configured").equals("true"); }

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

    public static void main(String[] args) throws Exception{
        
    }

}