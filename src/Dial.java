import config.Config;
import cmd.cmdExe;

import java.util.Scanner;

public class Dial {
    public static void main(String[] args) throws Exception{
        Scanner keyIn = new Scanner(System.in);
        String UserName, PassWord;
        int count = 0;
        boolean DailStatus;

        Config.loadProps();

        //If it's the first run, go to the init processor.
        if(!Config.returnConfiged())    Config.InitDial();

        /**
         * Try to Dialing, if success in doing so, save the pros into props file in disk,
         * otherwise keep trying to get a new password from console.
         * */
        UserName = Config.returnUserName();
        PassWord = Config.returnPassWord();
        do {
            count ++;
            //Get the result of dialing.
            DailStatus = cmdExe.executeCommand(UserName, PassWord);
            if(!DailStatus) {
                count ++;
                if(count <= 6){
                    System.out.println("拨号认证失败,请重新输入密码");
                    PassWord = keyIn.nextLine();
                }else{
                    System.out.println("认知失败次数过多,重新输入账号和密码.");
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