package softuni.bg.finalproject.models;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderType type;

    @Column(nullable = false)
    private int count;

    private double kilograms;

    private double width;

    private double height;

    private double depth;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    @Column(name = "sender_phone_number",nullable = false)
    private String senderPhoneNumber;

    @Column(name = "recipient_phone_number",nullable = false)
    private String recipientPhoneNumber;

    @Column(name = "take_order_from", nullable = false)
    private String takeOrderFrom;

    @Column(name = "take_order_to", nullable = false)
    private String takeOrderTo;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User userId;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getKilograms() {
        return kilograms;
    }

    public void setKilograms(double kilograms) {
        this.kilograms = kilograms;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

    public void setSenderPhoneNumber(String senderPhoneNumber) {
        this.senderPhoneNumber = senderPhoneNumber;
    }

    public String getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }

    public void setRecipientPhoneNumber(String recipientPhoneNumber) {
        this.recipientPhoneNumber = recipientPhoneNumber;
    }

    public String getTakeOrderFrom() {
        return takeOrderFrom;
    }

    public void setTakeOrderFrom(String takeOrderFrom) {
        this.takeOrderFrom = takeOrderFrom;
    }

    public String getTakeOrderTo() {
        return takeOrderTo;
    }

    public void setTakeOrderTo(String takeOrderTo) {
        this.takeOrderTo = takeOrderTo;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
