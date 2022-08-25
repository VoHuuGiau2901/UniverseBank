package com.ec.final_project.Controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ec.final_project.Controllers.Notification.NotificationVar;
import com.ec.final_project.Entity.useraccount;
import com.ec.final_project.Services.Services.pay_accountService;
import com.ec.final_project.Services.Services.saving_accountService;
import com.ec.final_project.Services.Services.accountService;
import com.ec.final_project.Utils.ControllerUtils;
import com.ec.final_project.Utils.MailSender;
import com.ec.final_project.Utils.SecurityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.REQUEST_TIMEOUT;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/Welcome")
@CrossOrigin("*")
public class accountController {
    private final accountService Acc_Service;
    private final pay_accountService pay_Acc_Service;
    private final saving_accountService saving_Acc_Service;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public accountController(accountService acc_Service, pay_accountService pay_Acc_Service, saving_accountService saving_Acc_Service, SimpMessagingTemplate simpMessagingTemplate) {
        Acc_Service = acc_Service;
        this.pay_Acc_Service = pay_Acc_Service;
        this.saving_Acc_Service = saving_Acc_Service;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @GetMapping("/hehe")
    public void welcome(@RequestBody String message) {
        System.out.println(message);
        simpMessagingTemplate.convertAndSendToUser("hehe", NotificationVar.destination, message);
    }

    @PostMapping("/Register")
    public Object Register(@RequestBody useraccount acc) {
        if (Acc_Service.CheckExist(acc)) {
            return "account already taken";
        } else {
            String verify_code = ControllerUtils.Get_OTP();
            MailSender.send(acc.getEmail(), "Verify Email Code", "Use this code to verify your account: " + verify_code);
            HashMap<String, String> res = new HashMap<>();
            res.put("verify_code", verify_code);
            return res;
        }
    }

    @PostMapping("/Register/CreateAccount")
    public Object CreateAccount(@RequestBody useraccount acc) {
        Acc_Service.Create(acc);
        pay_Acc_Service.Create(0, acc.getPhone(), acc.getAcc_id());
        return "new account added";
    }

    @PostMapping("/UserArea")
    public Object getAccount(@RequestBody Map<String, String> req) {
        return saving_Acc_Service.getAccount(Integer.parseInt(req.get("userID")));
    }

    @PostMapping("/Forget_Password")
    public Object Forget_Password(@RequestBody Map<String, String> req) {
        useraccount acc = Acc_Service.FindByEmail(String.valueOf(req.get("email")));
        if (acc != null) {
            String verify_code = ControllerUtils.Get_OTP();
            MailSender.send(acc.getEmail(), "Renew Password Code", "Use this code to verify your account: " + verify_code);
            HashMap<String, String> res = new HashMap<>();
            res.put("verify_code", verify_code);
            res.put("acc_id", String.valueOf(acc.getAcc_id()));
            return res;
        } else {
            return "error";
        }
    }

    @PostMapping("/Renew_Password")
    public String Renew_Password(@RequestBody Map<String, String> req) {
        int acc_id = Integer.parseInt(req.get("acc_id"));
        String new_password = req.get("new_password");
        Acc_Service.UpdatePassword(acc_id, new_password);
        return "success";
    }

    @GetMapping("/Delete_Acc")
    public void delete_Acc(@RequestBody Map<String, String> req) {
        Acc_Service.delete_Acc(Integer.parseInt(req.get("id")));
    }

    @GetMapping("/RefreshToken")
    public void RefeshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String refresh_token = request.getHeader(AUTHORIZATION);
        if (refresh_token != null) {
            try {
                JWTVerifier jwtVerifier = JWT.require(SecurityUtils.ENCODE_ALGORITHM).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(refresh_token);

                String username = decodedJWT.getSubject();
                useraccount useraccount = Acc_Service.findByUsername(username);
//                String role = decodedJWT.getClaim("role").asString();

                String access_token = JWT.create()
                        .withSubject(useraccount.getUsername())
                        .withExpiresAt(SecurityUtils.ACCESS_TIME_EXPIRED)
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("role", "USER")
                        .sign(SecurityUtils.ENCODE_ALGORITHM);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);

                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception e) {
                HttpStatus status = REQUEST_TIMEOUT;

                System.out.println("error Login " + e.getMessage());

                response.setHeader("error Login ", e.getMessage());
                response.setStatus(status.value());

                Map<String, String> errors = new HashMap<>();
                errors.put("response", "Please Login Again");
                errors.put("status", String.valueOf(status.value()));
                errors.put("error", status.getReasonPhrase());

                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), errors);
            }
        }
    }
}
