package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/status")
public class SimpleStatusServlet extends HttpServlet {

    // ✅ MUST be public (tests call it directly)
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // ✅ Order matters for Mockito verification
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/plain");

        PrintWriter writer = response.getWriter();
        writer.write("Servlet Alive"); // ✅ exact expected text
        writer.flush();
    }
}
