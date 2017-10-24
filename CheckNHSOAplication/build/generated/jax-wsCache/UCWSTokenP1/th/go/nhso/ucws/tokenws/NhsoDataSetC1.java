
package th.go.nhso.ucws.tokenws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for nhsoDataSetC1 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nhsoDataSetC1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="birthdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="count_select" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="expdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hmain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hmain_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hmain_op" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hmain_op_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hsub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hsub_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maininscl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maininscl_main" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maininscl_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mastercup_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_date_register" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="new_expdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_hmain" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_hmain_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_hmain_op" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_hmain_op_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_hsub" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_hsub_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_maininscl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_maininscl_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_mastercup_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_paid_model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_purchaseprovince" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_purchaseprovince_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_staffname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_startdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_subinscl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_subinscl_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_type_register" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="new_type_register_desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paid_model" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="person_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primary_amphur_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primary_moo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primary_mooban_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primary_province_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primary_tumbon_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primaryprovince" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="purchaseprovince" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="purchaseprovince_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startdate_sss" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status_desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subinscl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subinscl_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="title_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ws_data_source" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ws_date_request" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ws_status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ws_status_desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wsid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wsid_batch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nhsoDataSetC1", propOrder = {
    "birthdate",
    "cardid",
    "chat",
    "countSelect",
    "expdate",
    "fname",
    "hmain",
    "hmainName",
    "hmainOp",
    "hmainOpName",
    "hsub",
    "hsubName",
    "lname",
    "maininscl",
    "maininsclMain",
    "maininsclName",
    "mastercupId",
    "nation",
    "newDateRegister",
    "newExpdate",
    "newHmain",
    "newHmainName",
    "newHmainOp",
    "newHmainOpName",
    "newHsub",
    "newHsubName",
    "newMaininscl",
    "newMaininsclName",
    "newMastercupId",
    "newPaidModel",
    "newPurchaseprovince",
    "newPurchaseprovinceName",
    "newStaffname",
    "newStartdate",
    "newSubinscl",
    "newSubinsclName",
    "newTypeRegister",
    "newTypeRegisterDesc",
    "paidModel",
    "personId",
    "primaryAmphurName",
    "primaryMoo",
    "primaryMoobanName",
    "primaryProvinceName",
    "primaryTumbonName",
    "primaryprovince",
    "purchaseprovince",
    "purchaseprovinceName",
    "sex",
    "startdate",
    "startdateSss",
    "status",
    "statusDesc",
    "subinscl",
    "subinsclName",
    "title",
    "titleName",
    "wsDataSource",
    "wsDateRequest",
    "wsStatus",
    "wsStatusDesc",
    "wsid",
    "wsidBatch"
})
public class NhsoDataSetC1 {

    protected String birthdate;
    protected String cardid;
    protected String chat;
    @XmlElement(name = "count_select")
    protected int countSelect;
    protected String expdate;
    protected String fname;
    protected String hmain;
    @XmlElement(name = "hmain_name")
    protected String hmainName;
    @XmlElement(name = "hmain_op")
    protected String hmainOp;
    @XmlElement(name = "hmain_op_name")
    protected String hmainOpName;
    protected String hsub;
    @XmlElement(name = "hsub_name")
    protected String hsubName;
    protected String lname;
    protected String maininscl;
    @XmlElement(name = "maininscl_main")
    protected String maininsclMain;
    @XmlElement(name = "maininscl_name")
    protected String maininsclName;
    @XmlElement(name = "mastercup_id")
    protected String mastercupId;
    protected String nation;
    @XmlElement(name = "new_date_register")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar newDateRegister;
    @XmlElement(name = "new_expdate")
    protected String newExpdate;
    @XmlElement(name = "new_hmain")
    protected String newHmain;
    @XmlElement(name = "new_hmain_name")
    protected String newHmainName;
    @XmlElement(name = "new_hmain_op")
    protected String newHmainOp;
    @XmlElement(name = "new_hmain_op_name")
    protected String newHmainOpName;
    @XmlElement(name = "new_hsub")
    protected String newHsub;
    @XmlElement(name = "new_hsub_name")
    protected String newHsubName;
    @XmlElement(name = "new_maininscl")
    protected String newMaininscl;
    @XmlElement(name = "new_maininscl_name")
    protected String newMaininsclName;
    @XmlElement(name = "new_mastercup_id")
    protected String newMastercupId;
    @XmlElement(name = "new_paid_model")
    protected String newPaidModel;
    @XmlElement(name = "new_purchaseprovince")
    protected String newPurchaseprovince;
    @XmlElement(name = "new_purchaseprovince_name")
    protected String newPurchaseprovinceName;
    @XmlElement(name = "new_staffname")
    protected String newStaffname;
    @XmlElement(name = "new_startdate")
    protected String newStartdate;
    @XmlElement(name = "new_subinscl")
    protected String newSubinscl;
    @XmlElement(name = "new_subinscl_name")
    protected String newSubinsclName;
    @XmlElement(name = "new_type_register")
    protected String newTypeRegister;
    @XmlElement(name = "new_type_register_desc")
    protected String newTypeRegisterDesc;
    @XmlElement(name = "paid_model")
    protected String paidModel;
    @XmlElement(name = "person_id")
    protected String personId;
    @XmlElement(name = "primary_amphur_name")
    protected String primaryAmphurName;
    @XmlElement(name = "primary_moo")
    protected String primaryMoo;
    @XmlElement(name = "primary_mooban_name")
    protected String primaryMoobanName;
    @XmlElement(name = "primary_province_name")
    protected String primaryProvinceName;
    @XmlElement(name = "primary_tumbon_name")
    protected String primaryTumbonName;
    protected String primaryprovince;
    protected String purchaseprovince;
    @XmlElement(name = "purchaseprovince_name")
    protected String purchaseprovinceName;
    protected String sex;
    protected String startdate;
    @XmlElement(name = "startdate_sss")
    protected String startdateSss;
    protected String status;
    @XmlElement(name = "status_desc")
    protected String statusDesc;
    protected String subinscl;
    @XmlElement(name = "subinscl_name")
    protected String subinsclName;
    protected String title;
    @XmlElement(name = "title_name")
    protected String titleName;
    @XmlElement(name = "ws_data_source")
    protected String wsDataSource;
    @XmlElement(name = "ws_date_request")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar wsDateRequest;
    @XmlElement(name = "ws_status")
    protected String wsStatus;
    @XmlElement(name = "ws_status_desc")
    protected String wsStatusDesc;
    protected String wsid;
    @XmlElement(name = "wsid_batch")
    protected String wsidBatch;

