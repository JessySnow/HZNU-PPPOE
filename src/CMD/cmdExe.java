package CMD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class cmdExe {
    /*
    * function: Open a new processor to execute the command from Dial
    * command: Command(String) from Dial
    * */
    public static String executeCommand(String command) throws Exception{
        Process Windows_CMD = Runtime.getRuntime().exec("cmd /c " + command);
        System.out.println("Loaded Windows_CMD......");

        //Get the output from CMD and feed it to this processor as input stream
        String Line;
        StringBuilder CMD_RETURN = new StringBuilder();
        BufferedReader BR = new BufferedReader(new InputStreamReader(Windows_CMD.getInputStream(), StandardCharsets.UTF_8));
        while ((Line = BR.readLine()) != null)  CMD_RETURN.append(Line).append("\n");
        return CMD_RETURN.toString();
    }

    public static void main(String[] args) throws Exception {
        String ret = cmdExe.executeCommand("rasdial PPPOE 2019212212237@ctc 12345");
        System.out.println(ret);
    }
}