package dial.model;

public class Status {
    private String statusInfo;
    public Status(){
        statusInfo = "发生了未知错误_-10";
    }
    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }
    public String getStatusInfo() {
        return statusInfo;
    }
}
