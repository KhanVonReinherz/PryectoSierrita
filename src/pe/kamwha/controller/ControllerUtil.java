
package pe.kamwha.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ControllerUtil {

    private ControllerUtil() {
    }
    
    public static void forward(HttpServletRequest request, HttpServletResponse response, String destino) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }
    
    public static void sessionPut(HttpServletRequest request, String key, Object value){
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
    }
    
    public static Object sessionGet(HttpServletRequest request, String key){
        HttpSession session = request.getSession();
        
        return session.getAttribute(key);
    }
}
