package com.bookworm.bookworm_middleware.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/cookie")
public class UserCookieController {
    
    @GetMapping("/visit")
    public ResponseEntity<String> visitSite(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("visit")) {
                    return ResponseEntity.ok("Welcome Back, Guest!");
                }
            }
        }

        Cookie cookie = new Cookie("visit", "true");
        cookie.setMaxAge(60*60*24*7); // 1 week
        response.addCookie(cookie);
        return ResponseEntity.ok("Welcome Guest!");
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("login")) {
                    return ResponseEntity.ok("Welcome Back, User!");
                }
            }
        }

        Cookie cookie = new Cookie("login", "true");
        cookie.setMaxAge(60*60*24*7); // 1 week
        response.addCookie(cookie);
        return ResponseEntity.ok("Welcome User!");
    }
    
}
