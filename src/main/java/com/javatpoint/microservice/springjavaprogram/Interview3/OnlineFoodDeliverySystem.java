package com.javatpoint.microservice.springjavaprogram.Interview3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

enum PizzaSize {
    REGULAR("Regular"),
    LARGE("Large"),
    FAMILY("Family"),
    MEDIUM("Medium");

    private final String value;

    PizzaSize(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}

enum OrderStatus {
    PLACED("Order Placed"),
    ACCEPTED("Order Accepted"),
    REJECTED("Order Rejected"),
    FOOD_PREPARING("Restraunt Preparing Your Food"),
    OUT_FOR_DELIVERY("Out for Delivery"),
    DELIVERED("Delivered");

    private final String value;

    OrderStatus(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}

enum PaymentStatus {
    NOT_INITIATED("Not Initiated"),
    PENDING("Payment Pending"),
    COMPLETED("Payment Received");

    private final String value;

    PaymentStatus(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}





public class OnlineFoodDeliverySystem {
    /*
    involved Entities
    User, - done
    FoodItem, - done
    Restraunt, - done
    Delivery, - done
    Payment, - done
    Order - done
     */
    public static void main(String args[]){
        System.out.println("Welcome to Vinod Food Delivery System!");
        UserService userService = new UserService();
        User user = userService.userService();
        RestrauntService restrauntService = new RestrauntService();
        Restraunt restraunt = restrauntService.restrauntService();
        OrderService orderService = new OrderService();
        Order order = orderService.orderService();;
        order.setUser(user);
        order.setRestraunt(restraunt);
        if(order.getOrderStatus().equalsIgnoreCase(OrderStatus.ACCEPTED.getValue())) {
            PaymentService paymentService = new PaymentService();
            Payment payment = paymentService.paymentService(order);
            Printingervice printingervice = new Printingervice();
            PrintOrderBill printOrderBill = printingervice.printOrderBillService(order);
            DelhiveryService delhiveryService = new DelhiveryService();
            Delivery delivery = delhiveryService.deliveryService(order);
        }else{
            System.out.println("Order is Rejected By Restraunt.");
        }
    }
}

// Delivery Service
class DelhiveryService {
     public Delivery deliveryService(Order order){
         // Delivery
         Delivery delivery = new BikeDelivery(order.getOrderId());
         order.setOrderStatus(OrderStatus.OUT_FOR_DELIVERY.getValue());
         delivery.deliver();

         //delivery = new DroneDelivery(order.getOrderId());
         //delivery.deliver();
         order.setOrderStatus(OrderStatus.DELIVERED.getValue());
         return delivery;
     }
}

// Printing Service
class Printingervice {
    public PrintOrderBill printOrderBillService(Order order){
        // Printing Service
        PrintOrderBill printOrderBill = new PrintOrderBill();
        printOrderBill.printBillDetails(order);
        return printOrderBill;
    }
}

// Restraunt
class RestrauntService {
    public Restraunt restrauntService(){
        FoodItem foodItem1 = new FoodItem("VEG Pizza",PizzaSize.REGULAR.getValue(),140.50);
        FoodItem foodItem2 = new FoodItem("VEG Pizza",PizzaSize.MEDIUM.getValue(),210.50);
        FoodItem foodItem3 = new FoodItem("VEG Pizza",PizzaSize.LARGE.getValue(),299.50);
        FoodItem foodItem4 = new FoodItem("Non VEG Pizza",PizzaSize.REGULAR.getValue(),150.50);
        FoodItem foodItem5 = new FoodItem("Non VEG Pizza",PizzaSize.MEDIUM.getValue(),220.50);
        FoodItem foodItem6 = new FoodItem("Non VEG Pizza",PizzaSize.LARGE.getValue(),310.50);
        FoodItem foodItem7 = new FoodItem("VEG Pizza",PizzaSize.FAMILY.getValue(),990.50);
        FoodItem foodItem8 = new FoodItem("Non VEG Pizza",PizzaSize.FAMILY.getValue(),1020.50);
        List<FoodItem> itemList = new ArrayList<>();
        itemList.add(foodItem1);
        itemList.add(foodItem2);
        itemList.add(foodItem3);
        itemList.add(foodItem4);
        itemList.add(foodItem5);
        itemList.add(foodItem6);
        itemList.add(foodItem7);
        itemList.add(foodItem8);
        Restraunt restraunt = new Restraunt();
        restraunt.setName("Dominos Pizaa");
        restraunt.setContact("9694998126");
        restraunt.setRating(4.5);
        restraunt.setMenu(itemList);
        restraunt.setLocation("IRIS Tech Park , Ground Floor, Badshahpur Sohna Road , Sector 48 , Gurgaon Hariyana, India");
        return restraunt;
    }
}

// Order Service
class OrderService {
    public Order orderService(){
        List<FoodItem> orderList = new ArrayList<>();
        FoodItem foodItem1 = new FoodItem("VEG Pizza",PizzaSize.REGULAR.getValue(),140.50);
        FoodItem foodItem2 = new FoodItem("VEG Pizza",PizzaSize.MEDIUM.getValue(),210.50);
        FoodItem foodItem3 = new FoodItem("VEG Pizza",PizzaSize.LARGE.getValue(),299.50);
        FoodItem foodItem4 = new FoodItem("Non VEG Pizza",PizzaSize.REGULAR.getValue(),150.50);
        FoodItem foodItem5 = new FoodItem("Non VEG Pizza",PizzaSize.MEDIUM.getValue(),220.50);
        FoodItem foodItem6 = new FoodItem("Non VEG Pizza",PizzaSize.LARGE.getValue(),310.50);
        FoodItem foodItem7 = new FoodItem("VEG Pizza",PizzaSize.FAMILY.getValue(),990.50);
        FoodItem foodItem8 = new FoodItem("Non VEG Pizza",PizzaSize.FAMILY.getValue(),1020.50);
        orderList.add(foodItem2);
        orderList.add(foodItem2);
        orderList.add(foodItem4);
        orderList.add(foodItem4);
        orderList.add(foodItem5);
        orderList.add(foodItem8);
        Order order = new Order();
        order.setOrderStatus(OrderStatus.PLACED.getValue());
        order.setOrderId("Order-123#");
        //order.setUser(user);
        //order.setRestraunt(restraunt);
        order.setOrderDetails(orderList);
        order.setOrderStatus(OrderStatus.ACCEPTED.getValue());
        BillCalculator billCalculator = new BillCalculator();
        order.setBill(billCalculator.calculteBill(order.getOrderDetails()));
        return order;
    }
}

// User Service
class UserService {
     public User userService(){
         List<String> location = new ArrayList<>();
         location.add("Room Number 404, Secure Stay Co Living Studio PG Apartment , Fazilpur Jharsa Sector 72 , Gurugram, Hariyana , India");
         location.add("Aashirwad Boys Hostel , Jwalapur Haridwar , Uttrakhand, India");
         location.add("Main Market Near Punjab National Bank, Jhulelal Mandir wali Gali , Bhootwada Mohalla VPO Ismailpur , Khairthal , Alwar , Rajasthan, India");
         location.add("Nannegari Harsha Pride, Madhapur , Hyderabad, Telangana India");
         User user = new User.Builder("Vinod-123","Vinod","Chandani")
                 .setEmailId("vinod3535chandani@gmail.com")
                 .setMobileNumber("9079292343")
                 .setSavedLocations(location)
                 .build();
         return user;
     }
}

// Payment Service
class PaymentService {
     public Payment paymentService(Order order){
         Payment payment = null;

             // Payment Processing
             payment = new CardPayment("5372-1651-8834");
             payment.processPayment(order.getOrderId(), order.getBill());
             order.setOrderStatus(OrderStatus.FOOD_PREPARING.getValue());
             payment = new UPIPayment("9694998126@ybl");
             payment.processPayment(order.getOrderId(), order.getBill());
         return payment;
     }
}

// Delivery Service
class DeliveryService {

}

// Bill Calculates
class BillCalculator {
    public BigDecimal calculteBill(List<FoodItem> orderList){
        Double bill = 0.0;
        for(FoodItem item : orderList){
            //System.out.println("Item : "+item.getItemName()+" , Size : "+item.getItemSize()+" , Price : "+item.getItemPrice());
            bill += item.getItemPrice();
        }
        //System.out.println("Total Bill : "+bill);
        return new BigDecimal(bill);
    }
}

// Print Bill
class PrintOrderBill {
    public void printBillDetails(Order order){
        Double bill = 0.0;

        System.out.println("Hello "+order.getUser().getFirstName()+"\n , Find Below Order details ");
        for(FoodItem item : order.getOrderDetails()){
            System.out.println("Item : "+item.getItemName()+" , Size : "+item.getItemSize()+" , Price : "+item.getItemPrice());
            bill += item.getItemPrice();
        }
        System.out.println("---------------------------");
        System.out.println("Total Bill : "+bill);
        System.out.println("Delivery Address : "+order.getUser().getSavedLocations().get(0));
        System.out.println("Thank you for Order Vinod Food Delivery Service , Hope we served you Better");
        System.out.println("Will Be Happy to Receive Feedback from you");
    }
}

// Payment Interface
interface Payment {
    public void processPayment(String orderId,BigDecimal amount);
}

// Card Payment
class CardPayment implements Payment {
    private String cardNumber;
    private String paymentStatus;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
        this.paymentStatus = PaymentStatus.NOT_INITIATED.getValue();
    }

