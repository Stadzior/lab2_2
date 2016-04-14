import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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
    @Test @Ignore
    public void ShouldReturnFourThousands_WhenMoneyMultipliedByTwo() {
        Money accountBalance = new Money(new BigDecimal(2000),Currency.getInstance("EUR"));

        accountBalance = accountBalance.multiplyBy(2);

        assertThat(accountBalance.GetDenomination(), equalTo(new BigDecimal(4000)));
    }
}
