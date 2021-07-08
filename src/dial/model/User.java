package dial.model;

public class User {
    private String passWord;
    private String userName;

    /**
     * default constructor
     * */
    User(){
        this.passWord = "000";
        this.userName = "000";
    }

    /**
     * @param userName
     * @param passWord
     * */
    User(String passWord, String userName){
        this.passWord = passWord;
        this.userName = userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }
}
