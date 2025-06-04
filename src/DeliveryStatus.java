public class DeliveryStatus {
    private String status;

    public DeliveryStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Төлөв: " + status;
    }
}
//