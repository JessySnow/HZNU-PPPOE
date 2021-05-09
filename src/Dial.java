import config.Config;
import CMD.cmdExe;

import java.util.Scanner;

public class Dial {
    public static void main(String[] args) throws Exception{
        Scanner keyIn = new Scanner(System.in);
        String UserName, PassWord;
        int count = 0;
        boolean DailStatus;

        Config.loadProps();

        if(!Config.returnConfiged())    Config.InitDial();
        UserName = Config.returnUserName();
        PassWord = Config.returnPassWord();

        do {
            count ++;
            DailStatus = cmdExe.executeCommand(UserName, PassWord);
            if(!DailStatus) {
                count ++;
                if(count <= 6){
                    System.out.println("密码有误,重新输入");
                    UserName = keyIn.nextLine();
                }else{
                    System.out.println("重连次数过多,重新输入账号和密码.");
                    UserName = keyIn.nextLine();
                    PassWord = keyIn.nextLine();
                    Config.setUserName();
                    count = 0;
                }
                Config.setPassWord();
            }
        }while (!DailStatus);

        Config.writeProps();
    }
}