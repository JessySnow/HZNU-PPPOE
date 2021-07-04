package config;
import java.io.*;
import java.util.*;



public class R_W {
    //Properties
    private static final String userdir = System.getProperty("user.dir");
    private static final String filePath = userdir + "\\config.properties";
    static Properties props = new Properties();



    public static void main(String[] args) {
        System.out.println(filePath);
    }
}
