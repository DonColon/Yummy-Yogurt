package de.fh.albsig.dardan.web.service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

	@GET
	@Path("/{username}")
	public User fetchUserInfo(@PathParam("username") final String username)
	{
		final UserManager manager = new UserManager(ServiceContext.getFactory());
		User user = new User();

		try {
			user = manager.findByUsername(username);

		} catch (final DatabaseException.NoSuchRow e) {
			throw new NotFoundException();

		} catch (final DatabaseException.TooManyRows e) {
			throw new BadRequestException();
		}

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

}
