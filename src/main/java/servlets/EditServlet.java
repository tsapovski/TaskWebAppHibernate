package servlets;
import dao.PetDao;
import entity.Pets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            PetDao petDao = new PetDao();
            Pets pets = petDao.getPet(id);
            if(pets!=null) {
                request.setAttribute("pets", pets);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(request.getParameter("id"));
            String typePet = request.getParameter("typePet");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String color = request.getParameter("color");
            byte ownerStatus = Byte.parseByte(request.getParameter("ownerStatus"));


            Pets pets = new Pets(id, typePet, name, age, color, ownerStatus);
            PetDao petDao = new PetDao();
            petDao.update(pets);
            response.sendRedirect(request.getContextPath() + "/index");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}
