package dial;

import dial.model.ConfigFile;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConfigDial extends ConfigFile{
    ConfigDial(){
        userDir = System.getProperty("user.dir");
        filePath = userDir + "\\config.properties";
        props = new Properties();
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
    public void setUserName(){
        props.setProperty("UserName", user.getUserName());
    }
    @Override
    public void setPassword(){
        props.setProperty("PassWord", user.getPassWord());
    }
    @Override
    public void setConfigured(){
        props.setProperty("Configured", user.getConfigured());
    }
    @Override
    public void setType(){
        props.setProperty("type", String.valueOf(user.getType()));
    }
    @Override
    public void getRules(){
        switch (user.getType()){
            case(0):
                user.setRule(props.getProperty("CT"));
                break;
            case(1):
                user.setRule(props.getProperty("CM"));
                break;
            case(2):
                user.setRule(props.getProperty("CU"));
                break;
        }
    }
}
