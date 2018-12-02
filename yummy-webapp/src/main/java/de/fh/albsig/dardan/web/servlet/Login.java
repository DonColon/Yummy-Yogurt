package de.fh.albsig.dardan.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import de.fh.albsig.dardan.persistence.UserManager;
import de.fh.albsig.dardan.persistence.exception.DatabaseException;
import de.fh.albsig.dardan.persistence.model.User;
import de.fh.albsig.dardan.web.listener.ServiceContext;


@WebServlet("/login")
public final class Login extends HttpServlet
{

	private static final long serialVersionUID = -6481645623883105970L;


	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException
	{
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");

		final UserManager manager = new UserManager(ServiceContext.getFactory());

		try {

			final User user = manager.findByUsername(username);

			if(password.equals(user.getPassword())) {

				// get the old session and invalidate
				final HttpSession oldSession = request.getSession(false);

				if(oldSession != null)
					oldSession.invalidate();

				// generate a new session
				final HttpSession newSession = request.getSession(true);
				newSession.setMaxInactiveInterval(10 * 60);
				newSession.setAttribute("user", user);

				response.sendRedirect(request.getContextPath() + "/user/profile.html");

			} else {

				final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/sign-in.html");
				dispatcher.include(request, response);

			}

		} catch (DatabaseException.NoSuchRow | DatabaseException.TooManyRows e) {

			final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/sign-in.html");
			dispatcher.include(request, response);

		} finally {
			manager.close();
		}
	}

}
