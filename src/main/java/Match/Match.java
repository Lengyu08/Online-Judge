package Match;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Match.Pool;

public class Match extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        String nextPage = "/ITEM/2.jsp";

        String loggedInUsername = (String) session.getAttribute("loggedInUsername");
        if (loggedInUsername == null || loggedInUsername.isEmpty()) {
            session.setAttribute("Error", "Please_Login");
        } else {
            Pool pool = new Pool();
            int roomID = pool.enqueueUser(loggedInUsername);
            session.setAttribute("roomID", String.valueOf(roomID));
            // 分配题目
            nextPage = "/PROBLEMSET/1.jsp";
        }

        response.sendRedirect(nextPage);
    }
}
