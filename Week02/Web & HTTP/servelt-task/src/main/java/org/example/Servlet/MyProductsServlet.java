package org.example.Servlet;

import org.example.Models.Product;
import org.example.Repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet("/catalog/my-products")
public class MyProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("user");
        List<Product> myProducts = ProductRepository.getUserProducts(email);
        Writer writer = resp.getWriter();
        resp.setContentType("text/html");

        writer.write("<!DOCTYPE html>");
        writer.write("<html lang=\"en\">");
        writer.write("<head>");
        writer.write("<meta charset=\"UTF-8\">");
        writer.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        writer.write("<title>My Products</title>");
        writer.write("""
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f9f9f9;
                        margin: 0;
                        padding: 0;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        flex-direction: column;
                        min-height: 100vh;
                    }
                    .container {
                        background-color: #fff;
                        padding: 20px;
                        border-radius: 8px;
                        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                        width: 80%;
                        max-width: 800px;
                    }
                    h1 {
                        color: #333;
                    }
                    .product {
                        margin-bottom: 20px;
                        padding: 10px;
                        border-bottom: 1px solid #ddd;
                    }
                    .product h1 {
                        font-size: 18px;
                        color: #555;
                    }
                    a {
                        text-decoration: none;
                        color: #4CAF50;
                        margin-right: 15px;
                        font-weight: bold;
                    }
                    a:hover {
                        text-decoration: underline;
                    }
                    .nav {
                        margin-bottom: 20px;
                    }
                </style>
                """);
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<div class=\"container\">");
        writer.write("<div class=\"nav\">");
        writer.write("<a href=\"/WebTask_war_exploded/catalog/products\">All Products</a>");
        writer.write("<a href=\"/WebTask_war_exploded/catalog/add-product\">Add Product</a>");
        writer.write("</div>");
        writer.write("<h1>Hello " + email + ", Your Products 👇</h1>");

        if (myProducts.isEmpty()) {
            writer.write("<p>No products available.</p>");
        } else {
            for (Product product : myProducts) {
                writer.write("<div class=\"product\">");
                writer.write("<h1>Name: " + product.getName() + "</h1>");
                writer.write("<h1>Price: $" + product.getPrice() + "</h1>");
                writer.write("</div>");
            }
        }

        writer.write("</div>");
        writer.write("</body>");
        writer.write("</html>");
    }
}
