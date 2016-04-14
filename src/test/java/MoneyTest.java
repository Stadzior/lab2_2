import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Currency;

/**
 * Created by Kamil on 2016-04-14.
 */
public class MoneyTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenSubtractMissmatchedCurrencies(){
        Money euros = new Money(1, Currency.getInstance("EUR"));
        Money dollars = new Money(1,Currency.getInstance("USD"));
        euros.subtract(dollars);
    }
}
