package com.servlet;

import java.io.*;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;

import com.dao.HostelDAO;
import com.model.student;

@WebServlet("/addStudent")   // ✅ IMPORTANT (Fix 404)
public class AddStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            // ✅ Correct class name (Student not student)
            student s = new student();

            // ✅ Get parameters safely
            s.setStudentID(Integer.parseInt(req.getParameter("id")));
            s.setStudentName(req.getParameter("name"));
            s.setRoomNumber(req.getParameter("room"));
            s.setAdmissionDate(Date.valueOf(req.getParameter("date")));
            s.setFeesPaid(Double.parseDouble(req.getParameter("paid")));
            s.setPendingFees(Double.parseDouble(req.getParameter("pending")));

            // ✅ DAO Call
            HostelDAO dao = new HostelDAO();
            dao.addStudent(s);

            // ✅ FIX: correct redirect URL
            res.sendRedirect("displayStudents");  

        } catch (Exception e) {
            e.printStackTrace();

            // Optional: show error on browser
            res.getWriter().println("Error: " + e.getMessage());
        }
    }
}