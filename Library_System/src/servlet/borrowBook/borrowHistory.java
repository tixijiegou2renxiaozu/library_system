package servlet.borrowBook;

import factory.ServiceFactory;
import model.Book;
import model.User;
import model.UserOrder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
/**
 * author：丁雯雯
 * time：2019/01/24
 * 借书历史的servlet
 */
@WebServlet(name = "borrowHistory")
public class borrowHistory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet---borrowHistory");

        HttpSession session=request.getSession(false);
        ServletContext context = getServletContext();

        //获得username的cookie
        Cookie[] cookies=request.getCookies();
        Cookie cookie=null;
        if(null!=cookies){
            for(int i=0;i<cookies.length;i++){
                cookie=cookies[i];
                if(cookie.getName().equals("username")){
                    break;
                }
            }
        }

        //获得user需要表现在userInfo.jsp上面的信息
        User u= ServiceFactory.getUserManageService().getUserInfoByName(cookie.getValue());
        ArrayList<UserOrder> arrUserOrder= (ArrayList<UserOrder>) ServiceFactory.getUserOrderManageService().getAllLentBooksUserOrderById(cookie.getValue());
        ArrayList<Book> arrBooks=new ArrayList();
        for(int i=0;i<arrUserOrder.size();i++){
            Book b=ServiceFactory.getBookManageService().getBookInfoById(arrUserOrder.get(i).getBookId());
            arrBooks.add(b);
        }

        session=request.getSession(true);
        session.setAttribute("userInfo", u);
        session.setAttribute("allLentBooksUserOrder",  arrUserOrder);
        session.setAttribute("allLentBooks",  arrBooks);
        context.getRequestDispatcher("/jsps/borrowBook/borrowHistory.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
