package com.sale.ecpisalemanagement;

import java.io.*;

import com.sale.ecpisalemanagement.model.Category;
import com.sale.ecpisalemanagement.old.CategoryService;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");


        //CategoryService.create(new Category("Shawarma", "fast food"));
        //CategoryService.update(new Category(1,"Fanta orange", "Juice"));
        //CategoryService.delete(2);

        var data = CategoryService.all("");

        for (Category category : data) {
            // Access category properties here
            System.out.println("Category Name: " + category.getName());

        }
    }

    public void destroy() {
    }
}