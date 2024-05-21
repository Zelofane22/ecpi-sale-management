package ecpisalemanager.ecpisalemanager.servlet;

import com.sale.ecpisalemanagement.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "categoryServlet", urlPatterns = {"/category", "/category/create","/category/update","/category/delete"})
public class CategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String route = req.getServletPath();

        if (route.equals("/category")) {
            req.setAttribute("categories", CategoryService.all(""));
            req.getServletContext().getRequestDispatcher("/category/index.jsp").forward(req, resp);
        }
        else if (route.equals("/category/create")) {
            req.getServletContext().getRequestDispatcher("/category/cretae.jsp").forward(req, resp);
        }
        else if (route.equals("/category/update")) {
            req.getServletContext().getRequestDispatcher("/category/update.jsp").forward(req, resp);
        }
        else if (route.equals("/category/delete")) {
            CategoryService.delete(Integer.parseInt(req.getParameter("id")) );
            req.setAttribute("message", "Category deleted successfully");
            req.getServletContext().getRequestDispatcher("/category/index.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("categories", CategoryService.all(""));
            req.getServletContext().getRequestDispatcher("/category/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
