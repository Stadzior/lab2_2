import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Currency;

/**
 * Created by Kamil on 2016-04-14.
 */
public class MoneyTest {

    Money euros;
    Money dollars;
    @Before
    public void initialize(){
        euros = new Money(1, Currency.getInstance("EUR"));
        dollars = new Money(1,Currency.getInstance("USD"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenSubtractMissmatchedCurrencies(){

        euros.subtract(dollars);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenAddMissmatchedCurrencies() {

        euros.add(dollars);
    }
}
