package dial.model;

public class Win_CMD {
    protected User user;
    protected Status status;
    public String CMD;

    public Win_CMD(User user){
        this.user = user;
        this.status = new Status();
    }

    public Status getStatus() {
        return status;
    }
    public void setUser(User user){this.user = user;}
    public void runRasdial(){}
}
