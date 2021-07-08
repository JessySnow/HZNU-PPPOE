package Dial.Model;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty; import javafx.beans.property.IntegerProperty;

public class Error {
    private StringProperty errorInfo;
    private IntegerProperty errorCode;

    /**
     * @param errorCode
     */
    Error(int errorCode){
        this.errorCode = new SimpleIntegerProperty(errorCode);
        switch (errorCode){
            case(678):
                this.errorInfo = new SimpleStringProperty("错误678: 远程计算机无响应");
                break;
            case(691):
                this.errorInfo = new SimpleStringProperty("错误691: 用户名或者密码错误");
                break;
            case(718):
                this.errorInfo = new SimpleStringProperty("错误718: 远程计算机无响应");
                break;
            case(619):
                this.errorInfo = new SimpleStringProperty("错误619: 无法连接到指定服务器，用于此连接的端口已关闭，请检查网线接口");
                break;
            default:
                this.errorInfo = new SimpleStringProperty("未知错误");
        }
    }

    public int getErrorCode(){
        return this.errorCode.get();
    }

    public String getErrorInfo(){
        return this.errorInfo.get();
    }
}
