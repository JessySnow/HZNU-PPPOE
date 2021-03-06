package dial.model;

public class User {
    private String passWord;
    private String userName;
    private int type;
    private String rule;
    private String configured;

    public User(){
        this.passWord = "000";
        this.userName = "000";
        this.rule = "@ctc";
        this.configured = "false";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public void setRule(String rule) {
        this.rule = rule;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getPassWord() {
        return passWord;
    }
    public String getUserName() {
        return userName;
    }
    public int getType() {
        return type;
    }
    public String getRule() {
        return rule;
    }
    public String getConfigured() {
        return configured;
    }
    public void setConfigured(String configured) {
        this.configured = configured;
    }
}
