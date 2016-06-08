package mysources.com.rishal.dataHandler;

import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysources.com.rishal.valueObjects.ValueVO;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class is responsible for all the processing and parsing of the data
 * coming from the url and settign the same into the request object.
 * 
 * @author Rishal
 *
 */
public class DataFactoryHandler {

	// Variable to hold the USER_AGENT value.
	private final String USER_AGENT = "Mozilla/5.0";

	/**
	 * Method to process the request and the data fetched from the url.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ServletContext context = request.getSession().getServletContext();
		ValueVO resultToSend = null;
		ArrayList<ValueVO> result = processData();
		if (request.getQueryString() == null) {
			resultToSend = (ValueVO) result.get(0);
		} else {
			resultToSend = loadData(result, request, response);
		}

		// int noOfRecords =result.size();

		request.setAttribute("COMPLETE_DATA", result);
		request.setAttribute("APPLICATION_DATA", resultToSend);
		
		// 6context.setAttribute("APPLICATION_DATA", result);
		// System.out.println(context.getAttribute("APPLICATION_DATA"));

	}

	/**
	 * Method will call the connection manager to call the url and get the data.
	 * 
	 * @return ArrayList<ValueVO>
	 */
	public ArrayList<ValueVO> processData() {
		ArrayList<ValueVO> result = null;
		JSONObject dataReterievedFromURL = null;
		try {
			dataReterievedFromURL = connectionManager();

		} catch (IOException e) {
			System.out
					.println("I/O Exception Occured, Please contact your administrator."
							+ e.getMessage());
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println("Exception while parsing JSON object"
					+ e.getMessage());
		}
		if (null != dataReterievedFromURL && !dataReterievedFromURL.equals("")) {
			result = DataProcessor.processData(dataReterievedFromURL);
		}
		return result;
	}

	/**
	 * Method used to establish connection between the application and the url
	 * which is required for downloading the data. It will call the method which
	 * will process the data and set all the values in valueobjects.
	 * 
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */

	public JSONObject connectionManager() throws IOException, ParseException {
		/*
		 * String url =
		 * "http://hackerearth.0x10.info/api/accolite_product?type=json&query=list_product"
		 * ; String urlLikes =
		 * "https://hackerearth.0x10.info/api/accolite_product?type=json&query=api_hits"
		 * ;
		 * 
		 * URL obj = new URL(url); HttpURLConnection con = (HttpURLConnection)
		 * obj.openConnection();
		 * 
		 * // optional default is GET con.setRequestMethod("GET");
		 * 
		 * // add request header con.setRequestProperty("User-Agent",
		 * USER_AGENT); int responseCode = con.getResponseCode(); BufferedReader
		 * in = new BufferedReader(new InputStreamReader(
		 * con.getInputStream())); String inputLine; StringBuffer response = new
		 * StringBuffer();
		 * 
		 * while ((inputLine = in.readLine()) != null) {
		 * response.append(inputLine); } in.close();
		 */
		JSONParser parser = new JSONParser();

		// JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(new FileReader(
				"E://Hackerearth//PropertyGuru//data//product_List.json"));
		return jsonObj;
		// return result;

	}

	/**
	 * This method provide the specific Value object based on the parameter
	 * passed in the request, It will work by taking the query string from the
	 * url and searching it in the complete data set.
	 * 
	 * @param request
	 * @param response
	 * @return ValueVO
	 * @throws ServletException
	 * @throws IOException
	 */
	public ValueVO loadData(ArrayList<ValueVO> res, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// String ratingLable = request.getParameter("name");
		
			if (null!=request.getParameter("rating") && request.getParameter("rating").equals("Rating")) {
			return sortBy(res, request, response);
			} else {
			ArrayList<ValueVO> data = processData();
			String name = URLDecoder.decode((String) request.getQueryString(),
					"UTF-8");

			// ArrayList<ValueVO>
			// data1=(ArrayList<ValueVO>)request.getAttribute("APPLICATION_DATA");
			int index = data.indexOf(name);
			Iterator itr = data.iterator();
			ValueVO a = null;
			while (itr.hasNext()) {
				a = (ValueVO) itr.next();
				if (a.getName().equals(name))
					break;
			}
			// ValueVO temp=data.get(index);
			return a;
		}
	}

	public ValueVO sortBy(ArrayList<ValueVO> res, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		{
			/*
			 * HttpSession session=request.getSession(false); ArrayList<ValueVO>
			 * data=(ArrayList<ValueVO>)session.getAttribute("COMPLETE_DATA");
			 */
			Collections.sort(res, ValueVO.tempRating);
			// session.setAttribute("COMPLETE_DATA",data);
			// request.setAttribute("COMPLETE_DATA",data);
			return res.get(0);

		}
	}

}
