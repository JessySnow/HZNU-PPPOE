package dial.model;

import java.util.Properties;

public class ConfigFile {
    protected String userDir;
    protected String filePath;
    protected Properties props;

    public ConfigFile(){
        props = new Properties();
    }

    public String getUserName(){
        return props.getProperty("UserName");
    }
    public String getPassWord(){
        return props.getProperty("PassWord");
    }
    public String getConfigured(){return props.getProperty("Configured");}
    public int getType(){
        return Integer.parseInt(props.getProperty("type"));
    }
    public void loadProps(){}
    public void saveProps(){}
    public void setUserName(User user){}
    public void setPassword(User user){}
    public void setConfigured(User user){}
    public void setType(User user){}
}