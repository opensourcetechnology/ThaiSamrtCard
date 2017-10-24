
package th.go.nhso.ucws.tokenws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the th.go.nhso.ucws.tokenws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SearchCurrentByPID_QNAME = new QName("http://tokenws.ucws.nhso.go.th/", "searchCurrentByPID");
    private final static QName _SearchCurrentByPIDResponse_QNAME = new QName("http://tokenws.ucws.nhso.go.th/", "searchCurrentByPIDResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: th.go.nhso.ucws.tokenws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchCurrentByPIDResponse }
     * 
     */
    public SearchCurrentByPIDResponse createSearchCurrentByPIDResponse() {
        return new SearchCurrentByPIDResponse();
    }

    /**
     * Create an instance of {@link SearchCurrentByPID }
     * 
     */
    public SearchCurrentByPID createSearchCurrentByPID() {
        return new SearchCurrentByPID();
    }

    /**
     * Create an instance of {@link NhsoDataSetC1 }
     * 
     */
    public NhsoDataSetC1 createNhsoDataSetC1() {
        return new NhsoDataSetC1();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCurrentByPID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tokenws.ucws.nhso.go.th/", name = "searchCurrentByPID")
    public JAXBElement<SearchCurrentByPID> createSearchCurrentByPID(SearchCurrentByPID value) {
        return new JAXBElement<SearchCurrentByPID>(_SearchCurrentByPID_QNAME, SearchCurrentByPID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchCurrentByPIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tokenws.ucws.nhso.go.th/", name = "searchCurrentByPIDResponse")
    public JAXBElement<SearchCurrentByPIDResponse> createSearchCurrentByPIDResponse(SearchCurrentByPIDResponse value) {
        return new JAXBElement<SearchCurrentByPIDResponse>(_SearchCurrentByPIDResponse_QNAME, SearchCurrentByPIDResponse.class, null, value);
    }

}
