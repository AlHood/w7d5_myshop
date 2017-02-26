package com.codeclan.example.myshop;


/**
 * Created by user on 24/02/2017.
 */

public class DebitCard extends Payment {

int availableFunds;

    public DebitCard(int availableFunds) {
        this.availableFunds = availableFunds;
    }

    public boolean paymentPossible(int purchase) {

        if (purchase <= availableFunds) {
            return true;
        }
        return false;
    }

    public int getAvailableFunds() {
        return availableFunds;
    }


    public void setAvailableFunds(int availableFunds) {
        this.availableFunds = availableFunds;
    }


    public void payCard(int purchase) {
        this.setAvailableFunds((getAvailableFunds()) - purchase);
    }




}
