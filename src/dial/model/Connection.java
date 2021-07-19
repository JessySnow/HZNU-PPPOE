package dial.model;

public class Connection {
    private Status status;

    public Connection(){
        status = new Status();
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public Status getStatus() {
        return status;
    }
}
