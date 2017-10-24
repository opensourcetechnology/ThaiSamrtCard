
package th.go.nhso.ucws.tokenws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchCurrentByPIDResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchCurrentByPIDResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://tokenws.ucws.nhso.go.th/}nhsoDataSetC1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchCurrentByPIDResponse", propOrder = {
    "_return"
})
public class SearchCurrentByPIDResponse {

    @XmlElement(name = "return")
    protected NhsoDataSetC1 _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link NhsoDataSetC1 }
     *     
     */
    public NhsoDataSetC1 getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link NhsoDataSetC1 }
     *     
     */
    public void setReturn(NhsoDataSetC1 value) {
        this._return = value;
    }

}
