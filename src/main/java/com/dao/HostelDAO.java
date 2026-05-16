package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.model.student;

public class HostelDAO {

    private String url = "jdbc:mysql://localhost:3306/HostelDB?useSSL=false&serverTimezone=UTC";
    private String user = "root";
    private String password = "root";

    // ✅ Load Driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // ✅ Get Connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // ✅ ADD STUDENT
    public void addStudent(student s) {
        String query = "INSERT INTO HostelStudents VALUES (?,?,?,?,?,?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, s.getStudentID());
            ps.setString(2, s.getStudentName());
            ps.setString(3, s.getRoomNumber());
            ps.setDate(4, new java.sql.Date(s.getAdmissionDate().getTime())); // 🔥 FIX
            ps.setDouble(5, s.getFeesPaid());
            ps.setDouble(6, s.getPendingFees());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ GET ALL STUDENTS
    public List<student> getAllStudents() {
        List<student> list = new ArrayList<>();

        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM HostelStudents")) {

            while (rs.next()) {
                student s = new student();

                s.setStudentID(rs.getInt("StudentID"));
                s.setStudentName(rs.getString("StudentName"));
                s.setRoomNumber(rs.getString("RoomNumber"));
                s.setAdmissionDate(rs.getDate("AdmissionDate"));
                s.setFeesPaid(rs.getDouble("FeesPaid"));
                s.setPendingFees(rs.getDouble("PendingFees"));

                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // ✅ DELETE STUDENT
    public void deleteStudent(int id) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "DELETE FROM HostelStudents WHERE StudentID=?")) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ UPDATE STUDENT
    public void updateStudent(student s) {
        String query = "UPDATE HostelStudents SET StudentName=?, RoomNumber=?, AdmissionDate=?, FeesPaid=?, PendingFees=? WHERE StudentID=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, s.getStudentName());
            ps.setString(2, s.getRoomNumber());
            ps.setDate(3, new java.sql.Date(s.getAdmissionDate().getTime())); // 🔥 FIX
            ps.setDouble(4, s.getFeesPaid());
            ps.setDouble(5, s.getPendingFees());
            ps.setInt(6, s.getStudentID());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}