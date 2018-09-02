package bookmodel;

import java.sql.Connection;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public class bookBeanCL {
	private Statement sm=null;
	private ResultSet rs=null;
	private Connection ct=null;
	public ArrayList getbookallInformation()//
	{
		
		ArrayList al=new ArrayList();
		try
		{
			ct=new bookConnDB().getConn();
			//3.����statement
			sm=ct.createStatement();
			
			//��ѯ����Ҫ��ʾ�ļ�¼
			rs=sm.executeQuery("select  barcode,bookname,typeid,author,translator,ISBN,price,page,bookcase,inTime,operator,del,bookinfo.id,borrowNum,name,typename from bookinfo,bookranking,bookcase,booktype where bookinfo.id=bookRanking. id and bookRanking.id=bookcase.id and bookcase.id=booktype.id order by borrowNum desc");
			//rs=sm.executeQuery("select top "+pagesize+" from [user] where userID not in (select top "+pagesize*(pageNow-1)+" userID from [user])");

			//��ʼ��װ
			while(rs.next())
			{
				bookBean bk=new bookBean();
				bk.setBarcode(rs.getString(1));
				bk.setBookname(rs.getString(2));
				bk.setTypeid(rs.getInt(3));
				bk.setAuthor(rs.getString(4));
				bk.setTranslator(rs.getString(5));
				bk.setISBN(rs.getString(6));
				bk.setPrice(rs.getFloat(7));
				bk.setPage(rs.getInt(8));
				bk.setBookcase(rs.getInt(9));
				bk.setInTime(rs.getString(10));
				bk.setOperator(rs.getString(11));
				bk.setDel(rs.getInt(12));
				bk.setId(rs.getInt(13));
				bk.setBorrowNum(rs.getInt(14));
				bk.setName(rs.getString(15));
				bk.setTypename(rs.getString(16));
				al.add(bk);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			this.close();
		}
		return al;
	}
	
	public ArrayList getbookinfoInformation()//
	{
	ArrayList al=new ArrayList();
	try
	{
		ct=new bookConnDB().getConn();
		//3.����statement
		sm=ct.createStatement();
		
		//��ѯ����Ҫ��ʾ�ļ�¼
		rs=sm.executeQuery("select barcode,bookname, typeid, author, translator, ISBN, price,  page, bookcase, inTime, operator, del, bookinfo.id, name from bookinfo,bookcase where bookinfo.id=bookcase.id");
		//rs=sm.executeQuery("select top "+pagesize+" from [user] where userID not in (select top "+pagesize*(pageNow-1)+" userID from [user])");

		//��ʼ��װ
		while(rs.next())
		{
			bookBean bk=new bookBean();
			bk.setBarcode(rs.getString(1));
			bk.setBookname(rs.getString(2));
			bk.setTypeid(rs.getInt(3));
			bk.setAuthor(rs.getString(4));
			bk.setTranslator(rs.getString(5));
			bk.setISBN(rs.getString(6));
			bk.setPrice(rs.getFloat(7));
			bk.setPage(rs.getInt(8));
			bk.setBookcase(rs.getInt(9));
			bk.setInTime(rs.getString(10));
			bk.setOperator(rs.getString(11));
			bk.setDel(rs.getInt(12));
			bk.setId(rs.getInt(13));
			bk.setName(rs.getString(14));
			al.add(bk);
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally
	{
		this.close();
	}
	return al;
	}
	/**
	 * 获取图书类型信息
	 * @return
	 */
	public ArrayList getbooktypeInformation()//
	{
	ArrayList al=new ArrayList();
	try
	{
		ct=new bookConnDB().getConn();
		//3.����statement
		sm=ct.createStatement();
		
		//��ѯ����Ҫ��ʾ�ļ�¼
		rs=sm.executeQuery("select id,typename,days from booktype");
		//rs=sm.executeQuery("select top "+pagesize+" from [user] where userID not in (select top "+pagesize*(pageNow-1)+" userID from [user])");

		//��ʼ��װ
		while(rs.next())
		{
			bookBean bk=new bookBean();
			bk.setId(rs.getInt(1));
			bk.setTypename(rs.getString(2));
			bk.setDays(rs.getShort(3));
			al.add(bk);
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally
	{
		this.close();
	}
	return al;
}
	/**
	 * 删除图书类型
	 * @param id
	 * @return
	 */
	public boolean deletebooktype(String id)
	{
		boolean a=false;
		try {
			ct=new bookConnDB().getConn();
			sm=ct.createStatement();
		    int	m=sm.executeUpdate("delete booktype where id='"+id+"'");
			
		    if(m==1)
		    {
		    	a=true;
		    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a;
	}
	
	
	/**
	 * 添加图书类型
	 * @param u
	 * @param typename
	 * @return
	 */
	public  boolean addbooktype(String typename)
	{
		System.out.println(typename);
		boolean a=false;
		try {
			ct=new bookConnDB().getConn();
			sm=ct.createStatement();
			int	m=sm.executeUpdate("insert into booktype (typename,days)values('"+typename+"','30')");
			if(m!=0)
			{
				a=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			this.close();
		}
		return a;
	}
	/**
	 * 添加图书
	 * @param barcode
	 * @param bookname
	 * @param author
	 * @param translate
	 * @param publish
	 * @param price
	 * @param page
	 * @return
	 */
	public  boolean addbookinfo(String barcode,String bookname,String author,String translate,String publish,String price,String page)
	{
		boolean a=false;
		try {
			ct=new bookConnDB().getConn();
			sm=ct.createStatement();
			int	m=sm.executeUpdate("insert into bookinfo (barcode,bookname,author,translator,ISBN,price,page)values('"+barcode+"','"+bookname+"','"+author+"','"+translate+"','"+publish+"','"+price+"','"+page+"')");
			if(m!=0)
			{
				a=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally
		{
			this.close();
		}
		return a;
	}
	/**
	 * 修改图书
	 * @param id
	 * @param barcode
	 * @param bookname
	 * @param author
	 * @param translate
	 * @param publish
	 * @param price
	 * @param page
	 * @return
	 */
	public boolean updatebookinfo(String id,String barcode,String bookname,String author,String translate,String publish,String price,String page  )
	{
		boolean a=false;
		try {
			ct=new bookConnDB().getConn();
			sm=ct.createStatement();
		    int	m=sm.executeUpdate("update bookinfo set barcode='"+barcode+"',bookname='"+bookname+"',author='"+author+"',translator='"+translate+"',ISBN='"+publish+"',price='"+price+"',page='"+page+"' where id='"+id+"'");
			
		    if(m!=0)
		    {
		    	a=true;
		    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a;
		
	}
	
	public boolean deletebookinfo(String id)
	{
		boolean a=false;
		try {
			ct=new bookConnDB().getConn();
			sm=ct.createStatement();
		    int	m=sm.executeUpdate("delete bookinfo where id='"+id+"'");
			
		    if(m!=0)
		    {
		    	a=true;
		    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a;
	}
	
	/**
	 * 修改图书类型
	 * @param id
	 * @param typename
	 * @return
	 */
	public boolean updatebooktype(String id,String typename)
	{
		boolean a=false;
		try {
			ct=new bookConnDB().getConn();
			sm=ct.createStatement();
		    int	m=sm.executeUpdate("update booktype set typename='"+typename+"',days='30' where id='"+id+"'");
			
		    if(m==1)
		    {
		    	a=true;
		    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a;
		
	}
	/**
	 * 图书借阅查询
	 * @param barcode
	 * @return
	 */
	public ArrayList getbookreturnInformation(String barcode)//
	{
		System.out.println("dao=====>"+barcode);
		ArrayList al=new ArrayList();
		try
		{
			ct=new bookConnDB().getConn();
			
			sm=ct.createStatement();
			
			
			rs=sm.executeQuery("select reader.id,bookinfo.id,bookinfo.barcode,bookinfo.bookname,reader.barcode,reader.name,borrowTime,backtime,ifback from bookinfo,reader,borrow where reader.id = borrow.readerid and bookinfo.barcode like '"+barcode+"%' or bookinfo.bookname like '"+barcode+"%' or reader.barcode like '"+barcode+"%' or reader.name like '"+barcode+"%'");
			//rs=sm.executeQuery("select top "+pagesize+" from [user] where userID not in (select top "+pagesize*(pageNow-1)+" userID from [user])");

			
			while(rs.next())
			{
				
				bookBean rd=new bookBean();
				rd.setId(rs.getInt(1));
				rd.setBookid(rs.getInt(2));
				rd.setBarcode(rs.getString(3));
				rd.setBookname(rs.getString(4));
				rd.setReadBarcode(rs.getString(5));
				rd.setReadName(rs.getString(6));
				rd.setBorrowTime(rs.getDate(7));
				rd.setBackTime(rs.getDate(8));
				rd.setIfback(rs.getInt(9));
				al.add(rd);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			this.close();
		}
		return al;
	}
	
	/**
	 * 图书查询
	 * @param barcode
	 * @return
	 */
	public ArrayList getbookInformation()//
	{
		ArrayList al=new ArrayList();
		try
		{
			ct=new bookConnDB().getConn();
			
			sm=ct.createStatement();
			
			
			rs=sm.executeQuery("select bookinfo.id,bookinfo.id,bookinfo.barcode,bookinfo.bookname,ISBN,name from bookinfo,bookcase where bookinfo.id=bookcase.id  ");
			//rs=sm.executeQuery("select top "+pagesize+" from [user] where userID not in (select top "+pagesize*(pageNow-1)+" userID from [user])");

			
			while(rs.next())
			{
				bookBean rd=new bookBean();
				rd.setId(rs.getInt(1));
				rd.setBookid(rs.getInt(2));
				rd.setBarcode(rs.getString(3));
				rd.setBookname(rs.getString(4));
				rd.setISBN(rs.getString(5));
				rd.setName(rs.getString(6));				
				al.add(rd);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			this.close();
		}
		return al;
	}
	/**
	 * 图书续借
	 * @param readerid
	 * @param bookid
	 * @param newdate
	 * @return
	 */
	public boolean updatedate(String readerid,String bookid,String newdate)
	{
		System.out.println("读者id="+readerid+"书的id="+bookid+"newdate="+newdate);
		boolean a=false;
		try {
			ct=new bookConnDB().getConn();
			sm=ct.createStatement();
		    int	m=sm.executeUpdate("update borrow set backtime='"+newdate+"' where readerid='"+readerid+"' and bookid='"+bookid+"'");
			
		    if(m!=0)
		    {
		    	a=true;
		    	
		    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a;
		
	}
	
	/**
	 * 图书归还
	 * @param readerid
	 * @param bookid
	 * @return
	 */
	public boolean deletebook(String readerid,String bookid)
	{
		System.out.println("readerid="+readerid+"bookid="+bookid);
		boolean a=false;
		try {
			ct=new bookConnDB().getConn();
			sm=ct.createStatement();
		    int	m=sm.executeUpdate("delete borrow where readerid='"+readerid+"' and bookid='"+bookid+"'");
			
		    if(m!=0)
		    {
		    	a=true;
		    }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a;
	}
	
	//�ر���Դ
	public void close()
	{
		
		try {
			if(rs!=null)
			{
			rs.close();
			rs=null;
			}
			if(sm!=null)
			{
				sm.close();
				sm=null;
			}
			if(ct!=null)
			{
				ct.close();
				sm=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