    @Override
    public void processPayment(String orderId, BigDecimal amount) {
        this.paymentStatus = PaymentStatus.PENDING.getValue();
        System.out.println("Order Id : "+orderId+" , Payment of "+amount+" , Received via Card Number : "+cardNumber);
        this.paymentStatus = PaymentStatus.COMPLETED.getValue();
    }
}


// UPI
class UPIPayment implements Payment {
    private String upiId;
    private String paymentStatus;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
        this.paymentStatus = PaymentStatus.NOT_INITIATED.getValue();
    }

    @Override
    public void processPayment(String orderId, BigDecimal amount) {
        this.paymentStatus = PaymentStatus.PENDING.getValue();
        System.out.println("Order Id : "+orderId+" , Payment of "+amount+" , Received via UPI Id : "+upiId);
        this.paymentStatus = PaymentStatus.COMPLETED.getValue();
    }
}

// Drone Delivery
class DroneDelivery implements Delivery {
    private String orderId;

    public DroneDelivery(String orderId) {
        this.orderId = orderId;
    }

    public void deliver() {
        System.out.println("Order Id : "+orderId+" is Delivered with Drone");
    }
}

// Bike Delivery
class BikeDelivery implements Delivery {
    private String orderId;

    public BikeDelivery(String orderId) {
        this.orderId = orderId;
    }

