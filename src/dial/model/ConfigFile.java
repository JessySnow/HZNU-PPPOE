package dial.model;

import java.util.Properties;

public class ConfigFile {
    protected String userDir;
    protected String filePath;
    protected Properties props;

    /**
     * default constructor
     * call default constructor
     * */
    public ConfigFile(){
        props = new Properties();
    }

    public String getUserName(){
        return props.getProperty("UserName");
    }
    public String getPassWord(){
        return props.getProperty("PassWord");
    }
    public int getType(){
        return Integer.parseInt(props.getProperty("type"));
    }
    public String getConfigured(){return props.getProperty("Configured");}
    /**
     * load properties file from disk to memory(ram)
     * */
    public void loadProps(){}
    /**
     * write the change from memory to disk
     * */
    public void saveProps(){}

    /**
     * setUserName: write a new username to the props object
     * setPassWord: write a new password to the props object
     * setConfigured: Change value of configured from null to yes
     * getType: write a new type(0 - 2) to the props object
     * config_An_user: load all properties from disk and set user object's properties by these properties
     * */
    public void setUserName(User user){}
    public void setPassword(User user){}
    public void setConfigured(User user){}
    public void setType(User user){}
    public void config_An_User(User user){};
}