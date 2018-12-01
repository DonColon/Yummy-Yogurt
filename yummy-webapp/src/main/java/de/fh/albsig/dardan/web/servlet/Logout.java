package de.fh.albsig.dardan.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/user/logout")
public final class Logout extends HttpServlet
{

	private static final long serialVersionUID = -6908036497142045204L;


	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException
	{
		final HttpSession session = request.getSession(false);

		if(session != null)
			session.invalidate();

		response.sendRedirect(request.getContextPath() + "/sign-in.html");
	}

}
