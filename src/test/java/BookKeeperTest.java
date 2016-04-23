import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.*;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.Date;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class BookKeeperTest {
    ClientData client;
    InvoiceRequest invoiceRequest;
    BookKeeper bookKeeper;
    TaxPolicy taxPolicy;
    @Before
    public void initialize(){
        client = new ClientData(Id.generate(),"Johnny Testowy");
        invoiceRequest = new InvoiceRequest(client);
        bookKeeper = new BookKeeper();
        taxPolicy = new TaxPolicy();
    }
    @Test
    public void ShouldReturnEmptyInvoice_WhenRequestIsEmpty(){

        Invoice invoice = bookKeeper.issuance(invoiceRequest, taxPolicy);
        assertThat(invoice.getItems().isEmpty(),equalTo(true));
    }
    @Test
    public void ShouldReturnTwelvePercentTax_WhenStandardTaxPolicyIsPassed(){

        ProductData data = new ProductData(Id.generate(),new Money(400),"Test", ProductType.DRUG,new Date());
        RequestItem item = new RequestItem(data,5,new Money(400));
        invoiceRequest.add(item);
        Invoice invoice = bookKeeper.issuance(invoiceRequest, taxPolicy);
        Money taxAmount = invoice.getItems().get(0).getTax().getAmount();
        assertThat(taxAmount.GetDenomination().doubleValue(),equalTo(48.00));
    }
}
