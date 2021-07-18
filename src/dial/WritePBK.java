package dial;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * only write 'PPPOE' to pbk file
     * if threr is no 'PPPOE' connection name on it
     */
    private static boolean scanPbk(){
        List<String> list = new ArrayList<String>();
        try{
            File file = new File(targetPath);
            InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(read);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                if(line.equals("[PPPOE]")){
                    return  true;
                }
            }

            bufferedReader.close();
            read.close();
        }catch (IOException e){
            System.exit(6);
        }
        return false;
    }

    /**
     * create a pbk file if there is no pbk file
     * in c
     */
    private static void createPbk(){
        File file = new File(targetPath);
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (Exception e){
                System.exit(5);
            }
        }
    }

    public static void writingPbk(){
        createPbk();
        if(!scanPbk()){
            try{
                Files.write(Paths.get(targetPath), ("\n" + connectionName + "\n").getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(targetPath), (MEDIA + "\n").getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(targetPath), (Port + "\n").getBytes(), StandardOpenOption.APPEND);
                Files.write(Paths.get(targetPath), (Device + "\n").getBytes(), StandardOpenOption.APPEND);
            }catch (IOException e){
                System.exit(4);
            }
        }
    }

    public static void main(String[] args) {
        writingPbk();
    }
}