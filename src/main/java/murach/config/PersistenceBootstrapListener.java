package murach.config;

import murach.data.JpaUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PersistenceBootstrapListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Trigger JPA EMF creation so Hibernate can apply hbm2ddl action on startup
        JpaUtil.getEntityManagerFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Optionally close EMF if needed
        // Not strictly required; container will clean up on undeploy
    }
}
