package dial.model;

import java.io.IOException;
import java.util.Properties;

public class ConfigFile {
    private String userDir;
    private String filePath;
    private Properties props = new Properties();

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
     * getRules: get a rules of encoding password from props object
     * */
    public void setUserName(String userName){}
    public void setPassword(String password){}
    public void getRules(int type){}
}