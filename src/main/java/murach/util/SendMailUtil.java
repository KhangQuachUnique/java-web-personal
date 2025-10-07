package murach.util;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Minimal email utility: send a single verification email type.
 */
public class SendMailUtil {
    // TODO: Move these to env/secret in production
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_USER = "bookiecake.vn@gmail.com"; // change to yours
    private static final String SMTP_PASS = "tykr suyr mruc lkpi";      // app password

    private static Session createEmailSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", SMTP_HOST);
        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SMTP_USER, SMTP_PASS);
            }
        });
    }

    public static void sendVerification(String toEmail, String verificationLink) throws MessagingException {
        Session session = createEmailSession();
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(SMTP_USER, "KhangQuach"));
        } catch (java.io.UnsupportedEncodingException e) {
            message.setFrom(new InternetAddress(SMTP_USER));
        }
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject("Xác nhận email");
        String html = "<div style='font-family:sans-serif'>"
                + "<h2>Chào bạn,</h2>"
                + "<p>Nhấn vào nút bên dưới để xác nhận email của bạn:</p>"
                + "<p><a href='" + verificationLink + "' style='background:#2563eb;color:#fff;padding:10px 16px;text-decoration:none;border-radius:6px'>Xác nhận</a></p>"
                + "<p>Nếu bạn không yêu cầu, hãy bỏ qua email này.</p>"
                + "</div>";
        message.setContent(html, "text/html; charset=UTF-8");
        Transport.send(message);
    }
}