    public void deliver() {
        System.out.println("Order Id : "+orderId+" is Delivered with Bike");
    }
}

// Delivery Entity
interface Delivery {
    public void deliver();
}


// Order Entity
class Order {
    private String orderId;
    private Restraunt restraunt;
    private List<FoodItem> orderDetails;
    private User user;
    private String feedback;
    private BigDecimal bill;
    private Double orderRating;
    private String orderStatus;
    public Double getOrderRating() {
        return orderRating;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderRating(Double orderRating) {
        this.orderRating = orderRating;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Restraunt getRestraunt() {
        return restraunt;
    }

    public void setRestraunt(Restraunt restraunt) {
        this.restraunt = restraunt;
    }

    public List<FoodItem> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<FoodItem> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public BigDecimal getBill() {
        return bill;
    }

    public void setBill(BigDecimal bill) {
        this.bill = bill;
    }
}


// Restraunt
class Restraunt {
    private String name;
    private String location;
    private List<FoodItem> menu;
    private String contact;
    private Double rating;

    public List<FoodItem> getMenu() {
        return menu;
    }

    public void setMenu(List<FoodItem> menu) {
        this.menu = menu;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

// Food Items
class FoodItem {
    private String itemName;
    private String itemSize;
    private Double itemPrice;

    public FoodItem(String itemName, String itemSize, Double itemPrice) {
        this.itemName = itemName;
        this.itemSize = itemSize;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }
}

// User Entity
class User {
    private String userId;
    private String firstName;
    private String lastName;
    private List<String> savedLocations;
    private String mobileNumber;
    private String emailId;

    private User(Builder builder){
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.savedLocations = builder.savedLocations;
        this.mobileNumber = builder.mobileNumber;
        this.emailId = builder.emailId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getSavedLocations() {
        return savedLocations;
    }

    public void setSavedLocations(List<String> savedLocations) {
        this.savedLocations = savedLocations;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public static class Builder {
        private String userId;
        private String firstName;
        private String lastName;
        private List<String> savedLocations;
        private String mobileNumber;
        private String emailId;

        public Builder(String userId,String firstName,String lastName){
            this.userId = userId;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder setMobileNumber(String mobileNumber){
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder setEmailId(String emailId){
            this.emailId = emailId;
            return this;
        }

        public Builder setSavedLocations(List<String> locations){
            this.savedLocations = locations;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
