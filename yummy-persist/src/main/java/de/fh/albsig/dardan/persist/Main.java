package de.fh.albsig.dardan.persist;

import java.util.List;

import de.fh.albsig.dardan.model.Address;

public class Main 
{

	public static void main(String[] args) 
	{
		AddressManager addressManager = new AddressManager("YummyYogurt");
		
		Address address = new Address("straße", "22", "72729", "Monopoly");
		addressManager.save(address);
		
		List<Address> addressList = addressManager.listAll();
		
		for(Address a : addressList)
			System.out.println(a);
		
		addressManager.close();
	}
	
}
