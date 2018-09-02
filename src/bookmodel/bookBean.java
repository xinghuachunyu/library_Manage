package bookmodel;

import java.util.Date;

public class bookBean {
	private String barcode;//ͼ����
	private String bookname;//ͼ������
	private int typeid;//ͼ�����ͱ��
	private String author; //����
	private String translator;//����
	private String ISBN; //��������
	private float price;//�۸�
	private int page;//ҳ��
	private int bookcase;//��ܱ��
	private String inTime;//¼��ʱ��
	private String operator;//����Ա
	private int del;//�Ƿ��Ѿ��¼�
	private int id;//ͼ����
	private int borrowNum;//ͼ�������
	private String name;//�������
	private String typename;//ͼ������
	private int days;//�ɽ�����
	private int bookid;
	
	
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	private String readBarcode;
	private String readName;
	private Date borrowTime;
	private Date backTime;
	private int ifback;
	public String getReadBarcode() {
		return readBarcode;
	}
	public void setReadBarcode(String readBarcode) {
		this.readBarcode = readBarcode;
	}
	public String getReadName() {
		return readName;
	}
	public void setReadName(String readName) {
		this.readName = readName;
	}
	public Date getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}
	public Date getBackTime() {
		return backTime;
	}
	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}
	public int getIfback() {
		return ifback;
	}
	public void setIfback(int ifback) {
		this.ifback = ifback;
	}
	
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBorrowNum() {
		return borrowNum;
	}
	public void setBorrowNum(int borrowNum) {
		this.borrowNum = borrowNum;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getBookcase() {
		return bookcase;
	}
	public void setBookcase(int bookcase) {
		this.bookcase = bookcase;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
