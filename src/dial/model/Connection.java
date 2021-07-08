package dial.model;

public class Connection {
    private User user;
    private Win_CMD cmd;
    private Status status;

    public void setCmd(Win_CMD cmd) {
        this.cmd = cmd;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public Win_CMD getCmd() {
        return cmd;
    }
}
