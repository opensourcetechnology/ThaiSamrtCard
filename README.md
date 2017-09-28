<h1>ThaiSamartCardReader</h1>
การใช้งาน ThaiSmartCardReader Libary
<br>
ซึ่งตัวไลบารี่จะมีชนิดข้อมูลที่ให้บริการ 2 ประเภท คือ
<br>
1. ข้อมูลพื้นฐานจากบัตรประจำตัวประชาชน
<br>
2. ข้อมูลเกี่ยวกับสิทการรักษา
<br>
***เพิ่มเติม***
ข้อมูลสิทธิ์การรักษาจะเป็นข้อมูลที่ได้โดยตรงจากชิปการ์ดของบัตรประจำตัวประชาชน ซึ่งไม่ใช่ข้อมูลอัพเดตล่าสุด

<h3>การใช้งาน</h3>

1.การเชื่อมต่อกับเครื่องอ่านสมาร์ทการ์ด

เริ่มจากเรียกไลบารี่ ดังนี้

    public ThSCM(){
      callCard();
    }
    
    private void callCard(){
      try{
          pcscServices pcsc = new pcscServices(); //  Object ที่ใช้ในการ Gen ข้อมูลจากบัตร
          TerminalFactory factory = TerminalFactory.getDefault();
          List<CardTerminal> terminals = factory.terminals().list(); // ตรวจสอบว่ามีเครื่องอ่านบัตรที่เสียบอยู่กับคอมพิวเตอร์กี่เครื่อง
          
          CardTerminal terminal = terminals.get(0); // เรียกเครื่องอ่านสมาร์ทการ์ดที่มีสถานะ Active อยู่
          
          Card card = terminal.connect("*"); // เป็นเชื่อต่อกับเครื่องอ่านสมาร์ทการ์ดโดยจะไปหาเครื่องที่ Active อยู่ที่อยู่ในตำแหน่งที่ 0
          
          pcsc.getAvialableDataInfo(card, true); // เป็นการเรียกเมทธอดจาก Class pcscService หากต้องการรูปให้ใส่ true ลงในเมทธอด
          
          card.disconnect(true); // เมื่อเครื่องอ่านสมาร์ทการ์ดอ่านเสร็จก็จะทำการ Disconnect
      }catch(CardException ex){
          System.out.println(ex.getMessage());
      }catch(IOException ex){
          System.out.println(ex.getMessage());
      }
    }

2.การเรียกใช้งานข้อมูลที่มีให้บริการ
    
    public static void main(String[] args){
        MoiApplet1Info moi = new MoiApplet1Info();
        NhsoAppletInfo nhso = new NhsoAppletInfo();
        ThSCM thscm = new ThSCM();
        // ส่วนของข้อมูลพื้นฐาน
        System.out.println(moi.getPid()); //แสดงเลขบัตรประจำตัวประชาชน
        System.out.println(moi.getThaiName()); //แสดงชื่อในรุปแบบภาษาไทย
        System.out.println(moi.getEngName()); // แสดงชื่แในรูปแบบภาษาอังกฤษ
        System.out.println(moi.getThaiName().getTitle()); //แสดงคำนำหน้าชื่อ
        System.out.println(moi.getThaiName().getFirstName()); //แสดงชื่อ
        System.out.println(moi.getThaiName().getLastName()); // แสดงนามสกุล
        System.out.println(moi.getAddress()); // แสดงที่อยู่ตามบัตรสมาร์ทการ์ด
        System.out.println(moi.getSexDesc()); // แสดงเพศ
        System.out.println(moi.getFormattedBod()); //แสดงวันเกิด ในรูปแบบ วัน เดือน ปีที่เกิด
        System.out.println(moi.getFormattedDateOfIssue()); // แสดงวันที่ทำบัตร
        System.out.println(moi.getFormattedDateOfExpiry());  // แสดงวันที่บัตรหมดอายุ
        // แสดงค่าออกมาในรูปแบบไบต์อาร์เรย์ ซึ่งผู้ใช้จะต้องนำไปแปลงเป็น Bytebuffer ต่อไปหากพัฒนากับ JAVA
        System.out.println(moi.getFacesImage());
        
        // ส่วนของสิทธิ์การรักษา
        System.out.println(nhso.getChangeHospitalAmount()); 
        System.out.println(nhso.getDateOfExpiry()); // วันหมดอายุของการขอใช้สิทธ์ ข้อมูลจะอยู่ในรูปแบบ ปี เดือน วัน
        System.out.println(nhso.getDateOfIssue()); // วันที่เริ่มใช้สิทธ์ ข้อมูลจะอยู่ในรูปแบบ ปี เดือน วันของการขอใช้บริการ
        System.out.println(nhso.getUpdateDate()); // ข้อมูล ปี เดือน วันที่ถูกอัพเดต 
        System.out.println(nhso.getFormattedDateOfExpirey()); // วันหมดอายุของการขอใช้สิทธ์ ข้อมูลจะอยู่ในรูปแบบ วัน เดือน ปีของวันหมดอายุ 
        System.out.println(nhso.getFormattedDateOfIssue()); // วันที่เริ่มใช้สิทธ์ ข้อมูลจะอยู่ในรูปแบบ วัน เดือน ปีของการขอใช้บริการ 
        System.out.println(nhso.getFormattedUpdateDate()); // ข้อมูล วัน เดือน ปีที่ถูกอัพเดต
        System.out.println(nhso.getMainHospitalsName()); // ข้อมูลชื่อหน่วยบริการที่รับการส่งต่อ
        System.out.println(nhso.getMainRights()); // ข้อมูลของสิทธ์ 
        System.out.println(nhso.getPaidType()); 
        System.out.println(nhso.getSubHospitalsName()); // ข้อมูลชื่อหน่วยบริการปฐมภูมิ
        System.out.println(nhso.getSubRights()); // ข้อมูลช่วงอายุของผู้รับบริการ
    }
