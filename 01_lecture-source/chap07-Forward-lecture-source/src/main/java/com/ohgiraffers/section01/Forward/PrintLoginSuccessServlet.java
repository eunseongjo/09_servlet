package com.ohgiraffers.section01.Forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userId = req.getParameter("userId");
//        String password = req.getParameter("password");
//
//        System.out.println("print userId = " + userId);
//        System.out.println("print password = " + password);

        String userId = (String) req.getAttribute("userId");

        System.out.println("print servlet userId : " + userId);

        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h3 align=\"center\">")
                .append(userId)
                .append("님 환영합니다.</h3")
                .append("</body>\n")
                .append("</html>\n");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print(responseText.toString());

        out.flush();
        out.close();

    }
}
