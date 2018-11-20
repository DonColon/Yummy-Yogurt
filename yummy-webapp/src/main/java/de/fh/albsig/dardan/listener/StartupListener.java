package de.fh.albsig.dardan.listener;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public final class StartupListener implements ServletContextListener
{

	private static EntityManagerFactory factory;


    @Override
	public void contextDestroyed(final ServletContextEvent event)
    {
    	factory = Persistence.createEntityManagerFactory("YummyYogurt");
    }

    @Override
	public void contextInitialized(final ServletContextEvent event)
    {
    	factory.close();
    }

    public static EntityManagerFactory getFactory()
    {
    	return factory;
    }

}
