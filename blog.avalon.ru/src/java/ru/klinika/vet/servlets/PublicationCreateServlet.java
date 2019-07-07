
package ru.klinika.vet.servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.klinika.vet.entities.Publication;
import ru.klinika.vet.entities.User;
import ru.klinika.vet.exceptions.RequiredDataException;
import static ru.klinika.vet.helpers.ServletHelper.*;
import ru.klinika.vet.services.AuthService;
import ru.klinika.vet.services.PublicationService;


/**
 *
 * @author alegara
 */
@WebServlet("/publication/create")
public class PublicationCreateServlet extends HttpServlet {

    private static final String JSP = "/WEB-INF/pages/articles/create.jsp";
    
    @Inject AuthService authService;
    
    @EJB PublicationService publicationService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(authService.isSignedIn()){
            request.getRequestDispatcher(JSP)
                    .forward(request,response);
        } else {
            redirectToReferer(request, response);
        }
        
    }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        try{
            if(title == null || title.trim().isEmpty()) {
                throw new RequiredDataException("error.title.required");
            }
             if(content == null || content.trim().isEmpty()) {
                throw new RequiredDataException("error.content.required");
            }
             User user = authService.getUser();
             Publication publication = new Publication(title, content, user);
             
             publicationService.create(publication);
             redirect(request, response, request.getContextPath());
             
             
             
             
             
             
        } catch (Exception e) {
           request.setAttribute("error", e.getMessage());
            doGet(request, response);
        }
        }
        
    
}   