package Dial.Model;
import javafx.beans.property.SimpleStringProperty; import javafx.beans.property.StringProperty;

/**
 * Model of PPPOE connection
 * */
public class Connection {
    private StringProperty userName;
    private StringProperty passWord;
    private Error error;

    /**
     * @param userName
     * @param passWord
     */
    public Connection(String userName, String passWord){
        this.userName = new SimpleStringProperty(userName);
        this.passWord = new SimpleStringProperty(passWord);
        this.error = null;
    }

    public String getUserName(){
        return userName.get();
    }

    public String getPassWord(){
        return passWord.get();
    }

    public String getErrorInfo(){return null;}

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public void setPassWord(String passWord){
        this.passWord.set(passWord);
    }

    public void setError(Error error){
        this.error = error;
    }
}
