package librarymodel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bookmodel.bookConnDB;

public class libraryBeanCL {
	private Statement sm=null;
	private ResultSet rs=null;
	private Connection ct=null;
	public ArrayList getlibraryallInformation()//
	{
		
		ArrayList al=new ArrayList();
		try
		{
			ct=new bookConnDB().getConn();
			//3.创建statement
			sm=ct.createStatement();
			
			//查询出需要显示的记录
			rs=sm.executeQuery("select * from library");
			//rs=sm.executeQuery("select top "+pagesize+" from [user] where userID not in (select top "+pagesize*(pageNow-1)+" userID from [user])");

			//开始封装
			while(rs.next())
			{
				libraryBean lb=new libraryBean();
				lb.setId(rs.getInt(1));
				lb.setLibraryname(rs.getString(2));
				lb.setCurator(rs.getString(3));
				lb.setTel(rs.getString(4));
				lb.setAddress(rs.getString(5));
				lb.setEmail(rs.getString(6));
				lb.setUrl(rs.getString(7));
				lb.setCreateDate(rs.getString(8));
				lb.setIntroduce(rs.getString(9));
				al.add(lb);
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
	//关闭资源
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
