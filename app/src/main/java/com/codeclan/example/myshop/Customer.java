package com.codeclan.example.myshop;
import java.util.ArrayList;

/**
 * Created by user on 24/02/2017.
 */

public class Customer {

    Payment tempPayment;

ArrayList<Payment> paymentMethods;
Class preferredPayment;




    public Customer() {
    this.paymentMethods = new ArrayList<Payment>();
    this.preferredPayment = CreditCard.class;
    }


public void addPaymentMethod(Payment paymentName) {
    this.paymentMethods.add(paymentName);
}


    public ArrayList<Payment> getPaymentMethods() {
        return paymentMethods;
    }

    public Class getPreferredPayment() {
        return preferredPayment;
    }

    public void setPreferredPayment(Class preferredPayment) {
        this.preferredPayment = preferredPayment;
    }


    public boolean pay(int value) {
        for (Payment paymeth : paymentMethods) {
             if (paymeth.getClass() == this.preferredPayment) {
                if (paymeth.paymentPossible(value)) {
                    paymeth.payCard(value);
                    return true;
                }
return false;
             }


        }

return false;
    }


    public void refund(int value) {
        for (Payment paymeth : paymentMethods) {
            if (paymeth.getClass() == this.preferredPayment) {
                    paymeth.payCard(value);
            }
        }



    }

}
