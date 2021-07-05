import java.io.File;

public class DialTest {
    public static void main(String[] args) {
        //Move pbk to user's pbk flooder
        String windowsUser = System.getProperty("user.name");
        String targetPath = "C:\\Users\\"+ windowsUser + "\\AppData\\Roaming\\Microsoft\\Network\\Connections\\Pbk\\rasphone.pbk";
        String sourcePath = System.getProperty("user.dir") + "\\rasphone.pbk";
        File source = new File(sourcePath);
        File target = new File(targetPath);

        try{
            source.renameTo(target);
        }catch (Exception e){
            System.out.println("移动失败");
        }
    }
}