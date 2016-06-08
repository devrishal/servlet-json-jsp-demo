package mysources.com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mysources.com.rishal.valueObjects.ValueVO;

/**
 * Servlet implementation class SortByRating
 */
@WebServlet("/SortByRating")
public class SortBy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortBy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		ArrayList<ValueVO> data=(ArrayList<ValueVO>)session.getAttribute("COMPLETE_DATA");
		Collections.sort(data,ValueVO.tempRating);
		session.setAttribute("COMPLETE_DATA",data);
		request.setAttribute("COMPLETE_DATA",data);
		RequestDispatcher reqDispatcher=request.getServletContext().getRequestDispatcher("/index.jsp");
		reqDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
