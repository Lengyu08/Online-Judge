package Match;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Match.Pool;

public class Judge_Result extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        String result = (String) session.getAttribute("result");
        String username = (String)session.getAttribute("loggedInUsername");
        String roomID = (String)session.getAttribute("roomID");

        String Message = new Pool().submitResult(username, result, roomID);
        session.removeAttribute("Error");
        session.setAttribute("Error", Message);

        String nextPage = "/ITEM/2.jsp";

        session.removeAttribute("result");
        session.removeAttribute("roomID");
        response.sendRedirect(nextPage);
    }
}