    /**
     * Gets the value of the birthdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the value of the birthdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthdate(String value) {
        this.birthdate = value;
    }

    /**
     * Gets the value of the cardid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardid() {
        return cardid;
    }

    /**
     * Sets the value of the cardid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardid(String value) {
        this.cardid = value;
    }

    /**
     * Gets the value of the chat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChat() {
        return chat;
    }

    /**
     * Sets the value of the chat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChat(String value) {
        this.chat = value;
    }

    /**
     * Gets the value of the countSelect property.
     * 
     */
    public int getCountSelect() {
        return countSelect;
    }

    /**
     * Sets the value of the countSelect property.
     * 
     */
    public void setCountSelect(int value) {
        this.countSelect = value;
    }

    /**
     * Gets the value of the expdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpdate() {
        return expdate;
    }

    /**
     * Sets the value of the expdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpdate(String value) {
        this.expdate = value;
    }

    /**
     * Gets the value of the fname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFname() {
        return fname;
    }

    /**
     * Sets the value of the fname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFname(String value) {
        this.fname = value;
    }

    /**
     * Gets the value of the hmain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHmain() {
        return hmain;
    }

    /**
     * Sets the value of the hmain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHmain(String value) {
        this.hmain = value;
    }

    /**
     * Gets the value of the hmainName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHmainName() {
        return hmainName;
    }

    /**
     * Sets the value of the hmainName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHmainName(String value) {
        this.hmainName = value;
    }

    /**
     * Gets the value of the hmainOp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHmainOp() {
        return hmainOp;
    }

    /**
     * Sets the value of the hmainOp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHmainOp(String value) {
        this.hmainOp = value;
    }

    /**
     * Gets the value of the hmainOpName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHmainOpName() {
        return hmainOpName;
    }

    /**
     * Sets the value of the hmainOpName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHmainOpName(String value) {
        this.hmainOpName = value;
    }

    /**
     * Gets the value of the hsub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHsub() {
        return hsub;
    }

    /**
     * Sets the value of the hsub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHsub(String value) {
        this.hsub = value;
    }

    /**
     * Gets the value of the hsubName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHsubName() {
        return hsubName;
    }

    /**
     * Sets the value of the hsubName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHsubName(String value) {
        this.hsubName = value;
    }

    /**
     * Gets the value of the lname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLname() {
        return lname;
    }

    /**
     * Sets the value of the lname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLname(String value) {
        this.lname = value;
    }

    /**
     * Gets the value of the maininscl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaininscl() {
        return maininscl;
    }

    /**
     * Sets the value of the maininscl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaininscl(String value) {
        this.maininscl = value;
    }

    /**
     * Gets the value of the maininsclMain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaininsclMain() {
        return maininsclMain;
    }

    /**
     * Sets the value of the maininsclMain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaininsclMain(String value) {
        this.maininsclMain = value;
    }

    /**
     * Gets the value of the maininsclName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaininsclName() {
        return maininsclName;
    }

    /**
     * Sets the value of the maininsclName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaininsclName(String value) {
        this.maininsclName = value;
    }

    /**
     * Gets the value of the mastercupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMastercupId() {
        return mastercupId;
    }

    /**
     * Sets the value of the mastercupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMastercupId(String value) {
        this.mastercupId = value;
    }

    /**
     * Gets the value of the nation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNation() {
        return nation;
    }

    /**
     * Sets the value of the nation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNation(String value) {
        this.nation = value;
    }

    /**
     * Gets the value of the newDateRegister property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNewDateRegister() {
        return newDateRegister;
    }

    /**
     * Sets the value of the newDateRegister property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNewDateRegister(XMLGregorianCalendar value) {
        this.newDateRegister = value;
    }

    /**
     * Gets the value of the newExpdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewExpdate() {
        return newExpdate;
    }

    /**
     * Sets the value of the newExpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewExpdate(String value) {
        this.newExpdate = value;
    }

    /**
     * Gets the value of the newHmain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewHmain() {
        return newHmain;
    }

    /**
     * Sets the value of the newHmain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewHmain(String value) {
        this.newHmain = value;
    }

    /**
     * Gets the value of the newHmainName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewHmainName() {
        return newHmainName;
    }

    /**
     * Sets the value of the newHmainName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewHmainName(String value) {
        this.newHmainName = value;
    }

    /**
     * Gets the value of the newHmainOp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewHmainOp() {
        return newHmainOp;
    }

    /**
     * Sets the value of the newHmainOp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewHmainOp(String value) {
        this.newHmainOp = value;
    }

    /**
     * Gets the value of the newHmainOpName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewHmainOpName() {
        return newHmainOpName;
    }

    /**
     * Sets the value of the newHmainOpName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewHmainOpName(String value) {
        this.newHmainOpName = value;
    }

    /**
     * Gets the value of the newHsub property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewHsub() {
        return newHsub;
    }

    /**
     * Sets the value of the newHsub property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewHsub(String value) {
        this.newHsub = value;
    }

    /**
     * Gets the value of the newHsubName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewHsubName() {
        return newHsubName;
    }

    /**
     * Sets the value of the newHsubName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewHsubName(String value) {
        this.newHsubName = value;
    }

    /**
     * Gets the value of the newMaininscl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewMaininscl() {
        return newMaininscl;
    }

    /**
     * Sets the value of the newMaininscl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewMaininscl(String value) {
        this.newMaininscl = value;
    }

    /**
     * Gets the value of the newMaininsclName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewMaininsclName() {
        return newMaininsclName;
    }

    /**
     * Sets the value of the newMaininsclName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewMaininsclName(String value) {
        this.newMaininsclName = value;
    }

    /**
     * Gets the value of the newMastercupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewMastercupId() {
        return newMastercupId;
    }

    /**
     * Sets the value of the newMastercupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewMastercupId(String value) {
        this.newMastercupId = value;
    }

    /**
     * Gets the value of the newPaidModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPaidModel() {
        return newPaidModel;
    }

    /**
     * Sets the value of the newPaidModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPaidModel(String value) {
        this.newPaidModel = value;
    }

    /**
     * Gets the value of the newPurchaseprovince property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPurchaseprovince() {
        return newPurchaseprovince;
    }

    /**
     * Sets the value of the newPurchaseprovince property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPurchaseprovince(String value) {
        this.newPurchaseprovince = value;
    }

    /**
     * Gets the value of the newPurchaseprovinceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPurchaseprovinceName() {
        return newPurchaseprovinceName;
    }

    /**
     * Sets the value of the newPurchaseprovinceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPurchaseprovinceName(String value) {
        this.newPurchaseprovinceName = value;
    }

    /**
     * Gets the value of the newStaffname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewStaffname() {
        return newStaffname;
    }

    /**
     * Sets the value of the newStaffname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewStaffname(String value) {
        this.newStaffname = value;
    }

    /**
     * Gets the value of the newStartdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewStartdate() {
        return newStartdate;
    }

    /**
     * Sets the value of the newStartdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewStartdate(String value) {
        this.newStartdate = value;
    }

    /**
     * Gets the value of the newSubinscl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewSubinscl() {
        return newSubinscl;
    }

    /**
     * Sets the value of the newSubinscl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewSubinscl(String value) {
        this.newSubinscl = value;
    }

    /**
     * Gets the value of the newSubinsclName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewSubinsclName() {
        return newSubinsclName;
    }

    /**
     * Sets the value of the newSubinsclName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewSubinsclName(String value) {
        this.newSubinsclName = value;
    }

    /**
     * Gets the value of the newTypeRegister property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewTypeRegister() {
        return newTypeRegister;
    }

    /**
     * Sets the value of the newTypeRegister property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewTypeRegister(String value) {
        this.newTypeRegister = value;
    }

    /**
     * Gets the value of the newTypeRegisterDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewTypeRegisterDesc() {
        return newTypeRegisterDesc;
    }

    /**
     * Sets the value of the newTypeRegisterDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewTypeRegisterDesc(String value) {
        this.newTypeRegisterDesc = value;
    }

    /**
     * Gets the value of the paidModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaidModel() {
        return paidModel;
    }

    /**
     * Sets the value of the paidModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaidModel(String value) {
        this.paidModel = value;
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

    /**
     * Gets the value of the primaryAmphurName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryAmphurName() {
        return primaryAmphurName;
    }

    /**
     * Sets the value of the primaryAmphurName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryAmphurName(String value) {
        this.primaryAmphurName = value;
    }

    /**
     * Gets the value of the primaryMoo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryMoo() {
        return primaryMoo;
    }

    /**
     * Sets the value of the primaryMoo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryMoo(String value) {
        this.primaryMoo = value;
    }

    /**
     * Gets the value of the primaryMoobanName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryMoobanName() {
        return primaryMoobanName;
    }

    /**
     * Sets the value of the primaryMoobanName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryMoobanName(String value) {
        this.primaryMoobanName = value;
    }

    /**
     * Gets the value of the primaryProvinceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryProvinceName() {
        return primaryProvinceName;
    }

    /**
     * Sets the value of the primaryProvinceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryProvinceName(String value) {
        this.primaryProvinceName = value;
    }

    /**
     * Gets the value of the primaryTumbonName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryTumbonName() {
        return primaryTumbonName;
    }

    /**
     * Sets the value of the primaryTumbonName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryTumbonName(String value) {
        this.primaryTumbonName = value;
    }

    /**
     * Gets the value of the primaryprovince property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryprovince() {
        return primaryprovince;
    }

    /**
     * Sets the value of the primaryprovince property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryprovince(String value) {
        this.primaryprovince = value;
    }

    /**
     * Gets the value of the purchaseprovince property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseprovince() {
        return purchaseprovince;
    }

    /**
     * Sets the value of the purchaseprovince property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseprovince(String value) {
        this.purchaseprovince = value;
    }

    /**
     * Gets the value of the purchaseprovinceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseprovinceName() {
        return purchaseprovinceName;
    }

    /**
     * Sets the value of the purchaseprovinceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseprovinceName(String value) {
        this.purchaseprovinceName = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSex(String value) {
        this.sex = value;
    }

    /**
     * Gets the value of the startdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartdate() {
        return startdate;
    }

    /**
     * Sets the value of the startdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartdate(String value) {
        this.startdate = value;
    }

    /**
     * Gets the value of the startdateSss property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartdateSss() {
        return startdateSss;
    }

    /**
     * Sets the value of the startdateSss property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartdateSss(String value) {
        this.startdateSss = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDesc() {
        return statusDesc;
    }

    /**
     * Sets the value of the statusDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDesc(String value) {
        this.statusDesc = value;
    }

    /**
     * Gets the value of the subinscl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubinscl() {
        return subinscl;
    }

    /**
     * Sets the value of the subinscl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubinscl(String value) {
        this.subinscl = value;
    }

    /**
     * Gets the value of the subinsclName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubinsclName() {
        return subinsclName;
    }

    /**
     * Sets the value of the subinsclName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubinsclName(String value) {
        this.subinsclName = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the titleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitleName() {
        return titleName;
    }

    /**
     * Sets the value of the titleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitleName(String value) {
        this.titleName = value;
    }

    /**
     * Gets the value of the wsDataSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsDataSource() {
        return wsDataSource;
    }

    /**
     * Sets the value of the wsDataSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsDataSource(String value) {
        this.wsDataSource = value;
    }

    /**
     * Gets the value of the wsDateRequest property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWsDateRequest() {
        return wsDateRequest;
    }

    /**
     * Sets the value of the wsDateRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWsDateRequest(XMLGregorianCalendar value) {
        this.wsDateRequest = value;
    }

    /**
     * Gets the value of the wsStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsStatus() {
        return wsStatus;
    }

    /**
     * Sets the value of the wsStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsStatus(String value) {
        this.wsStatus = value;
    }

    /**
     * Gets the value of the wsStatusDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsStatusDesc() {
        return wsStatusDesc;
    }

    /**
     * Sets the value of the wsStatusDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsStatusDesc(String value) {
        this.wsStatusDesc = value;
    }

    /**
     * Gets the value of the wsid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsid() {
        return wsid;
    }

    /**
     * Sets the value of the wsid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsid(String value) {
        this.wsid = value;
    }

    /**
     * Gets the value of the wsidBatch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsidBatch() {
        return wsidBatch;
    }

    /**
     * Sets the value of the wsidBatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsidBatch(String value) {
        this.wsidBatch = value;
    }

}
