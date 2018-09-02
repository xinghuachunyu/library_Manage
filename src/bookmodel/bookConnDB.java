package bookmodel;

import java.sql.Connection;
import java.sql.DriverManager;

public class bookConnDB {
	private Connection ct=null;
    public Connection getConn()
    {
    	try
    	{
    		// SQL Server
			
    					// 加载数据库驱动,实例化一个driver对象
    					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
    					
    					// 声明数据库db_database17的URL
    					String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=librarySys";
    					String root="sa";
    					String password="123456";
    					
    				    ct=DriverManager.getConnection(url,root,password);

    					if (ct == null) {
    						System.out.println("无法创建数据库连接");
    					} else {
    						System.out.println("数据源测试成功。");
    						
    					}

    	}catch(Exception e)
    	{
    		e.printStackTrace();
    		System.out.println("数据库连接失败");
    	}
    	finally
    	{
    		
    	}
		return ct;
    }

}
