package dial.model;

import java.io.IOException;
import java.util.Properties;
import java.io.FileOutputStream;
import java.io.FileInputStream;

public class ConfigFile {
    private final String userDir = System.getProperty("user.dir");
    private final String filePath = userDir + "\\config.properties";
    private Properties props = new Properties();

    /**
     * default constructor
     * */
    ConfigFile(){}


    public void initProps(){
        try{
            FileInputStream propsIn = new FileInputStream(filePath);
            props.load(new java.io.FileInputStream(filePath));
            propsIn.close();
        }catch (IOException e){
            System.exit(1);
        }
    }

    public Properties getProps() {
        return props;
    }
}