package dial.model;

import java.util.Properties;

public class ConfigFile {
    protected User user;
    protected String userDir;
    protected String filePath;
    protected Properties props;

    /**
     * default constructor
     * */
    public ConfigFile(){}

    public Properties getProps() {
        return props;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getUserDir() {
        return userDir;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setUserDir(String userDir) {
        this.userDir = userDir;
    }

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
     * getRules: get a rules of encoding password from props object
     * */
    public void setUserName(){}
    public void setPassword(){}
    public void setConfigured(){}
    public void setType(){}
    public void getRules(){}
}