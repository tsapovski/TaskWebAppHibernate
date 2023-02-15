package servlets;

import dao.PetDao;
import entity.Pets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String typePet = request.getParameter("typePet");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String color = request.getParameter("color");
            byte ownerStatus = Byte.parseByte(request.getParameter("ownerStatus"));



            Pets pets = new Pets(typePet, name, age, color, ownerStatus);
            PetDao petDao = new PetDao();
            petDao.insert(pets);
            response.sendRedirect(request.getContextPath()+"/index");

        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }
}

