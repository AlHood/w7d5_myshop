package com.codeclan.example.myshop;
import java.util.ArrayList;

import static com.codeclan.example.myshop.TransactionType.REFUND;
import static com.codeclan.example.myshop.TransactionType.SALE;


public class Shop {

    Transaction tempTrans;
    ArrayList<Transaction> sales;
    ArrayList<Transaction> refunds;
    int refundIndex;


    public Shop() {
 this.sales = new ArrayList<Transaction>();
        this.refunds = new ArrayList<Transaction>();
    }


    public ArrayList<Transaction> getSales() {
        return sales;
    }


    public ArrayList<Transaction> getRefunds() {
        return refunds;
    }

public void addTransaction(Transaction transaction) {
    if (transaction.getTransactionType() == SALE ) {
        this.sales.add(transaction);}
        else if (transaction.getTransactionType() == REFUND) {
            this.refunds.add(transaction);
        }
//Alternatively, do nothing!

    }


public void newSale(Customer customer, int value) {
    customer.pay(value);
 tempTrans = new Transaction(value, SALE);
    addTransaction(tempTrans);
}


    public void newRefund(Customer customer, int refundIndex){
      tempTrans = this.sales.get(refundIndex);
        this.sales.remove(refundIndex);
    tempTrans.setTransactionType(REFUND);
        addTransaction(tempTrans);

        customer.refund( 0 - tempTrans.getValue());
    }


}


