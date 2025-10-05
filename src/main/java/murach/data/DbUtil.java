package murach.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Simple JDBC helper for obtaining a PostgreSQL connection to Supabase.
 *
 * Notes:
 * - Supabase Postgres requires SSL. We set sslmode=require in the JDBC URL.
 * - Consider moving credentials to environment variables in production.
 */
public final class DbUtil {
    static {
        // Ensure the PostgreSQL driver is registered (some containers require explicit load)
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC driver not found on classpath: " + e.getMessage());
        }
    }

    // Environment-driven configuration with safe defaults for dev
    private static final String ENV_DB_URL = getenvOrNull("DB_URL");
    // Defaults point to Supabase connection pooler
    private static final String HOST = getenvOrDefault("DB_HOST", "aws-1-ap-southeast-1.pooler.supabase.com");
    private static final int PORT = Integer.parseInt(getenvOrDefault("DB_PORT", "6543"));
    private static final String DATABASE = getenvOrDefault("DB_NAME", "postgres");
    private static final String USER = getenvOrDefault("DB_USER", "postgres.obuysiigsdqovgdneqbx");
    private static final String PASSWORD = getenvOrDefault("DB_PASSWORD", "kadfwfsfsvs");
    private static final String SSLMODE = getenvOrDefault("DB_SSLMODE", "");

    // Build JDBC URL: prefer DB_URL if provided; else compose from parts
    private static final String JDBC_URL = (ENV_DB_URL != null && !ENV_DB_URL.isEmpty())
            ? ENV_DB_URL
            : String.format("jdbc:postgresql://%s:%d/%s?user=%s&password=%s%s",
                HOST, PORT, DATABASE, USER, PASSWORD,
                (SSLMODE != null && !SSLMODE.isEmpty()) ? ("&sslmode=" + SSLMODE) : "");

    private DbUtil() {}

    /**
     * Get a new JDBC connection. Caller is responsible for closing it.
     */
    public static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);
        // Optional performance/compat props
        props.setProperty("ApplicationName", "java-web-personal");
        return DriverManager.getConnection(JDBC_URL, props);
    }

    // Minimal smoke test runnable from a main method if needed locally
    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            System.out.println("Connected to Supabase as: " + conn.getMetaData().getUserName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getenvOrNull(String k) { return System.getenv(k); }
    private static String getenvOrDefault(String k, String d) {
        String v = System.getenv(k);
        return (v == null || v.isEmpty()) ? d : v;
    }
}
