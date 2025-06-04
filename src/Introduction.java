public class Introduction {
    public static void main(String[] args) {

        // Хэрэглэгч бүртгэх
        UserAccount user = new UserAccount("Бат", "99112233",
                new AddressInfo("Бат", "99112233", "3-р орц", "12 тоот"));

        // Хүргэгч бүртгэх
        CourierAccount courier = new CourierAccount("Дорж", "88119900", "Хурдан");

        // Хүргэх барааны мэдээлэл
        ProductInfo product = new ProductInfo("Угаалгын машин", 80.0, "Шилэн хэсгийг болгоомжтой");

        // Хүргэлтийн төлөв эхлүүлэх
        DeliveryStatus status = new DeliveryStatus("Хүлээн авсан");

        // Төлбөр тооцоолох
        PaymentInfo payment = new PaymentInfo(product.getVolume(), 12.5, "Хурдан");

        // Захиалга үүсгэх
        DeliveryOrder order = new DeliveryOrder(user, courier, product, status, payment);

        // Захиалгын мэдээлэл хэвлэх
        order.printSummary();
    }
}