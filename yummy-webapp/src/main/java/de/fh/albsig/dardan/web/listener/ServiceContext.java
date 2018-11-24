package de.fh.albsig.dardan.web.listener;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.PropertyConfigurator;


@WebListener
public final class ServiceContext implements ServletContextListener
{

	private static final String PERSISTENCE_UNIT = "YummyYogurt";

	private static EntityManagerFactory factory;


    @Override
	public void contextInitialized(final ServletContextEvent event)
    {
    	final ServletContext context = event.getServletContext();

    	final String loggerConfigFile = context.getInitParameter("log4j-config-location");

    	final Path loggerConfigPath = Paths.get(context.getRealPath("/"), loggerConfigFile);

    	PropertyConfigurator.configure(loggerConfigPath.toString());

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
