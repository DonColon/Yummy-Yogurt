package de.fh.albsig.dardan.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.fh.albsig.dardan.exception.NoSuchRowException;
import de.fh.albsig.dardan.listener.StartupListener;
import de.fh.albsig.dardan.model.User;
import de.fh.albsig.dardan.persistence.UserManager;


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserService
{

	@GET
	@Path("/{id}")
	public User fetchUserInfo(@PathParam("id") final int userID)
	{
		final UserManager userManager = new UserManager(StartupListener.getFactory());

		User user = null;

		try {
			user = userManager.findByID(userID);
		} catch (final NoSuchRowException e) {
			System.out.println(e.getMessage());
		}

		return user;
	}

}