<br>
<h3>การติดต่อกับเครื่องอ่านสมาร์ทการ์ด</h3>
<br><br>
    **ADPU** เป็นหน่วยการติดต่อแบบพิเศษ เรียกว่า aplliacation protocol data units
ใช้เพื่อแลกเปลี่ยนข้อมูลกับ Type 4 Tag platform
<br>
C-ADPU : คำสั่งที่ถูกส่งมาจากอุปกรณ์อ่านการ์ด
<br>
R-ADPU : คำตอบที่ถูกส่งมาจากเครื่องอ่านการ์ด
<br><br>
<h3>ADPU Types</h3>
<br>
<table align="center">
    <tr align="center">
        <td>Field</td>
        <td>Description</td>
    </tr>
    <tr align="center">
        <td>Select</td>
        <td>เลือกแอพพลิเคชั่นหรือไฟล์</td>
    </tr>
    <tr align="center">
        <td>ReadBinary</td>
        <td>อ่านข้อมูลจากไฟล์</td>
    </tr>
    <tr align="center">
        <td>UpdateBinary</td>
        <td>เขียนข้อมูลลงในไฟล์</td>
    </tr>
</table>
<br>
<h3>C-ADPU</h3>
<table align="center">
    <tr align="center">
        <td>Field</td>
        <td>Length</td>
        <td>Required</td>
        <td>Description</td>
    </tr>
    <tr align="center">
        <td>CLA</td>
        <td>1 byte</td>
        <td>yes</td>
        <td>เป็นตัวกำหนดความปลอดภัยของข้อความ</td>
    </tr>
    <tr align="center">
        <td>INS</td>
        <td>1 byte</td>
        <td>yes</td>
        <td>ตัวกำหนดชนิดคำสั่งในการประมวลผล ดูจาก APDU type</td>
    </tr>
    <tr align="center">
        <td>P1</td>
        <td>1 byte</td>
        <td>yes</td>
        <td>เป็นตัวกำหนด parameter แรกสำหรับชนิดคำสั่งที่ถูกเลือก</td>
    </tr>
    <tr align="center">
        <td>Lc</td>
        <td>1||3 byte</td>
        <td>no</td>
        <td>ตัวกำหนดความยาวของข้อมูล</td>
    </tr>
    <tr align="center">
        <td>Data</td>
        <td>Lc byte</td>
        <td>no</td>
        <td>เรียก Lc เพื่อโหลดข้อมูลของ C-ADPU</td>
    </tr>
    <tr align="center">
        <td>Le</td>
        <td>1||2 byte</td>
        <td>no</td>
        <td>ระบุความยาวของ Response ที่จะออกมาจาก R-ADPU</td>
    </tr>
</table>
<br>
<h3>R-ADPU</h3>
<table align="center">
    <tr align="center">
        <td>Field</td>
        <td>Length</td>
        <td>Required</td>
        <td>Description</td>
    </tr>
    <tr align="center">
        <td>Response Body</td>
        <td>variable</td>
        <td>no</td>
        <td>เป็นการเอาข้อมูลของ R-ADPU</td>
    </tr>
    <tr align="center">
        <td>SW1</td>
        <td>1 byte</td>
        <td>yes</td>
        <td>ระบุสถานะแรกของคำ</td>
    </tr>
    <tr align="center">
        <td>SW2</td>
        <td>1 byte</td>
        <td>yes</td>
        <td>ระบุสถานะที่สองของคำ</td>
    </tr>
