package config;

import java.util.Properties;
import java.io.*;
import java.util.Scanner;

public class Config{
    //Basic variable
    private static String UserName, PassWord, Configed;
    private static Scanner keyIn = new Scanner(System.in);

    //Properties
    private static final String filePath = "src\\config\\config.properties";
    static Properties props = new Properties();


    //Load Properties
    public static void loadProps() throws Exception{
        FileInputStream propsIn = new FileInputStream(filePath);
        props.load(propsIn);
        propsIn.close();
    }

    //Write Properties
    public static void writeProps() throws Exception{
        FileOutputStream propsOut = new FileOutputStream(filePath);
        props.store(propsOut,"Init or Change");
    }

    //Set UserName
    public static void setUserName() {props.setProperty("UserName", UserName);}
    //Set PassWord
    public static void setPassWord() {props.getProperty("PassWord", PassWord);}
    //Set Configured
    public static void setConfiged() {props.getProperty("Configured", Configed);}
    //Return UserName
    public static String returnUserName(){return props.getProperty("UserName");}
    //Return PassWord
    public static String returnPassWord(){return props.getProperty("PassWord");}
    //Return Configed and Set Configed from "false" to "true"
    public static boolean returnConfiged(){
        if(props.getProperty("Configured").equals("true"))  return true;
        else{
            props.setProperty("Configured", "true");
            return false;
        }
    }

    //Show config Interface and Init Dial
    public static void InitDial() throws Exception{
        System.out.println("######## Init #########");
        System.out.println("分行输入学号的密码");
        UserName = keyIn.nextLine();
        PassWord =  keyIn.nextLine();
        loadProps();
        setPassWord();
        setUserName();
        writeProps();
    }

    //Test
    public static void main(String[] args) throws Exception{
        InitDial();
    }
}