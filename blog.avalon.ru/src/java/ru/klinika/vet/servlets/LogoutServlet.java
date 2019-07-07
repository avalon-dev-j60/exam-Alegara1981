package ru.klinika.vet.servlets;

import ru.klinika.vet.services.AuthService;
import java.io.*;
import javax.inject.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import ru.klinika.vet.helpers.ServletHelper;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    
    @Inject AuthService authService;

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response
    ) throws ServletException, IOException {
        authService.signOut();
        ServletHelper.redirectToReferer(
            request, 
            response
        );
    }
}
