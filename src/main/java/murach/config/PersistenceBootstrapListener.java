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
        // Avoid failing app startup if DB is unreachable in deploy environment.
        // By default, do not touch the DB at startup. Enable via env DB_BOOTSTRAP=true if desired.
        String bootstrap = System.getenv("DB_BOOTSTRAP");
        boolean doBootstrap = bootstrap != null && bootstrap.equalsIgnoreCase("true");
        if (doBootstrap) {
            try {
                SchemaEnsurer.ensureUsersTable();
            } catch (Exception e) {
                System.err.println("[Bootstrap] Schema ensure failed: " + e.getMessage());
            }
            try {
                JpaUtil.getEntityManagerFactory();
            } catch (Exception e) {
                System.err.println("[Bootstrap] JPA init failed: " + e.getMessage());
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Optionally close EMF if needed
        // Not strictly required; container will clean up on undeploy
    }
}
