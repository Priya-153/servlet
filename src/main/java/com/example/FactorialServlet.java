package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/factorial")
public class FactorialServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int num = Integer.parseInt(request.getParameter("num"));

            long factorial = 1;

            for (int i = 1; i <= num; i++) {
                factorial *= i;
            }

            out.println("<html><body>");
            out.println("<h2>Factorial Result</h2>");
            out.println("<p>Number: " + num + "</p>");
            out.println("<p>Factorial: " + factorial + "</p>");
            out.println("<a href='factorial.html'>Back</a>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            out.println("<h3>Invalid Input! Please enter a valid number.</h3>");
        }
    }
}