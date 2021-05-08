import config.Config;
import CMD.cmdExe;

import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.util.Scanner;

public class Dial {
    public static void main(String[] args) throws Exception{
        Scanner keyIn = new Scanner(System.in);
        String UserName, PassWord, Configed, command;
        boolean DailStatus = false;
        command = "rasdial PPPOE";

        Config.loadProps();
            if(!Config.returnConfiged())    Config.InitDial();
            UserName = Config.returnUserName();
            PassWord = Config.returnPassWord();
            do {
                DailStatus = cmdExe.executeCommand(command, UserName, PassWord);
                if(!DailStatus) {
                    System.out.println("密码有误,重新输入");
                    UserName = keyIn.nextLine();
                }
            }while (!DailStatus);
        Config.writeProps();
    }
}