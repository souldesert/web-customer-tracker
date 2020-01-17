package ru.voskhod.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // setup connection variables
        final String USER = "springstudent";
        final String PASSWORD = "springstudent";

        final String JDBC_URL =
                "jdbc:mysql://10.216.0.234:3306/web_customer_tracker?useSSL=false&serverTimezone=Europe/Moscow";

        final String DRIVER = "com.mysql.cj.jdbc.Driver";

        // get connection to database
        try {
            PrintWriter out = resp.getWriter();

            Class.forName(DRIVER);

            out.println("Connecting to database: " + JDBC_URL);

            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            out.println("Connection successful!");

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
