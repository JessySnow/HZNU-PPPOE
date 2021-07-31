package dial.model;

public class Connection {
    private Status status;
    private String statusInfo;

    public Connection(){
        status = new Status();
        statusInfo = "发生了未知错误_-10";
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public Status getStatus() {
        return status;
    }
}