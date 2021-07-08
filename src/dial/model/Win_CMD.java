package dial.model;

import java.io.BufferedReader; import java.io.InputStreamReader;

public class Win_CMD {
    private User user;
    private Status status;
    private String CMD;

    /**
     * default constructor
     * */
    Win_CMD(){}

    /**
     * @param user
     * */
    Win_CMD(User user){
        this.user = user;
        CMD = String.format("rasdial PPPOE %s %s", user.getUserName(), user.getPassWord());
    }

    /**
     * try to connect, and get the info from console
     * call windows interface - rasdial
     * */
    public void Connect(){
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
            else status.setStatusInfo("拨号时发生未知错误_1");

        }catch (Exception e){
            status.setStatusInfo("拨号时发生未知错误_0");
        }
    }

    public User getUser() {
        return user;
    }

    public Status getStatus() {
        return status;
    }

    public String getCMD() {
        return CMD;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCMD(String CMD) {
        this.CMD = CMD;
    }

    /**
     * Test
     * */
    public static void main(String[] args) {}
}
