package managerservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookmodel.*;
import managermodel.*;

@WebServlet("/managerServletCL")
public class managerServletCL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String flag=(String)request.getParameter("flag");
		String u=(String)request.getParameter("name");
		String p=(String)request.getParameter("pwd");
		ArrayList al=new bookBeanCL().getbookallInformation();
		System.out.println("al=====>"+al.size());
		request.getSession().setAttribute("al", al);
		managerBeanCL mbc=new managerBeanCL();
		if(flag.equals("login"))
		{
			try {
				if(mbc.checkuser(u, p))
				{
					request.getSession().setAttribute("username",u);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(flag.equals("manageset"))
		{
			try {
				ArrayList al1=new managerBeanCL().getmanagerallInformation();
				request.getSession().setAttribute("al1", al1);
				request.getRequestDispatcher("manageSet.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		else if(flag.equals("addmanager"))
		{
			try {
				String name=(String)request.getParameter("name");
				String passwd=(String)request.getParameter("pwd");
				if(mbc.addmanager(name, passwd))
				{
					request.getRequestDispatcher("manageSet.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(flag.equals("setprivilege"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			ArrayList al2=mbc.getmanagerInformation(id);
			request.setAttribute("al2", al2);
			request.getRequestDispatcher("privilege.jsp").forward(request, response);
		}
		else if(flag.equals("changprivilege"))
		{
			try {
				/*int sysset=0;
				int readerset=0;
				int bookset=0;
				int borrowset=0;
				int sysquery=0;
				int id=Integer.parseInt(request.getParameter("id"));
				String checkbox[]=request.getParameterValues("checkbox1");
				for(int i=0;i<checkbox.length;i++)
				{
				     if(checkbox[i].equals("sysset"))
				     {
				    	 sysset=1;
				     }
				     else if(checkbox[i].equals("readerset"))
				     {
				    	 readerset=1;
				     }
				     else if(checkbox[i].equals("bookset"))
				     {
				    	 bookset=1;
				     }
				     else if(checkbox[i].equals("borrowset"))
				     {
				    	 borrowset=1;
				     }
				     else if(checkbox[i].equals("sysquery"))
				     {
				    	 sysquery=1;
				     }
				}
				if(mbc.updatepriviege(id, sysset, readerset, bookset, borrowset, sysquery))
				{
					request.getRequestDispatcher("manageSet.jsp").forward(request, response);
				}*/
			request.getRequestDispatcher("manageSet.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(flag.equals("delet"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			if(mbc.deletpriviege(id))
			{
				request.getRequestDispatcher("manageSet.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
