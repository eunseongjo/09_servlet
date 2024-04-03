package com.ohgiraffers.section01.xml;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

public class LifeCycleTestServlet extends HttpServlet {


    private int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;
    public LifeCycleTestServlet(){}

    //서블릿 컨테이너에 의해 호출되며 최초 요청 시에는 init() 이후에 동작하고,
    //두번째 요청부터는 init()호출 없이 바로 service() 호출
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init"+initCount++);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service"+serviceCount++);
    }

    @Override
    public void destroy() {
        System.out.println("destroy"+destroyCount++);
    }
}
