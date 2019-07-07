package ru.klinika.vet.servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.klinika.vet.entities.Publication;
import static ru.klinika.vet.helpers.ServletHelper.*;
import ru.klinika.vet.services.PublicationService;
import static ru.klinika.vet.helpers.ServletHelper.redirectToReferer;

@WebServlet("/publication")
public class PublicationViewServlet extends HttpServlet {

private static final String JSP =
"/WEB-INF/pages/articles/view.jsp";

@EJB PublicationService publicationService;

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String id = request.getParameter("id");
if(id!=null) {
long lid=Long.parseLong(id);
Publication publication = publicationService.find(lid);
if (publication!=null){
request.setAttribute("publication", publication);
request.getRequestDispatcher(JSP).forward(request, response);
} else {response.sendError(HttpServletResponse.SC_NOT_FOUND);

}

} else {
redirectToReferer(request, response);
}
}



}