package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.dao.HostelDAO;
import com.model.student;

public class DisplayStudentsServlet  extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            HostelDAO dao = new HostelDAO();

            List<student> list = dao.getAllStudents();

            req.setAttribute("students", list);

            RequestDispatcher rd = req.getRequestDispatcher("studentdisplay.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}