package de.fh.albsig.dardan.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import de.fh.albsig.dardan.persistence.YogurtManager;
import de.fh.albsig.dardan.persistence.model.User;
import de.fh.albsig.dardan.persistence.model.Yogurt;
import de.fh.albsig.dardan.web.listener.ServiceContext;


@Path("/yogurts")
@Produces(MediaType.APPLICATION_JSON)
public class YogurtService
{

	@Context
	private HttpServletRequest request;


	@GET
	public List<Yogurt> fetchYogurtsOfUser()
	{
		final HttpSession session = this.request.getSession(false);

		if(session == null)
			throw new NotFoundException();

		final User user = (User) session.getAttribute("user");

		final YogurtManager manager = new YogurtManager(ServiceContext.getFactory());

		final List<Yogurt> yogurts = manager.listByOwner(user.getUsername());

		return yogurts;
	}

}
