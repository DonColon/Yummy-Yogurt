package de.fh.albsig.dardan.web.model;

import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;

public class UserInfo
{

	@FormParam("firstname")
	private String firstname;

	@FormParam("familyname")
	private String familyname;

	@FormParam("username")
	private String username;

	@FormParam("email")
	private String email;

	@FormParam("password")
	private String password;

	@FormParam("birthdate")
	private String birthday;

	@BeanParam
	private AddressInfo address;


	public String getFirstname()
	{
		return this.firstname;
	}

	public String getFamilyname()
	{
		return this.familyname;
	}

	public String getUsername()
	{
		return this.username;
	}

	public String getEmail()
	{
		return this.email;
	}

	public String getPassword()
	{
		return this.password;
	}

	public String getBirthday()
	{
		return this.birthday;
	}

	public String getStreetname()
	{
		return this.address.getStreetname();
	}

	public String getStreetnumber()
	{
		return this.address.getStreetnumber();
	}

	public String getPostalcode()
	{
		return this.address.getPostalcode();
	}

	public String getCity()
	{
		return this.address.getCity();
	}

}
