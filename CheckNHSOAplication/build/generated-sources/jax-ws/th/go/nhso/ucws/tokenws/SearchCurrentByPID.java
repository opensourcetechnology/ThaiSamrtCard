
package th.go.nhso.ucws.tokenws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchCurrentByPID complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchCurrentByPID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user_person_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="smctoken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="person_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchCurrentByPID", propOrder = {
    "userPersonId",
    "smctoken",
    "personId"
})
public class SearchCurrentByPID {

    @XmlElement(name = "user_person_id")
    protected String userPersonId;
    protected String smctoken;
    @XmlElement(name = "person_id")
    protected String personId;

    /**
     * Gets the value of the userPersonId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPersonId() {
        return userPersonId;
    }

    /**
     * Sets the value of the userPersonId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPersonId(String value) {
        this.userPersonId = value;
    }

    /**
     * Gets the value of the smctoken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmctoken() {
        return smctoken;
    }

    /**
     * Sets the value of the smctoken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmctoken(String value) {
        this.smctoken = value;
    }

    /**
     * Gets the value of the personId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonId(String value) {
        this.personId = value;
    }

}
