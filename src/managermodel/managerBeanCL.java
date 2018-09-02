package managermodel;

import java.sql.Connection;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import bookmodel.*;

public class managerBeanCL {
	private Statement sm=null;
	private ResultSet rs=null;
	private Connection ct=null;
	
	
	
		public boolean checkuser(String u,String p)
		{
			boolean b=false;
			try
			{
				
				ct=new bookConnDB().getConn();
			
				
				sm=ct.createStatement();

				
				rs=sm.executeQuery("select pwd from manager where name='"+u+"'");
				
				if(rs.next())
				{
					
					if(rs.getString(1).equals(p))
					{
						
						b=true;
					}
					else
					{
						//�������
						b=false;
					}
				}
				else
				{
					//�û�������
					b=false;
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}finally
			{
				//�رո�����Դ		
				this.close();
			}
			return b;
		}
		
		/**
		 * ��ȡ����Ա��Ϣ
		 * @return
		 */
		public ArrayList getmanagerallInformation()//
		{
			
			ArrayList al=new ArrayList();
			try
			{
				ct=new bookConnDB().getConn();
				//3.����statement
				sm=ct.createStatement();
				
				//��ѯ����Ҫ��ʾ�ļ�¼
				rs=sm.executeQuery("select manager.id,name,sysset,readerset,bookset,borrowback,sysquery from manager,purview where manager.id=purview.id");
				//rs=sm.executeQuery("select top "+pagesize+" from [user] where userID not in (select top "+pagesize*(pageNow-1)+" userID from [user])");

				//��ʼ��װ
				while(rs.next())
				{
					managerBean mb=new managerBean();
					mb.setId(rs.getInt(1));
					mb.setName(rs.getString(2));
					mb.setSysset(rs.getInt(3));
					mb.setReaderset(rs.getInt(4));
					mb.setBookset(rs.getInt(5));
					mb.setBorrowback(rs.getInt(6));
					mb.setSysquery(rs.getInt(7));
					al.add(mb);
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
		 * ��ӹ���Ա
		 * @param u������Ա����
		 * @param p������Ա����
		 * @return
		 */
		public  boolean addmanager(String u,String p)
		{
			boolean a=false;
			try {
				ct=new bookConnDB().getConn();
				sm=ct.createStatement();
				int	m=sm.executeUpdate("insert into manager(name,pwd)values('"+u+"','"+p+"')");
				if(m==1)
				{
					a=true;
					System.out.println("����ɹ�");
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
		 * Ȩ�޹���
		 * @param id
		 * @param sysset
		 * @param readerset
		 * @param bookset
		 * @param borrowback
		 * @param sysquery
		 * @return
		 */
		public boolean updatepriviege(int id,int sysset,int readerset,int bookset,int borrowback,int sysquery)
		{
			boolean a=false;
			try {
				ct=new bookConnDB().getConn();
				sm=ct.createStatement();
			    int	m=sm.executeUpdate("update  purview set sysset='"+sysset+"',readerser='"+readerset+"',bookset='"+bookset+"',borrowback='"+borrowback+"',sysquery='"+sysquery+"' where id='"+id+"'");
				
			    if(m==1)
			    {
			    	a=true;
			    	System.out.println("�޸ĳɹ�");
			    }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return a;
			
		}
		public boolean deletpriviege(int id)
		{
			boolean a=false;
			try {
				ct=new bookConnDB().getConn();
				sm=ct.createStatement();
			    int	m=sm.executeUpdate("delete purview where id='"+id+"'");
				
			    if(m==1)
			    {
			    	a=true;
			    	System.out.println("�޸ĳɹ�");
			    }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return a;
			
		}
		public ArrayList getmanagerInformation(int id)//
		{
			
			ArrayList al=new ArrayList();
			try
			{
				ct=new bookConnDB().getConn();
				//3.����statement
				sm=ct.createStatement();
				
				//��ѯ����Ҫ��ʾ�ļ�¼
				rs=sm.executeQuery("select manager.id,name,sysset,readerset,bookset,borrowback,sysquery from manager,purview where manager.id=purview.id and purview.id='"+id+"'");
				//rs=sm.executeQuery("select top "+pagesize+" from [user] where userID not in (select top "+pagesize*(pageNow-1)+" userID from [user])");

				//��ʼ��װ
				while(rs.next())
				{
					managerBean mb=new managerBean();
					mb.setId(rs.getInt(1));
					mb.setName(rs.getString(2));
					mb.setSysset(rs.getInt(3));
					mb.setReaderset(rs.getInt(4));
					mb.setBookset(rs.getInt(5));
					mb.setBorrowback(rs.getInt(6));
					mb.setSysquery(rs.getInt(7));
					al.add(mb);
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
