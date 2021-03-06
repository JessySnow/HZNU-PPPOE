package dial;

import dial.model.User;
import dial.model.Win_CMD;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunCmd extends Win_CMD{

    public RunCmd(User user){
        super(user);
        switchType();
        CMD = (String.format("rasdial PPPOE %s%s %s", user.getUserName(), user.getRule(), user.getPassWord()));
    }

    private void switchType(){
        switch (user.getType()){
            case (0):
                user.setRule("@ctc");
                break;
            case (1):
                user.setRule("@cmcc");
                break;
            case(2):
                user.setRule("@cuc");
                break;
            default:
                user.setRule("@xxx");
        }
    }

    /**
     * load cmd from java-run-time
     * and call win rasdial api
     * to create a pppoe connection
     */
    @Override
    public void runRasdial(){
        switchType();
        CMD = (String.format("rasdial PPPOE %s%s %s", user.getUserName(), user.getRule(), user.getPassWord()));
        try {
            Process Windows_CMD = Runtime.getRuntime().exec("cmd /c " + CMD);
            String Line;
            StringBuilder cmdReturn = new StringBuilder();
            BufferedReader BR = new BufferedReader(new InputStreamReader(Windows_CMD.getInputStream(),
                    "GB2312"));
            while ((Line = BR.readLine()) != null)  cmdReturn.append(Line).append("\n");
            String result =  cmdReturn.toString();

            /* init the status by the error coed from console */
            if (result.indexOf("connected") > 0 || result.indexOf("已连接") > 0)    status.setStatusInfo("认证成功,已连接");
            else if (result.indexOf("678") > 0)    status.setStatusInfo("无法连接到认证服务器_678");
            else if (result.indexOf("691") > 0)    status.setStatusInfo("用户名或者密码错误,请检查_691");
            else if (result.indexOf("619") > 0)    status.setStatusInfo("连接端口未打开,请检查网卡或入户网线接口_619");
            else if (result.indexOf("718") > 0)    status.setStatusInfo("认证服务器响应超时,请稍后尝试重连_718");
            else if (result.indexOf("623") > 0)    status.setStatusInfo("未找到当前拨号连接的号码本入口_623");
            else if (result.indexOf("651") > 0)    status.setStatusInfo("网卡报错检查当前的连接环境_651");
            else {
                status.setStatusInfo("拨号时发生未知错误_1");
                System.out.println(result);
            }
        }catch (Exception e){
            status.setStatusInfo("拨号时发生未知错误_0");
        }
    }
}
