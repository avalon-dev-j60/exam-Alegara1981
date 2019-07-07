/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.klinika.vet.servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.klinika.vet.entities.Review;
import static ru.klinika.vet.helpers.ServletHelper.redirectToReferer;
import ru.klinika.vet.services.ReviewService;


@WebServlet("/review")
public class ReviewShowServlet extends HttpServlet {
   
    private static final String JSP = "/WEB-INF/pages/review/show.jsp";
    @EJB
    ReviewService reviewService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            long lid = Long.parseLong(id);

            Review review = reviewService.find(lid);
            if (review != null) {
                request.setAttribute("review", review);
                request.getRequestDispatcher(JSP).forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);

            }

        } else {
            redirectToReferer(request, response);
        }
    }
    
}
