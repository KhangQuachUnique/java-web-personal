package murach.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.constants.PathConstants;
import murach.models.User;

public class SurveyC6Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        String url;

        switch(action) {
            case "join":
                // forward to ch06_ex2.html
                url = PathConstants.SURVEY_C6_HTML;
                break;
            case "submitSurvey":
                // get parameters from the request
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String heardFrom = request.getParameter("heardFrom");
                String wantsUpdates = request.getParameter("wantsUpdates");
                String contactVia = request.getParameter("contactVia");

                // process paramters
                if (heardFrom == null) {
                    heardFrom = "NA";
                }
                if (wantsUpdates == null) {
                    wantsUpdates = "No";
                }
                else {
                    wantsUpdates = "Yes";
                }
                System.out.println("DEBUG wantsUpdates raw value = " + request.getParameter("wantsUpdates"));
                System.out.println("DEBUG wantsUpdates after processing = " + wantsUpdates);

                // store data in User object
                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setHeardFrom(heardFrom);
                user.setWantsUpdates(wantsUpdates);
                user.setContactVia(contactVia);
                user.setWantsUpdates(wantsUpdates.trim());


                // store User object in request
                request.setAttribute("user", user);

                // forward request to JSP
                url = PathConstants.SURVEY_C6_RESULT_JSP;
                break;
            default:
                // forward to ch06_ex2.html
                url = PathConstants.SURVEY_C6_HTML;
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}