package de.fh.albsig.dardan.web.listener;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public final class ServiceContext implements ServletContextListener
{

	private static final String PERSISTENCE_UNIT = "YummyYogurt";
	private static EntityManagerFactory factory;


    @Override
	public void contextInitialized(final ServletContextEvent event)
    {
    	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    }

    @Override
	public void contextDestroyed(final ServletContextEvent event)
    {
    	factory.close();
    }

    public static EntityManagerFactory getFactory()
    {
    	return factory;
    }

}
