
package ru.klinika.vet.servlets;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.klinika.vet.entities.Review;
import ru.klinika.vet.services.ReviewService;

/**
 *
 * @author alegara
 */
@WebServlet("/review/all")
public class ReviewServlet extends HttpServlet{
    private static final String JSP=
            "/WEB-INF/pages/review/all.jsp";
    @EJB ReviewService reviewService;
    
    @Override
    protected void doGet(
    HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        List<Review> items = reviewService.all();
        request.setAttribute("items", items);
        request.getRequestDispatcher(JSP).forward(request, response);
    
    }
}
