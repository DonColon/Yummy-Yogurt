package de.fh.albsig.dardan.persistence;

import java.util.List;

import de.fh.albsig.dardan.model.Yogurt;


public class Main
{

	public static void main(final String[] args)
	{
		final YogurtManager yogurtManager = new YogurtManager("YummyYogurt");

		final List<Yogurt> yogurtList = yogurtManager.listAll();

		for(final Yogurt y : yogurtList)
			System.out.println(y);

		yogurtManager.close();
	}

}
