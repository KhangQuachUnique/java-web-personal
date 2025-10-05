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

    // You can move these to environment variables or web.xml context params later.
    private static final String HOST = "db.obuysiigsdqovgdneqbx.supabase.co";
    private static final int PORT = 5432;
    private static final String DATABASE = "postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "kadfwfsfsvs"; // TODO: do not commit plaintext secrets in real projects

    // Full JDBC URL with SSL required (recommended by Supabase)
    private static final String JDBC_URL = String.format(
            "jdbc:postgresql://%s:%d/%s?sslmode=require",
            HOST, PORT, DATABASE
    );

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
}
