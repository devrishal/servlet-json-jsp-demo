package mysources.com.rishal.valueObjects;

import java.util.Comparator;

/**
 * Value objects definitions goes in this class.
 * 
 * @author Rishal
 *
 */
public class ValueVO implements Comparable {
	String name;
	float rating;
	String tags;
	String image;
	String description;
	String link;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public static Comparator<ValueVO> tempRating = new Comparator<ValueVO>() {
		@Override
		public int compare(ValueVO s1, ValueVO s2) {

			Float rating1 = s1.getRating();
			Float rating2 = s2.getRating();

			/* For ascending order */
			return rating1.compareTo(rating2);

			/* For descending order */
			// rollno2-rollno1;
		}
	};

	@Override
	public int compareTo(Object o) {
		return 0;

	}

	/*
	 * public static Comparator<ValueVO> tempLink = new Comparator<ValueVO>() {
	 * 
	 * @Override public int compare(ValueVO s1, ValueVO s2) {
	 * 
	 * Float rating1 = s1.getLikes(); Float rating2 = s2.getRating();
	 * 
	 * For ascending order return rating1.compareTo(rating2);
	 * 
	 * For descending order //rollno2-rollno1; }};
	 */

}
