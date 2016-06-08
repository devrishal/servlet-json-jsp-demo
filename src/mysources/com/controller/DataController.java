package mysources.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mysources.com.rishal.dataHandler.DataFactoryHandler;

/**
 * Servlet implementation class DataController
 */
@WebServlet("/DataController")
public class DataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DataFactoryHandler data=new DataFactoryHandler();
		
		HttpSession session = request.getSession(false);
		if(session==null)
		{
			session = request.getSession(true);
			data.processRequest(request,response);
			session.setAttribute("COMPLETE_DATA", request.getAttribute("COMPLETE_DATA"));
			session.setAttribute("APPLICATION_DATA", request.getAttribute("APPLICATION_DATA"));	
		
		}
		else
		{
			String param=request.getQueryString();
			String ratingLable = request.getParameter("rating");
			// request.getParameter("rating");
			data.processRequest(request,response);
			if(null!=ratingLable && !ratingLable.equals("Rating"))
			{
				request.setAttribute("COMPLETE_DATA",session.getAttribute("COMPLETE_DATA"));
				request.setAttribute("APPLICATION_DATA",session.getAttribute("APPLICATION_DATA"));
			}
			else if(null!=param)
			{
				request.setAttribute("COMPLETE_DATA",session.getAttribute("COMPLETE_DATA"));
				request.setAttribute("APPLICATION_DATA",session.getAttribute("APPLICATION_DATA"));
			}
			
			
		}
		RequestDispatcher reqDispatcher=request.getRequestDispatcher("/index.jsp");
		reqDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
