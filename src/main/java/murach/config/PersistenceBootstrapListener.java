package murach.config;

import murach.data.JpaUtil;
import murach.data.SchemaEnsurer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PersistenceBootstrapListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Ensure required DB schema exists before JPA usage
        SchemaEnsurer.ensureUsersTable();
        // Trigger JPA EMF creation so Hibernate can apply hbm2ddl action on startup
        JpaUtil.getEntityManagerFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Optionally close EMF if needed
        // Not strictly required; container will clean up on undeploy
    }
}
