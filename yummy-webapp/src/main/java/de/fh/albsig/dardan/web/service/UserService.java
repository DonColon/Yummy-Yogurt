package de.fh.albsig.dardan.web.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import de.fh.albsig.dardan.persistence.UserManager;
import de.fh.albsig.dardan.persistence.exception.DatabaseException;
import de.fh.albsig.dardan.persistence.model.Address;
import de.fh.albsig.dardan.persistence.model.User;
import de.fh.albsig.dardan.web.listener.ServiceContext;
import de.fh.albsig.dardan.web.model.UserInfo;


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserService
{

	@Context
	private HttpServletRequest request;


	@GET
	public User fetchUserInfo()
	{
		final HttpSession session = this.request.getSession(false);

		if(session == null)
			throw new NotFoundException();

		final User user = (User) session.getAttribute("user");

		return user;
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void submitUserInfo(@BeanParam final UserInfo userInfo)
	{
		final UserManager manager = new UserManager(ServiceContext.getFactory());

		final Address address = new Address(
			userInfo.getStreetname(), userInfo.getStreetnumber(),
			userInfo.getPostalcode(), userInfo.getCity()
		);

		final User user = new User(
			userInfo.getFirstname(), userInfo.getFamilyname(),
			userInfo.getUsername(), userInfo.getEmail(),
			userInfo.getPassword(), userInfo.getBirthday(),
			address
		);

		manager.save(user);
		manager.close();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void updateUserInfo(@BeanParam final UserInfo userInfo)
	{
		final HttpSession session = this.request.getSession(false);

		if(session == null)
			throw new NotFoundException();

		final UserManager manager = new UserManager(ServiceContext.getFactory());

		final Address address = new Address(
			userInfo.getStreetname(), userInfo.getStreetnumber(),
			userInfo.getPostalcode(), userInfo.getCity()
		);

		final User user = (User) session.getAttribute("user");
		user.setFirstname(userInfo.getFirstname());
		user.setFamilyname(userInfo.getFamilyname());
		user.setUsername(userInfo.getUsername());
		user.setEmail(userInfo.getEmail());
		user.setPassword(userInfo.getPassword());
		user.setAddress(address);

		try {
			manager.update(user);
		} catch (final DatabaseException.NoSuchRow e) {
			throw new NotFoundException(e.getMessage(), e);
		} finally {
			manager.close();
		}
	}

}
