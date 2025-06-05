import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            boolean restart = startOrderProcess(scanner);
            if (!restart) {
                System.out.println("Программыг дуусгаж байна...");
                break;
            }
        }
    }

    public static boolean startOrderProcess(Scanner scanner) {
        System.out.println("Хэрэглэгчийн мэдээлэл оруулна уу:");
        System.out.print("Овог, нэр: ");
        String fullName = scanner.nextLine();
        System.out.print("Утас: ");
        String phone = scanner.nextLine();
        System.out.print("Имэйл: ");
        String email = scanner.nextLine();
        Customer customer = new Customer(fullName, phone, email);

        System.out.println("\nБарааны мэдээлэл оруулна уу:");
        System.out.print("Барааны нэр: ");
        String itemName = scanner.nextLine();
        System.out.print("Хэмжээ (м3): ");
        double volume = Double.parseDouble(scanner.nextLine());
        System.out.print("Жин (кг): ");
        double weight = Double.parseDouble(scanner.nextLine());
        System.out.print("Хүргэлтийн зай (км): ");
        double distance = Double.parseDouble(scanner.nextLine());
        System.out.print("Барааны анхааруулга: ");
        String warning = scanner.nextLine();
        Item item = new Item(itemName, volume, weight, distance, warning);

        System.out.println("\nБараа хүлээн авах газрын мэдээлэл оруулна уу:");
        System.out.print("Хаяг: ");
        String address = scanner.nextLine();
        System.out.print("Орц: ");
        String entrance = scanner.nextLine();
        System.out.print("Тоот: ");
        String apartment = scanner.nextLine();
        System.out.print("Бараа явуулагчийн нэр: ");
        String senderName = scanner.nextLine();
        System.out.print("Бараа явуулагчийн утас: ");
        String senderPhone = scanner.nextLine();
        System.out.print("Бараа явуулагчийн имэйл: ");
        String senderEmail = scanner.nextLine();
        System.out.print("Бараа хүлээн авагчийн нэр: ");
        String receiverName = scanner.nextLine();
        System.out.print("Бараа хүлээн авагчийн утас: ");
        String receiverPhone = scanner.nextLine();
        System.out.print("Бараа хүлээн авагчийн имэйл: ");
        String receiverEmail = scanner.nextLine();

        LocationInfo location = new LocationInfo(address, entrance, apartment,
                senderName, senderPhone, senderEmail,
                receiverName, receiverPhone, receiverEmail);

        System.out.println("\nХүргэлтийн төрлийг сонгоно уу:");
        System.out.println("1 - Стандарт (5000₮)");
        System.out.println("2 - Хурдан (15000₮)");
        DeliveryType deliveryType = null;
        while (deliveryType == null) {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1)
                deliveryType = DeliveryType.STANDARD;
            else if (choice == 2)
                deliveryType = DeliveryType.EXPRESS;
            else
                System.out.println("Зөв сонголт хийнэ үү.");
        }

        System.out.println("\nТээврийн хэрэгсэл сонгоно уу:");
        for (VehicleType vt : VehicleType.values()) {
            System.out.println((vt.ordinal() + 1) + " - " + vt.toString() + " (" + vt.getPrice() + "₮)");
        }
        VehicleType vehicleType = null;
        while (vehicleType == null) {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice > 0 && choice <= VehicleType.values().length) {
                vehicleType = VehicleType.values()[choice - 1];
            } else {
                System.out.println("Зөв сонголт хийнэ үү.");
            }
        }

        Delivery delivery = new Delivery(deliveryType, vehicleType);

        System.out.println("\nХүргэлийн ажилтан:");
        System.out.println("Нэр: " + delivery.getDeliveryWorkerName());
        System.out.println("Утас: " + delivery.getDeliveryWorkerPhone());
        System.out.println("Имэйл: " + delivery.getDeliveryWorkerEmail());

        Payment payment = new Payment(item, delivery, customer, location);
        payment.printInvoice();

        System.out.println("\nТөлбөрийн төлөх хуваарийг сонгоно уу:");
        System.out.println("1 - Эхлээд төлөх");
        System.out.println("2 - Хүлээн авагч төлөх");
        PaymentPayer payer = null;
        while (payer == null) {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1)
                payer = PaymentPayer.SENDER;
            else if (choice == 2)
                payer = PaymentPayer.RECEIVER;
            else
                System.out.println("Зөв сонголт хийнэ үү.");
        }

        final PaymentPayer paymentPayer = payer;

        if (paymentPayer == PaymentPayer.SENDER) {
            System.out.println("Төлсөн үү? (тийм/үгүй)");
            String paidAnswer = scanner.nextLine().toLowerCase();
            if (!paidAnswer.equals("тийм")) {
                System.out.println("Хүргэлт цуцлагдлаа.");
                return askRetry(scanner);
            } else {
                System.out.println("Хүргэлтийн захиалга хийгдлээ, та түр хүлээнэ үү...");
                delivery.setStatus(DeliveryStatus.ORDER_PLACED);
            }
        } else {
            System.out.println("Хүргэлтийн захиалга хийгдлээ, та түр хүлээнэ үү...");
            delivery.setStatus(DeliveryStatus.ORDER_PLACED);
        }

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                delivery.setStatus(DeliveryStatus.OUT_FOR_DELIVERY);
                System.out.println("\nХүргэлтэнд гарлаа...");
            }
        }, 5000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (paymentPayer == PaymentPayer.RECEIVER) {
                    while (true) {
                        System.out.println("\nБараа хүргэгдлээ, төлбөрөө төлнө үү? (тийм/үгүй)");
                        String receiverPaid = scanner.nextLine().toLowerCase();
                        if (receiverPaid.equals("тийм")) {
                            delivery.setStatus(DeliveryStatus.DELIVERED);
                            System.out.println("Бараа хүргэгдлээ. Манайхаар дахин үйлчлүүлээрэй.");
                            timer.cancel();
                            System.exit(0);
                        } else {
                            System.out.println("Төлбөрөө төлж барааг хүлээн авна уу?");
                        }
                    }
                } else {
                    delivery.setStatus(DeliveryStatus.DELIVERED);
                    System.out.println("\nБараа хүргэгдлээ. Манайхаар дахин үйлчлүүлээрэй.");
                    timer.cancel();
                    System.exit(0);
                }
            }
        }, 10000);

        return false;
    }

    public static boolean askRetry(Scanner scanner) {
        while (true) {
            System.out.println("Дахин захиалах уу? (тийм/үгүй)");
            String answer = scanner.nextLine().toLowerCase();
            if (answer.equals("тийм"))
                return true;
            else if (answer.equals("үгүй"))
                return false;
            else
                System.out.println("Зөв хариулт өгнө үү.");
        }
    }
}
