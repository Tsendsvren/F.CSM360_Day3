public class ProductInfo {
    private String name;
    private double volume;
    private String note;

    // Constructor
    public ProductInfo(String name, double volume, String note) {
        this.name = name;
        this.volume = volume;
        this.note = note;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getVolume() {
        return volume;
    }

    public String getNote() {
        return note;
    }

    // Setter methods (хэрэв шаардлагатай бол)
    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
