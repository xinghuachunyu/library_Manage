package bookservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookmodel.bookBeanCL;
import daysCL.daygoods;

/**
 * Servlet implementation class bookServletCL
 */
@WebServlet("/bookServletCL")
public class bookServletCL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		try {
			if (flag.equals("setbooktype")) {
				ArrayList booktypeal = new bookBeanCL().getbooktypeInformation();
				request.setAttribute("booktypeal", booktypeal);
				request.getRequestDispatcher("booktype.jsp").forward(request, response);
			}
			else if(flag.equals("addbooktype"))
			{
				String booktype=request.getParameter("typename");
				bookBeanCL bbc=new bookBeanCL();
				if(bbc.addbooktype(booktype))
				{
					System.out.println("添加成功");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			else if(flag.equals("updatebooktype"))
			{
				String id=request.getParameter("id");
				String typename=request.getParameter("typename");
				bookBeanCL bbc=new bookBeanCL();
				if(bbc.updatebooktype(id, typename))
				{
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				
			}
			else if(flag.equals("deletbooktype"))
			{
				String id=request.getParameter("id");
				bookBeanCL bbc=new bookBeanCL();
				if(bbc.deletebooktype(id))
				{
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			else if(flag.equals("setbookinfo"))
			{
			
				ArrayList bookinfoal=new bookBeanCL().getbookinfoInformation();
				request.setAttribute("bookinfoal", bookinfoal);
				request.getRequestDispatcher("setbookinfo.jsp").forward(request, response);
			}
			else if(flag.equals("addbook"))
			{
				String barcode=request.getParameter("barcode");
				String bookname=request.getParameter("bookname");
				String author=request.getParameter("author");
				String translate=request.getParameter("translate");
				String publish=request.getParameter("publish");
				String price=request.getParameter("price");				
				String page=request.getParameter("page");
				bookBeanCL bbc=new bookBeanCL();
				if(bbc.addbookinfo(barcode, bookname, author, translate, publish, price, page))
				{
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				
			}
			else if(flag.equals("updatebookinfo"))
			{
				String id=request.getParameter("id");
				String barcode=request.getParameter("barcode");
				String bookname=request.getParameter("bookname");
				String author=request.getParameter("author");
				String translate=request.getParameter("translate");
				String publish=request.getParameter("publish");
				String price=request.getParameter("price");				
				String page=request.getParameter("page");
				bookBeanCL bbc=new bookBeanCL();
				if(bbc.updatebookinfo(id, barcode, bookname, author, translate, publish, price, page))
				{
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			else if(flag.equals("deletbookinfo"))
			{
				String id=request.getParameter("id");
				bookBeanCL bbc=new bookBeanCL();
				if(bbc.deletebookinfo(id))
				{
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			else if (flag.equals("borrowinformation")) {
				String barcode = (String) request.getParameter("barcode");
				ArrayList borrowinformational = new bookBeanCL().getbookreturnInformation(barcode);
				System.out.println(borrowinformational.size());
				request.setAttribute("borrowinformational", borrowinformational);
				request.setAttribute("barcode", barcode);
				request.getRequestDispatcher("selectbookborrow.jsp").forward(request, response);
			}
			else if(flag.equals("borrowcontinue"))
			{
				String barcode = (String) request.getParameter("barcode");
				ArrayList borrowinformational = new bookBeanCL().getbookreturnInformation(barcode);
				System.out.println(borrowinformational.size());
				request.setAttribute("borrowinformational", borrowinformational);
				request.setAttribute("barcode", barcode);
				request.getRequestDispatcher("borrowContine.jsp").forward(request, response);
			}
			else if(flag.equals("changeday"))
			{
				String readerid=request.getParameter("readerid");
				String bookid=request.getParameter("bookid");
				String date=new daygoods().changeDate();
				bookBeanCL bbc=new bookBeanCL();
				
				try {
					if(bbc.updatedate(readerid, bookid, date))
					{
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(flag.equals("backbook"))
			{
				String readerid=request.getParameter("readerid");
				String bookid=request.getParameter("bookid");
				bookBeanCL bbc=new bookBeanCL();
				try {
					if(bbc.deletebook(readerid, bookid))
					{
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
