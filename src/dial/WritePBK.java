package dial;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
    private final static String sourcePath = "resources\\rasphone-limit.pbk";

    /**
     * only write 'PPPOE' to pbk file
     * if there is no 'PPPOE' connection name on it
     */
    private static boolean scanPbk(){
        try{
            File file = new File(targetPath);
            InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(read);
            String line;
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
            }catch (IOException e){
                System.exit(5);
            }
        }
    }

    /**
     * copy from resource/rasphone-limit.pbk
     */
    public static void writingPbk(){
        createPbk();
        if(!scanPbk()){
            try{
                File file = new File(sourcePath);
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    Files.write(Paths.get(targetPath), (line + '\n').getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
                }
                bufferedReader.close();
                read.close();
            }catch (IOException e){
                System.exit(4);
            }
        }
    }
}