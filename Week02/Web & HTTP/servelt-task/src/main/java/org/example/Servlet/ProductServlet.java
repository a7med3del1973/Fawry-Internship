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

@WebServlet("/catalog/products")
public class ProductServlet extends HttpServlet {

    public static int counter = 100;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = ProductRepository.getProducts();
        Writer writer = resp.getWriter();
        resp.setContentType("text/html");

        writer.write("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>All Products</title>
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
                </head>
                <body>
                    <div class="container">
                        <div class="nav">
                            <a href="/WebTask_war_exploded/catalog/my-products">My Products</a>
                            <a href="/WebTask_war_exploded/catalog/add-product">Add Product</a>
                        </div>
                        <h1>All Products</h1>
                        """);

        if (products.isEmpty()) {
            writer.write("<p>No products available.</p>");
        } else {
            for (Product product : products) {
                writer.write("<div class=\"product\">");
                writer.write("<h1>Product Name: " + product.getName() + "</h1>");
                writer.write("<h1>Price: $" + product.getPrice() + "</h1>");
                writer.write("<h1>Owner Email: " + product.getOwnerEmail() + "</h1>");
                writer.write("</div>");
            }
        }

        writer.write("""
                    </div>
                </body>
                </html>
                """);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("user");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        Product product = new Product(counter++, name, price, email);
        ProductRepository.addProduct(product);
        resp.sendRedirect("/WebTask_war_exploded/catalog/my-products");
    }
}
