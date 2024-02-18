package com.bookworm.bookworm_middleware.controllers;

// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@RestController
@SessionAttributes("myAttribute")
public class SessionController {

    @GetMapping("/setSession")
    public String setSessionAttribute(WebRequest request) {
        request.setAttribute("myAttribute", "myValue", WebRequest.SCOPE_SESSION);
        return "Session attribute is set";
    }

    @GetMapping("/getSession")
    public String getSessionAttribute(@ModelAttribute("myAttribute") String myAttribute) {
        return "Got session attribute: " + myAttribute;
    }

    @GetMapping("/completeSession")
    public String completeSession(SessionStatus status) {
        status.setComplete();
        return "Session completed";
    }
}