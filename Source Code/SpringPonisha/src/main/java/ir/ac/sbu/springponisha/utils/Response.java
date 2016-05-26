package ir.ac.sbu.springponisha.utils;

import javax.servlet.http.HttpServletResponse;

public class Response {

    public static void initialize(HttpServletResponse response) {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
    }
}
