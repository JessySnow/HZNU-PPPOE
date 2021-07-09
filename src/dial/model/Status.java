package dial.model;

public class Status {
    private String statusInfo;

    /**
     * default constructor
     * */
    public Status(){
        statusInfo = "发生了未知错误_-1";
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public String getStatusInfo() {
        return statusInfo;
    }
}
