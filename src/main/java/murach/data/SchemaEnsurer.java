package murach.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public final class SchemaEnsurer {
    private SchemaEnsurer() {}

    public static void ensureUsersTable() {
        try (Connection conn = DbUtil.getConnection(); Statement st = conn.createStatement()) {
            // Create table if not exists with minimal columns, then add/align columns idempotently
            st.executeUpdate("CREATE TABLE IF NOT EXISTS public.users (\n" +
                    "    id BIGSERIAL PRIMARY KEY,\n" +
                    "    email VARCHAR(150) UNIQUE NOT NULL\n" +
                    ")");

            st.executeUpdate("ALTER TABLE public.users ADD COLUMN IF NOT EXISTS name VARCHAR(100)");
            st.executeUpdate("ALTER TABLE public.users ADD COLUMN IF NOT EXISTS phone_number VARCHAR(30)");

            // Ensure unique index on email
            st.executeUpdate("CREATE UNIQUE INDEX IF NOT EXISTS users_email_uk ON public.users (email)");
        } catch (SQLException e) {
            // Log to stdout since no logging framework configured
            System.err.println("SchemaEnsurer error: " + e.getMessage());
        }
    }
}
