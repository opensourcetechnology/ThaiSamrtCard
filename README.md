# ThaiSamrtCard
การใช้งาน ThaiSmartCardReader Libary

ซึ่งตัวไลบารี่จะมีชนิดข้อมูลที่ให้บริการ 2 ประเภท คือ
1. ข้อมูลพื้นฐานจากบัตรประจำตัวประชาชน
2. ข้อมูลเกี่ยวกับสิทการรักษา

***เพิ่มเติม***
ข้อมูลสิทธิ์การรักษาจะเป็นข้อมูลที่ได้โดยตรงจากชิปการ์ดของบัตรประจำตัวประชาชน ซึ่งไม่ใช่ข้อมูลอัพเดตล่าสุด

***การใช้งาน***

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
