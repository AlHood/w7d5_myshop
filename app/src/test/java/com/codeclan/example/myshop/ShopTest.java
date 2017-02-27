
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
    Shop rooskiFit;
    DebitCard visaDebit;
    ArrayList<Transaction> arraylistResult2;
    int result2;
    ArrayList<Transaction> mysteryObject;
    Transaction mysteryObject2;


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

@Test public void test_CustomerCanRefund() {
    voomFit.newSale(zarya, 300);
    voomFit.newRefund(zarya, 0);
    result = masterCard.getAvailableFunds();
assertEquals(500, result);
    arraylistResult = voomFit.getRefunds();
    assertEquals( 1, arraylistResult.size());
}

    @Test public void test_shopRemovesSaleAfterRefund() {
        voomFit.newSale(zarya, 300);
        voomFit.newRefund(zarya, 0);
        result = masterCard.getAvailableFunds();
        assertEquals(500, result);
        arraylistResult = voomFit.getSales();
        assertEquals( 0, arraylistResult.size());
    }

    @Test
    public void test_ShortOfFundsFails() {
    voomFit.newSale(zarya, 999);
        result = masterCard.getAvailableFunds();
        arraylistResult = voomFit.getSales();
        assertEquals(500, result);
        assertEquals(0, arraylistResult.size());
    }

@Test
    public void test_CustomerDoesEverything() {
    rooskiFit = new Shop();
    visaDebit = new DebitCard(300);
    zarya.addPaymentMethod(visaDebit);

    voomFit.newSale(zarya, 300);
    voomFit.newRefund(zarya, 0);

    zarya.setPreferredPayment(DebitCard.class);
    rooskiFit.newSale(zarya, 250);
    voomFit.newSale(zarya, 400);

    arraylistResult = voomFit.getSales();
    result = masterCard.getAvailableFunds();
result2 = visaDebit.getAvailableFunds();
    arraylistResult2 = rooskiFit.getSales();

    assertEquals(50, result2);
          assertEquals(500, result);
    assertEquals(1, arraylistResult2.size());
    assertEquals(0, arraylistResult.size());

}



}
