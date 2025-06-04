public class Introduction {
    public static void main(String[] args) {

        // Хэрэглэгч бүртгэх
        UserAccount user = new UserAccount("Bat", "99112233",
                new AddressInfo("Bat", "99112233", "3-r orts", "12 toot"));

        // Хүргэгч бүртгэх
        CourierAccount courier = new CourierAccount("Dorj", "88119900", "Hurdan");

        // Хүргэх барааны мэдээлэл
        ProductInfo product = new ProductInfo("Ugaalgiin mashin", 80.0, "Shilen hesgiig bolgoomjtoi");

        // Хүргэлтийн төлөв эхлүүлэх
        DeliveryStatus status = new DeliveryStatus("Huleen avsan");

        // Төлбөр тооцоолох
        PaymentInfo payment = new PaymentInfo(product.getVolume(), 12.5, "Hurdan");

        // Захиалга үүсгэх
        DeliveryOrder order = new DeliveryOrder(user, courier, product, status, payment);

        // Захиалгын мэдээлэл хэвлэх
        order.printSummary();
    }
}
