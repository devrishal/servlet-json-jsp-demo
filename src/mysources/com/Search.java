package mysources.com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mysources.com.rishal.dataHandler.DataProcessor;
import mysources.com.rishal.valueObjects.ValueVO;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String textToSearch = request.getParameter("textToSearch");
		HttpSession session=request.getSession(false);
		ArrayList<ValueVO> data=(ArrayList<ValueVO>)session.getAttribute("COMPLETE_DATA");
	    DataProcessor dp=new DataProcessor();
	    ArrayList<ValueVO> rs=(ArrayList<ValueVO>)dp.searchByTags(data,textToSearch);
		response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write("Result: "+rs.size()+" items found.");       // Write response body.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String textToSearch = request.getParameter("somebutton");
		HttpSession session=request.getSession(false);
		ArrayList<ValueVO> data=(ArrayList<ValueVO>)session.getAttribute("COMPLETE_DATA");
	    DataProcessor dp=new DataProcessor();
	    ArrayList<ValueVO> rs=(ArrayList<ValueVO>)dp.searchByTags(data,textToSearch);
		response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write(textToSearch);       // Write response body.
	}

}