</table>
<br>
<h3>ชุดข้อมูลของข้อมูลพื้นฐาน</h3>
<table align="center">
	<tr align="center">
		<td>Description</td>
		<td>CLA</td>
		<td>INS</td>
		<td>P1</td>
		<td>P2</td>
		<td>Lc</td>
		<td>Data</td>
		<td>Le</td>
	</tr>
	<tr align="center">
		<td>pid</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x00</td>
		<td>0x04</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0x0D</td>
	</tr>
	<tr align="center">
		<td>thaiName</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x00</td>
		<td>0x11</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0x64</td>
	</tr>
	<tr align="center">
		<td>bod</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x00</td>
		<td>0xD9</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0x08</td>
	</tr>
	<tr align="center">
		<td>address</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x15</td>
		<td>0x79</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xA0</td>
	</tr>
	<tr align="center">
		<td>dateOfIssue</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x01</td>
		<td>0x67</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0x08</td>
	</tr>
	<tr align="center">
		<td>dateOfExpiry</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x01</td>
		<td>0x6F</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0x08</td>
	</tr>
	<tr align="center">
		<td>sex</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x00</td>
		<td>0xE1</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0x01</td>
	</tr>
	<tr align="center">
		<td>facesImage 1/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x01</td>
		<td>0x79</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 2/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x02</td>
		<td>0x41</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 3/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x03</td>
		<td>0x09</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 4/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x03</td>
		<td>0xD1</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 5/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x04</td>
		<td>0x99</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 6/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x05</td>
		<td>0x61</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 7/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x06</td>
		<td>0x29</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 8/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x06</td>
		<td>0xF1</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 9/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x07</td>
		<td>0xB9</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 10/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x08</td>
		<td>0x81</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 11/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x09</td>
		<td>0x49</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 12/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x0A</td>
		<td>0x11</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 13/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x0A</td>
		<td>0xD9</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 14/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x0B</td>
		<td>0xA1</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 15/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x0C</td>
		<td>0x69</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 16/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x0D</td>
		<td>0x31</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 17/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x0D</td>
		<td>0xF9</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 18/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x0E</td>
		<td>0xC1</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 19/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x0F</td>
		<td>0x89</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 20/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x10</td>
		<td>0x51</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 21/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x11</td>
		<td>0x19</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 22/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x11</td>
		<td>0xE1</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 23/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x12</td>
		<td>0xA9</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 24/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x13</td>
		<td>0x71</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 25/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x14</td>
		<td>0x39</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0xC8</td>
	</tr>
	<tr align="center">
		<td>facesImage 26/26</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x15</td>
		<td>0x01</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0x78</td>
	</tr>
</table>
<br>
<h3>ชุดข้อมูลเกี่ยวกับสิทธิ์ในการรักษา</h3>
<table>
	<tr align="center">
		<td>Description</td>
		<td>CLA</td>
		<td>INS</td>
		<td>P1</td>
		<td>P2</td>
		<td>Lc</td>
		<td>Data</td>
		<td>Le</td>
	</tr>
	<tr align="center">
		<td>mainRights</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x00</td>
		<td>0x04</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0x3C</td>
	</tr>
	<tr align="center">
		<td>subRights</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x00</td>
		<td>0x40</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0x64</td>
	</tr>
	<tr align="center">
		<td>mainHospitalsName</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x00</td>
		<td>0xA4</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0x50</td>
	</tr>
	<tr align="center">
		<td>subHospitalsName</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x00</td>
		<td>0xF4</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0x50</td>
	</tr>
	<tr align="center">
		<td>paidType</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x01</td>
		<td>0x44</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0x01</td>
	</tr>
	<tr align="center">
		<td>dateOfIssue</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x01</td>
		<td>0x45</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0x08</td>
	</tr>
	<tr align="center">
		<td>dateOfExpiry</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x01</td>
		<td>0x4D</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0x08</td>
	</tr>
	<tr align="center">
		<td>updateDate</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x00</td>
		<td>0x55</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0x08</td>
	</tr>
	<tr align="center">
		<td>changeHospitalAmount</td>
		<td>0x80</td>
		<td>0xB0</td>
		<td>0x01</td>
		<td>0x5D</td>
		<td>0x02</td>
		<td>0x00</td>
		<td>0x01</td>
	</tr>
</table>
