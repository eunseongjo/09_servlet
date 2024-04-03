package com.ohgiraffers.section02.delete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Enumeration<String> sessionNames = session.getAttributeNames();
        while(sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());
        }

        /* 세션의 데이터를 지우는 방버은 여러가지가 있다.
        * 1. 설정한 만료시간이 지나면 세션이 만료된다.
        * 2. removeAttribute()로 session의 Attribute를 지운다.
        * 3. invalidate()를 호출하면 세션의 모든 데이터가 제거된다.*/

        /* invalidate를 호출하면 세션 자체를 무효화 했기 때문에 이후 세션을 이용하는 것은 에러가 발생한다.
        * 즉, 세션 내의 데이터를 지우는 것 뿐 아니라 세션을 강제로 만료시켰다고 볼 수 있다.*/
        session.removeAttribute("firstName");
        sessionNames = session.getAttributeNames();
        while(sessionNames.hasMoreElements()){
            System.out.println("remain : " + sessionNames.nextElement());
        }
    }
}
