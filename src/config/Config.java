package config;

import java.util.Properties;
import java.io.*;
import java.util.Scanner;

public class Config{
    //Basic variable
    private String UserName, PassWord, Configed;

    private final String filePath = "src/config/config.properties";
    static Properties props = new Properties();

    //Set UserName
    //Set PassWord
    //Set Configured

    //Load Properties
    public static void loadProps(){;}

    //Return UserName
    public static String returnUserName(){return "";}

    //Return PassWord
    public static String returnPassWord(){return "";}

    //Return Configed and Set Configed from "false" to "true"
    public static boolean returnConfiged(){return false;}

    //Show config Interface
    public static void ShowInterface(){
        System.out.println("######## Init #########");
        System.out.println("分行输入学号的密码");
    }

}