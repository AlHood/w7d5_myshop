package com.codeclan.example.myshop;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CustomerTest {


    Customer zarya;
    CreditCard masterCard;
ArrayList<Payment> arrayListResult;


    @Before
    public void before() {
zarya = new Customer();
        masterCard = new CreditCard(500);



    }


    @Test
    public void test_canAddPaymentMethod() {
zarya.addPaymentMethod(masterCard);
        arrayListResult = zarya.getPaymentMethods();

        assertEquals(1, arrayListResult.size());
    }


}