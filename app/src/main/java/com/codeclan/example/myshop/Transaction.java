package com.codeclan.example.myshop;
import java.util.ArrayList;

/**
 * Created by user on 24/02/2017.
 */

public class Transaction {
    int value;
TransactionType transactionType;




    public Transaction(int value, TransactionType transactionType) {
this.transactionType = transactionType;
this.value = value;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }



}
