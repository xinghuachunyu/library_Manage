package managermodel;

public class managerBean {
	private int id;//管理员id
	private String name;//管理员姓名
	private String pwd;//管理员密码
	private int sysset;//系统设置权限
	private int readerset;//读者管理权限
	private int bookset;//图书管理权限
	private int borrowback;//图书借还权限
	private int sysquery;//系统查询权限
	public int getSysset() {
		return sysset;
	}
	public void setSysset(int sysset) {
		this.sysset = sysset;
	}
	public int getReaderset() {
		return readerset;
	}
	public void setReaderset(int readerset) {
		this.readerset = readerset;
	}
	public int getBookset() {
		return bookset;
	}
	public void setBookset(int bookset) {
		this.bookset = bookset;
	}
	public int getBorrowback() {
		return borrowback;
	}
	public void setBorrowback(int borrowback) {
		this.borrowback = borrowback;
	}
	public int getSysquery() {
		return sysquery;
	}
	public void setSysquery(int sysquery) {
		this.sysquery = sysquery;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	

}
