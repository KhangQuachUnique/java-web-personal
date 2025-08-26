package murach.constants;

public class PathConstants {

    private PathConstants() {} // private constructor để tránh tạo instance

    // URL paths cho servlet mapping
    public static final String HOME = "/home";
    public static final String JOIN = "/join";
    public static final String THANKS = "/thanks";

    // JSP page paths
    public static final String JOIN_FORM_JSP = "/pages/joinForm.jsp";
    public static final String THANKS_JSP = "/pages/thanks.jsp";
    public static final String SURVEY_JSP = "/pages/survey.jsp";
}
