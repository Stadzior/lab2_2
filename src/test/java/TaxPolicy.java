import pl.com.bottega.ecommerce.sales.domain.invoicing.Tax;
import pl.com.bottega.ecommerce.sales.domain.invoicing.ITaxPolicy;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

/**
 * Created by Kamil on 2016-04-14.
 */
public class TaxPolicy implements ITaxPolicy {
    @Override
    public Tax calculateTax(ProductType productType, Money net) {
        return new Tax()
    }
}
