package org.example.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet("/catalog/add-product")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        writer.write(
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "    <title>Add Product</title>\n" +
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
                        "        .product-container {\n" +
                        "            background-color: #ffffff;\n" +
                        "            padding: 20px;\n" +
                        "            border-radius: 8px;\n" +
                        "            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);\n" +
                        "            width: 300px;\n" +
                        "        }\n" +
                        "        h2 {\n" +
                        "            text-align: center;\n" +
                        "            margin-bottom: 20px;\n" +
                        "            color: #333;\n" +
                        "        }\n" +
                        "        input[type=\"text\"],\n" +
                        "        input[type=\"number\"] {\n" +
                        "            width: 100%;\n" +
                        "            padding: 10px;\n" +
                        "            margin: 8px 0;\n" +
                        "            border: 1px solid #ccc;\n" +
                        "            border-radius: 4px;\n" +
                        "            box-sizing: border-box;\n" +
                        "        }\n" +
                        "        button {\n" +
                        "            width: 100%;\n" +
                        "            background-color: #4CAF50;\n" +
                        "            color: white;\n" +
                        "            padding: 10px;\n" +
                        "            border: none;\n" +
                        "            border-radius: 4px;\n" +
                        "            cursor: pointer;\n" +
                        "        }\n" +
                        "        button:hover {\n" +
                        "            background-color: #45a049;\n" +
                        "        }\n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <div class=\"product-container\">\n" +
                        "        <h2>Add Product</h2>\n" +
                        "        <form action=\"products\" method=\"POST\">\n" +
                        "            <label for=\"productName\">Product Name:</label>\n" +
                        "            <input type=\"text\" id=\"name\" name=\"name\" required><br><br>\n" +
                        "\n" +
                        "            <label for=\"price\">Price:</label>\n" +
                        "            <input type=\"number\" id=\"price\" name=\"price\" step=\"0.01\" required><br><br>\n" +
                        "\n" +
                        "            <button type=\"submit\">Add Product</button>\n" +
                        "        </form>\n" +
                        "    </div>\n" +
                        "</body>\n" +
                        "</html>"
        );
    }
}
