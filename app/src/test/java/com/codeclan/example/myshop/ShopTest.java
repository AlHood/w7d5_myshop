
package com.codeclan.example.myshop;
import static com.codeclan.example.myshop.TransactionType.SALE;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class ShopTest {

Transaction proteinShakes;
Customer zarya;
    CreditCard masterCard;
 Shop voomFit;
  ArrayList<Transaction> arraylistResult;
    int result;

    @Before
    public void before() {
        zarya = new Customer();
        masterCard = new CreditCard(500);
        voomFit = new Shop();
        proteinShakes = new Transaction(100, SALE);
        zarya.setPreferredPayment(CreditCard.class);
        zarya.addPaymentMethod(masterCard);
    }

@Test
    public void test_canAddTransaction() {
voomFit.addTransaction(proteinShakes);
    arraylistResult = voomFit.getSales();
     assertEquals( 1, arraylistResult.size());
}

@Test public void test_CustomerCanBuy() {

voomFit.newSale(zarya, 300);
    result = masterCard.getAvailableFunds();

    assertEquals(200, result);
}



}
