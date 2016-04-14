import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.BookKeeper;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceRequest;

/**
 * Created by Kamil on 2016-04-14.
 */
public class BookKeeperTest {
    @Test
    public void ShouldReturnEmptyInvoice_WhenRequestIsEmpty(){
        ClientData client = new ClientData(Id.generate(),"Johnny Testowy");
        InvoiceRequest invoiceRequest = new InvoiceRequest(client);
        BookKeeper bookKeeper = new BookKeeper();

        bookKeeper.issuance(invoiceRequest,);
    }
}
