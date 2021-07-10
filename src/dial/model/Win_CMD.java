package dial.model;

public class Win_CMD {
    protected User user;
    protected Status status;
    protected String CMD;

    /**
     * default constructor
     * */
    Win_CMD(){
        user = new User();
        status = new Status();
    }

    /**
     * @param user
     * */
    public Win_CMD(User user){
        this.user = user;
        this.status = new Status();
    }

    public User getUser() {
        return user;
    }

    public Status getStatus() {
        return status;
    }

    public String getCMD() {
        return CMD;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCMD(String CMD) {
        this.CMD = CMD;
    }

    public void runRasdial(){};
}
