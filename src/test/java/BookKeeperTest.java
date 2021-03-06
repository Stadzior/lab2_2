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
    ProductData data;
    RequestItem item;
    @Before
    public void initialize(){
        client = new ClientData(Id.generate(),"Johnny Testowy");
        invoiceRequest = new InvoiceRequest(client);
        bookKeeper = new BookKeeper();
        taxPolicy = new TaxPolicy();
        data = new ProductData(Id.generate(),new Money(400),"Test", ProductType.DRUG,new Date());
        item = new RequestItem(data,5,new Money(400));
    }
    @Test
    public void ShouldReturnEmptyInvoice_WhenRequestIsEmpty(){

        Invoice invoice = bookKeeper.issuance(invoiceRequest, taxPolicy);
        assertThat(invoice.getItems().isEmpty(),equalTo(true));
    }
    @Test
    public void ShouldReturnTwelvePercentTax_WhenStandardTaxPolicyIsPassed(){

        invoiceRequest.add(item);
        Invoice invoice = bookKeeper.issuance(invoiceRequest, taxPolicy);
        Money taxAmount = invoice.getItems().get(0).getTax().getAmount();

        assertThat(taxAmount.GetDenomination().doubleValue(), equalTo(48.00));
    }
    @Test
    public void ShouldReturn448Gros_WhenStandardTaxPolicyIsPassed(){

        invoiceRequest.add(item);
        Invoice invoice = bookKeeper.issuance(invoiceRequest, taxPolicy);
        Money gros = invoice.getItems().get(0).getGros();

        assertThat(gros.GetDenomination().doubleValue(),equalTo(448.00));
    }
}
