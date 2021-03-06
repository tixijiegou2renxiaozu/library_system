package servlet.readBook;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 在线电子书搜索结果的servlet
 */
@WebServlet(name = "onlineReadBook")
public class onlineReadBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet---onlineReadBook");

        HttpSession session=request.getSession(false);
        ServletContext context = getServletContext();

        session.setAttribute("allFoundEBooks", "");
        context.getRequestDispatcher("/jsps/readBook/onlineReadBook.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
