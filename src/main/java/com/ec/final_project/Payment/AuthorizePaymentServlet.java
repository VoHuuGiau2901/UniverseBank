package com.ec.final_project.Payment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.paypal.base.rest.PayPalRESTException;

@WebServlet(name = "AuthorizePaymentServlet", value = "/AuthorizePaymentServlet")
public class AuthorizePaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
