package servlets;

import dao.PetDao;
import entity.Pets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PetDao petDao = new PetDao();
        List<Pets> pets = petDao.getAll();
        request.setAttribute("pets", pets);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
