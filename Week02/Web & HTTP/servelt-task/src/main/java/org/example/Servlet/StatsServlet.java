package org.example.Servlet;

import org.example.Models.Statistics;
import org.example.Repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet("/catalog/stats")
public class StatsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Statistics statistics = ProductRepository.getStatistics();
        Writer writer = resp.getWriter();
        writer.write("""
                <h1>Statistics</h1>
                <h3>Number of Products:
                """ + statistics.getNumberOfProducts() + """
                </h3>
                <h3>Total Price: $
                """ + statistics.getTotalPrice() + """
                </h3>
                """);
    }
}
