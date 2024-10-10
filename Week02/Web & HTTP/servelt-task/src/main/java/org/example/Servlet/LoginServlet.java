package org.example.Servlet;

import org.example.Repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        writer.write(
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "    <title>Login</title>\n" +
                        "    <style>\n" +
                        "        body {\n" +
                        "            font-family: Arial, sans-serif;\n" +
                        "            background-color: #f0f0f0;\n" +
                        "            margin: 0;\n" +
                        "            padding: 0;\n" +
                        "            display: flex;\n" +
                        "            justify-content: center;\n" +
                        "            align-items: center;\n" +
                        "            height: 100vh;\n" +
                        "        }\n" +
                        "        .login-container {\n" +
                        "            background-color: #ffffff;\n" +
                        "            padding: 20px;\n" +
                        "            border-radius: 8px;\n" +
                        "            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);\n" +
                        "            width: 300px;\n" +
                        "        }\n" +
                        "        h1 {\n" +
                        "            text-align: center;\n" +
                        "            margin-bottom: 20px;\n" +
                        "            color: #333;\n" +
                        "        }\n" +
                        "        input[type=\"text\"],\n" +
                        "        input[type=\"password\"] {\n" +
                        "            width: 100%;\n" +
                        "            padding: 10px;\n" +
                        "            margin: 8px 0;\n" +
                        "            border: 1px solid #ccc;\n" +
                        "            border-radius: 4px;\n" +
                        "            box-sizing: border-box;\n" +
                        "        }\n" +
                        "        input[type=\"submit\"] {\n" +
                        "            width: 100%;\n" +
                        "            background-color: #4CAF50;\n" +
                        "            color: white;\n" +
                        "            padding: 10px;\n" +
                        "            border: none;\n" +
                        "            border-radius: 4px;\n" +
                        "            cursor: pointer;\n" +
                        "        }\n" +
                        "        input[type=\"submit\"]:hover {\n" +
                        "            background-color: #45a049;\n" +
                        "        }\n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <div class=\"login-container\">\n" +
                        "        <h1>Login</h1>\n" +
                        "        <form action=\"login\" method=\"post\">\n" +
                        "            <label for=\"email\">Email:</label>\n" +
                        "            <input type=\"text\" name=\"email\" id=\"email\" required><br>\n" +
                        "            <label for=\"password\">Password:</label>\n" +
                        "            <input type=\"password\" name=\"password\" id=\"password\" required><br>\n" +
                        "            <input type=\"submit\" value=\"Login\">\n" +
                        "        </form>\n" +
                        "    </div>\n" +
                        "</body>\n" +
                        "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        boolean isAuthenticated = UserRepository.isAuthenticated(email, password);

        if (isAuthenticated) {
            HttpSession session = req.getSession();
            session.setAttribute("user", email);
            resp.sendRedirect("catalog/products");
        } else {
            Writer writer = resp.getWriter();
            writer.write(
                    "<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                            "    <title>Login</title>\n" +
                            "    <style>\n" +
                            "        body {\n" +
                            "            font-family: Arial, sans-serif;\n" +
                            "            background-color: #f0f0f0;\n" +
                            "            margin: 0;\n" +
                            "            padding: 0;\n" +
                            "            display: flex;\n" +
                            "            justify-content: center;\n" +
                            "            align-items: center;\n" +
                            "            height: 100vh;\n" +
                            "        }\n" +
                            "        .login-container {\n" +
                            "            background-color: #ffffff;\n" +
                            "            padding: 20px;\n" +
                            "            border-radius: 8px;\n" +
                            "            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);\n" +
                            "            width: 300px;\n" +
                            "        }\n" +
                            "        h1 {\n" +
                            "            text-align: center;\n" +
                            "            margin-bottom: 20px;\n" +
                            "            color: #333;\n" +
                            "        }\n" +
                            "        .error {\n" +
                            "            color: red;\n" +
                            "            text-align: center;\n" +
                            "            margin-bottom: 10px;\n" +
                            "        }\n" +
                            "        input[type=\"text\"],\n" +
                            "        input[type=\"password\"] {\n" +
                            "            width: 100%;\n" +
                            "            padding: 10px;\n" +
                            "            margin: 8px 0;\n" +
                            "            border: 1px solid #ccc;\n" +
                            "            border-radius: 4px;\n" +
                            "            box-sizing: border-box;\n" +
                            "        }\n" +
                            "        input[type=\"submit\"] {\n" +
                            "            width: 100%;\n" +
                            "            background-color: #4CAF50;\n" +
                            "            color: white;\n" +
                            "            padding: 10px;\n" +
                            "            border: none;\n" +
                            "            border-radius: 4px;\n" +
                            "            cursor: pointer;\n" +
                            "        }\n" +
                            "        input[type=\"submit\"]:hover {\n" +
                            "            background-color: #45a049;\n" +
                            "        }\n" +
                            "    </style>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "    <div class=\"login-container\">\n" +
                            "        <h1>Login</h1>\n" +
                            "        <p class=\"error\">Email or Password is incorrect</p>\n" +
                            "        <form action=\"login\" method=\"post\">\n" +
                            "            <label for=\"email\">Email:</label>\n" +
                            "            <input type=\"text\" name=\"email\" id=\"email\" value=\"" + email + "\" required><br>\n" +
                            "            <label for=\"password\">Password:</label>\n" +
                            "            <input type=\"password\" name=\"password\" id=\"password\" required><br>\n" +
                            "            <input type=\"submit\" value=\"Login\">\n" +
                            "        </form>\n" +
                            "    </div>\n" +
                            "</body>\n" +
                            "</html>"
            );
        }
    }
}
