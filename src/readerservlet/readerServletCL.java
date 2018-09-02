package readerservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookmodel.bookBeanCL;
import readermodel.readerBeanCL;

/**
 * Servlet implementation class readerServletCL
 */
@WebServlet("/readerServletCL")
public class readerServletCL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");
		
		if(type.equals("toJsp")){
			toJsp(request,response);
		}else if(type.equals("toReader")){
			toReader(request,response);
		}
		else if(type.equals("toBorrow"))
		{
			toBorrow(request,response);
		}
		else if(type.equals("toQuit"))
		{
			toQuit(request,response);
		}
	/*	String flag=request.getParameter("flag");
		
		
		try {
			if(flag.equals("readerborrow"))
			{
				
				String barcode=request.getParameter("barcode");
				
				request.getRequestDispatcher("borowbook.jsp").forward(request, response);
			}
			else if(flag.equals("bookborrow"))
			{
				String name=request.getParameter("name");
				ArrayList bookborrowal=new bookBeanCL().getbookInformation(name);
				request.setAttribute("name", name);
				request.setAttribute("bookborrowal", bookborrowal);
				request.getRequestDispatcher("borowbook.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		*/
	}


	private void toQuit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		if(session==null)
		{
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			session.invalidate();
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	private void toBorrow(HttpServletRequest request, HttpServletResponse response) {
		
		String readerID=request.getParameter("readerID");
		String bookID=request.getParameter("bookID");
		String operator=request.getParameter("operator");
		System.out.println(operator);
		readerBeanCL rbc=new readerBeanCL();
		if(rbc.addborrow(readerID, bookID, operator))
		{
			try {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	private void toReader(HttpServletRequest request, HttpServletResponse response) {
		String barcode=request.getParameter("barcode");
		ArrayList readerborrowal=new readerBeanCL().getreaderInformation(barcode);
		ArrayList bookborrowal=new bookBeanCL().getbookInformation();
		request.setAttribute("barcode", barcode);				
		request.setAttribute("readerborrowal", readerborrowal);
		request.setAttribute("bookborrowal", bookborrowal);
		try {
			request.getRequestDispatcher("borowbook.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void toJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("borowbook.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
