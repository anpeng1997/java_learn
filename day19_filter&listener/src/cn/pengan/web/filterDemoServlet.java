package cn.pengan.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/filterDemoServlet")
public class filterDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        StringBuilder builder = new StringBuilder();
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        for (String key: parameterMap.keySet()
//             ) {
//            for (String par : parameterMap.get(key)){
//                builder.append(par);
//            }
//        }
        String[] parameterValues = request.getParameterValues("name");
        for (String value : parameterValues) {
            builder.append(value);
        }
        response.getWriter().write(builder.toString());
    }
}
