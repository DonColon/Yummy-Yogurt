package de.fh.albsig.dardan.web.model;

import javax.ws.rs.FormParam;

public class AddressInfo
{

	@FormParam("streetname")
	private String streetname;

	@FormParam("streetnumber")
	private String streetnumber;

	@FormParam("postalcode")
	private String postalcode;

	@FormParam("city")
	private String city;


	public String getStreetname()
	{
		return this.streetname;
	}

	public String getStreetnumber()
	{
		return this.streetnumber;
	}

	public String getPostalcode()
	{
		return this.postalcode;
	}

	public String getCity()
	{
		return this.city;
	}

}
