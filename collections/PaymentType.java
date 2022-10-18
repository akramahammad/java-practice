package collections;

public enum PaymentType{
    DebitCard(10),CreditCard(5),Cash(15);

    int fee;
    PaymentType(int fee){
        System.out.println("Inside constructor");
        this.fee=fee;
    }

    public static void main(String[] args) {
        PaymentType pt=PaymentType.DebitCard;
        System.out.println(pt.fee);
        PaymentType[] paymentTypes=PaymentType.values();
        for(PaymentType type:paymentTypes){
            System.out.println(type.ordinal());
            System.out.println(type);
        }
    }
}
