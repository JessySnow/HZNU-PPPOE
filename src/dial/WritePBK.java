package dial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/***
 * writing pppoe config to pbk file if exists
 * if not try to make one and writing to it
 */

public class WritePBK {
    //Move pbk to C
    private final static String windowsUser = System.getProperty("user.name");
    private final static String targetPath = "C:\\Users\\"+ windowsUser + "\\AppData\\Roaming\\Microsoft\\Network\\Connections\\Pbk\\rasphone.pbk";
    private final static String connectionName = "[PPPOE]";
    private final static String MEDIA = "MEDIA=rastapi";
    private final static String Port = "Port=PPPoE5-0";
    private final static String Device = "DEVICE=PPPoE";

    public static void writingPbk(){
        try{
            Files.write(Paths.get(targetPath), ("\n" + connectionName + "\n").getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(targetPath), (MEDIA + "\n").getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(targetPath), (Port + "\n").getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get(targetPath), (Device + "\n").getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}