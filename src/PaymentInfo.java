public class PaymentInfo {
    private double volume;      
    private double distance;     
    private String mode;         
    private double previousTotal;
    private double calculatedTotal;

    public PaymentInfo(double volume, double distance, String mode) {
        this.volume = volume;
        this.distance = distance;
        this.mode = mode;
        this.previousTotal = 0.0;
        this.calculatedTotal = calculateTotal();
    }

    private double calculateTotal() {
        double baseRate = 500.0;
        double volumeFee = volume * 200;
        double distanceFee = distance * 100;
        double modeMultiplier = mode.equalsIgnoreCase("express") ? 1.5 : 1.0;
        return (baseRate + volumeFee + distanceFee) * modeMultiplier;
    }

    public double getPreviousTotal() {
        return previousTotal;
    }

    public double getCalculatedTotal() {
        return calculatedTotal;
    }

    public void updatePreviousTotal() {
        this.previousTotal = this.calculatedTotal;
    }

    @Override
    public String toString() {
        return "Нийт төлбөр: " + calculatedTotal + " төгрөг (" + mode + " горим)";
    }
}
