package readermodel;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bookmodel.bookBean;
import bookmodel.bookConnDB;

public class readerBeanCL {
	private Statement sm=null;
	private ResultSet rs=null;
	private Connection ct=null;
	/**
	 * ��ѯ���߽�����Ϣ
	 * @param barcode������������
	 * @return
	 */
	public ArrayList getreaderInformation(String barcode)//
	{
		System.out.println(barcode);
		ArrayList al=new ArrayList();
		try
		{
			ct=new bookConnDB().getConn();
			//3.����statement
			sm=ct.createStatement();
			
			//��ѯ����Ҫ��ʾ�ļ�¼
			rs=sm.executeQuery("select reader.id,name,sex,reader.barcode, vocation,birthday,paperType,paperNo,tel,email,createDate,reader.operator,remark,reader.typeid,bookid,bookname,borrow.borrowTime,backtime,ISBN,price from reader,borrow,bookinfo where reader.id=borrow.readerid and borrow.bookid=bookinfo.id  and reader.barcode='"+barcode+"'");
			//rs=sm.executeQuery("select top "+pagesize+" from [user] where userID not in (select top "+pagesize*(pageNow-1)+" userID from [user])");

			//��ʼ��װ
			while(rs.next())
			{
				readerBean rb=new readerBean();
				rb.setId(rs.getInt(1));
				rb.setName(rs.getString(2));
				rb.setSex(rs.getString(3));
				rb.setBarcode(rs.getString(3));
				rb.setVocation(rs.getString(4));
				rb.setBirthday(rs.getString(5));
				rb.setPaperType(rs.getString(6));
				rb.setPaperNO(rs.getString(7));
				rb.setTel(rs.getString(8));
				rb.setEmail(rs.getString(9));
				rb.setCreateDate(rs.getString(10));
				rb.setOperator(rs.getString(11));
				rb.setRemark(rs.getString(12));
				rb.setTypeid(rs.getInt(13));
				rb.setBookid(rs.getInt(14));
				rb.setBookname(rs.getString(15));
				rb.setBorrowTime(rs.getString(16));
				rb.setBacktime(rs.getString(17));
				rb.setISBN(rs.getString(18));
				rb.setPrice(rs.getString(19));
				al.add(rb);				
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
	 * 
	 * @param u
	 * @param p
	 * @return
	 */
	public  boolean addborrow(String readerid,String bookid,String operator)
	{
		boolean a=false;
		try {
			ct=new bookConnDB().getConn();
			sm=ct.createStatement();
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();
			int	m=sm.executeUpdate("insert into borrow(readerid,bookid,borrowTime,backtime,operator,ifback)values('"+readerid+"','"+bookid+"','"+df.format(new Date(date.getTime()))+"','"+df.format(new Date(date.getTime()+(long)30*24*60*60*1000))+"','"+operator+"','0')");
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
