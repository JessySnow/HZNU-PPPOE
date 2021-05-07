import config.Config;
import CMD.cmdExe;

import java.util.Scanner;

//Test
import java.io.*;



public class Dial {
    public static void main(String[] args) throws Exception{
        Scanner keyIn = new Scanner(System.in);
        String Command = "rasdial PPPOE ";
        String UserName, PassWord, BLANK;
        if(!Config.returnConfiged()){
            Config.ShowInterface();
            UserName = keyIn.nextLine();
            PassWord = keyIn.nextLine();
        }
    }
}