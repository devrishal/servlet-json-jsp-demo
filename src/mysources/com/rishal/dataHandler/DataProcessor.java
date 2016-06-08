package mysources.com.rishal.dataHandler;

import java.util.ArrayList;
import java.util.Iterator;

import mysources.com.rishal.valueObjects.ValueVO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/*
 * This class will parse JSON Object and set the data into value objects 
 */
public class DataProcessor {
	/*
	 * method will do the parsing of JSON object and set the values respectively
	 * to each field in the value objects, ArrayList will be returned from the
	 * method which will have all the data in form of JSON.
	 * 
	 * @param jsonObject
	 */
	public static ArrayList<ValueVO> processData(JSONObject jsonObject) {
		JSONArray jsonArrayMenu = (JSONArray) jsonObject.get("menu");
		System.out.println("jsonArray" + jsonArrayMenu);
		ArrayList<ValueVO> result = new ArrayList<ValueVO>();
		for (int i = 0; i < jsonArrayMenu.size(); i++) {
			ValueVO valueVo = new ValueVO();
			JSONObject data = (JSONObject) jsonArrayMenu.get(i);
			String name = (String) data.get("name");
			valueVo.setName(name);

			Float rating = Float.parseFloat((String) data.get("rating"));
			valueVo.setRating(rating);

			JSONArray tagsTemp = (JSONArray) data.get("tags");
			String tags = "";
			for (int j = 0; j < tagsTemp.size(); j++) {
				tags += (String) tagsTemp.get(j)+",";
			}
			//System.out.println("++++++++++++++++"+tags);
			valueVo.setTags(tags.substring(0, tags.length()-1));

			String image = (String) data.get("image");
			System.out.println("+++++++++"+image);
			valueVo.setImage(image);

			String description = (String) data.get("description");
			valueVo.setDescription(description);

			String link = (String) data.get("link");
			//System.out.println("++++++++++++"+link);
			valueVo.setLink(link);

			result.add(valueVo);
		}

		return result;
	}
	
	public ArrayList<ValueVO> searchByTags(ArrayList<ValueVO> data,String textToSearch)
	{
		Iterator itr=data.iterator();
		int counter=0;
		ArrayList<ValueVO> result=new ArrayList<ValueVO>();
		while(itr.hasNext())
		{
			ValueVO vo=(ValueVO)itr.next();
			if(vo.getTags().contains(textToSearch))
			{
				counter++;
				result.add(vo);
			}
		}
		return result;
	}

}
