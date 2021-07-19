package dial;

import dial.model.ConfigFile;
import dial.model.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConfigDial extends ConfigFile{

    public ConfigDial(){
        super();
        userDir = System.getProperty("user.dir");
        filePath = userDir + "\\config.properties";
    }

    @Override
    public void loadProps(){
        try{
            FileInputStream propsIn = new FileInputStream(filePath);
            props.load(new java.io.FileInputStream(filePath));
            propsIn.close();
        }catch (IOException e){
            /* Do something here */
            System.exit(1);
        }
    }
    @Override
    public void saveProps(){
        try{
            FileOutputStream propsOut =  new FileOutputStream(filePath);
            props.store(propsOut, "NULL");
            propsOut.close();
        }catch (IOException e){
            /* Do something here */
            System.exit(1);
        }
    }
    @Override
    public void setUserName(User user){
        props.setProperty("UserName", user.getUserName());
    }
    @Override
    public void setPassword(User user){
        props.setProperty("PassWord", user.getPassWord());
    }
    @Override
    public void setConfigured(User user){
        props.setProperty("Configured", user.getConfigured());
    }
    @Override
    public void setType(User user){
        props.setProperty("type", String.valueOf(user.getType()));
    }
}
