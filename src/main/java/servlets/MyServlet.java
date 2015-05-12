package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import servlets.BadDataException ;

@WebServlet("/servlet")

public class MyServlet extends HttpServlet {

    public String getMassage(HttpServletRequest r) throws BadDataException {
        String s = r.getParameter("message");
        int number ;
        //Перевірка даних , якшо фігово , то throw

        if (!s.matches("\\d+")) s="-1" ;
        number = Integer.parseInt(s) ;
        System.out.print(number);
        if (number<1) throw new BadDataException();
        return s ;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    //@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        String message = "" ;
        try {
            message = getMassage(request);
        } catch (BadDataException e) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text");
            try {
                PrintWriter writer = response.getWriter();
                writer.print("It is server ! I have a message :Не вірно введені дані !Спробуйте ще !<br/>");
            } catch (IOException ex) {
                e.getStackTrace() ;
            }
        }
        //some code
        if(!message.equals("")) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text");
            try {
                PrintWriter writer = response.getWriter();
                writer.print("It is server ! I have a message :" + message + "<br/>");
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }
}
