package dial;

import dial.model.User;
import dial.model.Win_CMD;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunCmd extends Win_CMD{
    public RunCmd(User user){
        super(user);
        user.setRule("@ctc");
        CMD = (String.format("rasdial PPPOE %s%s %s", user.getUserName(), user.getRule(), user.getPassWord()));
    }

    @Override
    public void runRasdial(){
        try {
            Process Windows_CMD = Runtime.getRuntime().exec("cmd /c " + CMD);
            String Line;
            StringBuilder cmdReturn = new StringBuilder();
            BufferedReader BR = new BufferedReader(new InputStreamReader(Windows_CMD.getInputStream(),
                    "GB2312"));
            while ((Line = BR.readLine()) != null)  cmdReturn.append(Line).append("\n");
            String result =  cmdReturn.toString();

            if (result.indexOf("Connected") > 0 || result.indexOf("已连接") > 0)    status.setStatusInfo("认证成功,已连接");
            else if (result.indexOf("678") > 0)    status.setStatusInfo("无法连接到认证服务器");
            else if (result.indexOf("691") > 0)    status.setStatusInfo("用户名或者密码错误,请检查");
            else if (result.indexOf("619") > 0)    status.setStatusInfo("连接端口未打开,请检查网卡或入户网线接口");
            else if (result.indexOf("718") > 0)    status.setStatusInfo("认证服务器响应超时,请稍后尝试重连");
            else if (result.indexOf("623") > 0)    status.setStatusInfo("未找到当前拨号连接的号码本入口");
            else status.setStatusInfo("拨号时发生未知错误_1");

        }catch (Exception e){
            status.setStatusInfo("拨号时发生未知错误_0");
        }
    }
}
