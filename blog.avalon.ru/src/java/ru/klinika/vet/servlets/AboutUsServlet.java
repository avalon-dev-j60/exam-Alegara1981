package ru.klinika.vet.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import ru.klinika.vet.helpers.ServletHelper;
import ru.klinika.vet.services.AuthService;

@WebServlet("/aboutus")
public class AboutUsServlet extends HttpServlet {

    @Inject AuthService authService;
    
    @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
                    throws ServletException, IOException {
   
            request 
                .getRequestDispatcher(
                    "/WEB-INF/pages/auth/aboutus.jsp"
                ).forward(
                    request, 
                    response
                );
        }
    }

    

