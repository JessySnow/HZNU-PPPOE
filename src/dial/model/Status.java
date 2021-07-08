package dial.model;

public class Status {
    private String statusInfo;

    /**
     * default constructor
     * */
    Status(){
        statusInfo = "发生了未知错误";
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public String getStatusInfo() {
        return statusInfo;
    }
}
