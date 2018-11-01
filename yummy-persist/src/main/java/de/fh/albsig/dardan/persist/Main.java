package de.fh.albsig.dardan.persist;

import java.util.List;

import de.fh.albsig.dardan.exception.NoSuchRowException;
import de.fh.albsig.dardan.model.Rating;
import de.fh.albsig.dardan.model.Yogurt;

public class Main 
{

	public static void main(String[] args) 
	{
		YogurtManager yogurtManager = new YogurtManager("YummyYogurt");

		try {
			Yogurt yogurt = yogurtManager.findByName("Banana Awesome");
//			System.out.println(yogurt);
			
			List<Rating> ratings = yogurt.getRatings();
			
			for(Rating rating : ratings)
				System.out.println(rating);
			
			yogurtManager.close();
		} catch (NoSuchRowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		List<Yogurt> yogurtList = yogurtManager.listAll();
//		
//		for(Yogurt y : yogurtList)
//			System.out.println(y);
		
//		yogurtManager.close();
	}
	
}
