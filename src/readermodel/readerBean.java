package readermodel;

import java.util.Date;

public class readerBean {
	private int id; //���߱��
	private String name=null;//��������
	private String sex=null;//�����Ա�
	private String barcode; //������
	private String vocation=null;//��������
	private String birthday;//��������
	private String paperType=null; //֤������
	private String paperNO=null; //֤������
	private String tel;//�绰
	private String email;//Email��ַ
	private String createDate;//¼��ʱ��
	private String operator;//����Ա
	private String remark;//��ע
	private int typeid;//�������ͱ��
	private int bookid;//�����������鼮id��
	private String bookname;//����ͼ�������
	private String borrowTime;//�鼮����ʱ��
	private String backtime;//�鼮Ӧ�黹ʱ��
	private String ISBN;//������id
	private String price;//����
	private int number;//�ɽ�����
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}
	public String getBacktime() {
		return backtime;
	}
	public void setBacktime(String backtime) {
		this.backtime = backtime;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getVocation() {
		return vocation;
	}
	public void setVocation(String vocation) {
		this.vocation = vocation;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPaperType() {
		return paperType;
	}
	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}
	public String getPaperNO() {
		return paperNO;
	}
	public void setPaperNO(String paperNO) {
		this.paperNO = paperNO;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

}
