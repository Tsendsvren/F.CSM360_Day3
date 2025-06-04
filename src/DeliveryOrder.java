public class DeliveryOrder {
    private UserAccount user;
    private CourierAccount courier;
    private ProductInfo product;
    private DeliveryStatus status;
    private PaymentInfo payment;

    public DeliveryOrder(UserAccount user, CourierAccount courier, ProductInfo product,
                         DeliveryStatus status, PaymentInfo payment) {
        this.user = user;
        this.courier = courier;
        this.product = product;
        this.status = status;
        this.payment = payment;
    }

    public void printSummary() {
        System.out.println("----- Hurgeltiin zahialgiin delgerengui -----");
        System.out.println("Zahialagch: " + user.getName() + ", Utas: " + user.getPhone());
        System.out.println("Pickup hayg: " + user.getAddress().getFullAddress());

        System.out.println("Hurgegch: " + courier.getName() + ", Phone" + courier.getPhone()
                + ", Gorim " + courier.getMode());

        System.out.println("Baraa: " + product.getName() + ", Hemjee: " + product.getVolume() +
                ", Warning: " + product.getNote());

        System.out.println("Tolov: " + status.getStatus());
        System.out.println("Tolbor: " + payment.getCalculatedAmount() + "MNT");
        System.out.println("--------------------------------------------");
    }

    // Getter/setter хэрэгтэй бол эндээс эхэлж нэмж болно.
}
