package pl.coderslab.users;

import pl.coderslab.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "userShow", value = "/user/show")
public class userShow extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("id"));
        UserDao readUserDao = new UserDao();

        try {
            request.setAttribute("user", readUserDao.read(userId));
            getServletContext().getRequestDispatcher("/show.jsp").forward(request,response);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
