package config;

import java.util.Properties;
import java.io.*;
import java.util.Scanner;

public class Config{
    private final String filePath = "src/config/config.properties";
    static Properties props = new Properties();

    //Load Properties
    public static void loadProps(){;}

    //Return user_name
    public static String returnUserName(){return "";}

    //Return PassWord
    public static String returnPassWord(){return "";}

    
}