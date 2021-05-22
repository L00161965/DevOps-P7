package revolut;

public class PaymentService {
    private String serviceName;
    private boolean requestAccepted;

    public PaymentService(String name){
        this.serviceName = name;
    }

    public String getType() {
        return serviceName;
    }


    public boolean requestTopUp() {
        return this.requestAccepted;

    }

    public void setRequestResult(boolean result) {
         this.requestAccepted =result;

    }
}
