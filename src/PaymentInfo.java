public class PaymentInfo {
    private double volume;      // Овор хэмжээ (жишээ нь, м3)
    private double distance;    // Зай (жишээ нь, км)
    private String mode;        // Горим: "Хурдан", "Тайван"
    private double cost;        // Төлбөр

    public PaymentInfo(double volume, double distance, String mode) {
        this.volume = volume;
        this.distance = distance;
        this.mode = mode;
        this.cost = calculateCost();
    }

    private double calculateCost() {
        double baseRate = mode.equalsIgnoreCase("Хурдан") ? 1500 : 1000;
        return volume * 500 + distance * baseRate;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Төлбөр: " + cost + "₮ (Горим: " + mode + ")";
    }
}
