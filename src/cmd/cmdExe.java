package cmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class cmdExe {
    public static boolean executeCommand(String UserName, String PassWord) throws Exception{
        String userDir = System.getProperty("user.dir") + "\\rasphone.pbk";
        String command = "rasdial PPPOE";
        String Command = command + " " + UserName + " " + PassWord;

        //Set the path of using phonebook
//        Command += " /phonebook:" + userDir;

        Process Windows_CMD = Runtime.getRuntime().exec("cmd /c " + Command);
        System.out.println("## Dialling ...... ## \n\n");

        //Get the output from CMD and feed it to this processor as input stream
        String Line;
        StringBuilder CMD_RETURN = new StringBuilder();
        BufferedReader BR = new BufferedReader(new InputStreamReader(Windows_CMD.getInputStream(), "GB2312"));
        while ((Line = BR.readLine()) != null)  CMD_RETURN.append(Line).append("\n");

        //Determine if connected.
        String TEMP =  CMD_RETURN.toString();
        return (TEMP.indexOf("已连接") > 0 || TEMP.indexOf("Connected") > 0);
    }

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir") + "\\rasphone.pbk";
        System.out.println(userDir);
    }
}