package murach.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public final class JpaUtil {
    private static final String PU_NAME = "defaultPU";
    private static EntityManagerFactory emf;

    private JpaUtil() {}

    public static synchronized EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            Map<String, String> overrides = new HashMap<>();
            String dbUrl = System.getenv("DB_URL");
            String dbUser = System.getenv("DB_USER");
            String dbPassword = System.getenv("DB_PASSWORD");
            if (dbUrl != null && !dbUrl.isEmpty()) {
                overrides.put("javax.persistence.jdbc.url", dbUrl);
            }
            if (dbUser != null && !dbUser.isEmpty()) {
                overrides.put("javax.persistence.jdbc.user", dbUser);
            }
            if (dbPassword != null && !dbPassword.isEmpty()) {
                overrides.put("javax.persistence.jdbc.password", dbPassword);
            }
            if (overrides.isEmpty()) {
                emf = Persistence.createEntityManagerFactory(PU_NAME);
            } else {
                emf = Persistence.createEntityManagerFactory(PU_NAME, overrides);
            }
        }
        return emf;
    }

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
