
package ru.klinika.vet.servlets;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.klinika.vet.entities.Publication;
import ru.klinika.vet.services.PublicationService;

/**
 *
 * @author alegara
 */
@WebServlet("/publication/all")
public class PublicationsServlet extends HttpServlet{
    private static final String JSP=
            "/WEB-INF/pages/articles/all.jsp";
    @EJB PublicationService publicationService;
    
    @Override
    protected void doGet(
    HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        List<Publication> items = publicationService.all();
        request.setAttribute("items", items);
        request.getRequestDispatcher(JSP).forward(request, response);
    
}
    
}
