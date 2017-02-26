
package com.codeclan.example.myshop;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PaymentTest {

        Customer zarya;
        CreditCard masterCard;
    Boolean booleanResult;
    int result;


    @Before
    public void before() {
        zarya = new Customer();
        masterCard = new CreditCard(500);

    }

@Test
public void test_canCheckPurchasePossible() {
booleanResult = masterCard.paymentPossible(300);
    assertEquals(true, booleanResult);

}

    @Test
    public void test_payUpdatesAvailableFunds() {
        masterCard.payCard(250);
       result = masterCard.getAvailableFunds();

        assertEquals(250, result);
    }

@Test
    public void test_canSetPaymentMethod(){
zarya.setPreferredPayment(CreditCard.class);
    assertEquals(CreditCard.class, zarya.getPreferredPayment());
}

}
