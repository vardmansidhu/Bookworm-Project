package com.bookworm.bookworm_middleware.controllers;

import java.util.UUID;
import java.util.Base64;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/cookie")
public class UserCookieController {

    // @GetMapping("/visit")
    // public ResponseEntity<String> visitSite(HttpServletRequest request,
    // HttpServletResponse response) {
    // Cookie[] cookies = request.getCookies();
    // if(cookies != null) {
    // for(Cookie cookie : cookies) {
    // if(cookie.getName().equals("visit")) {
    // return ResponseEntity.ok("Welcome Guest!");
    // }
    // }
    // }

    // String guestId = UUID.randomUUID().toString();
    // Cookie cookie = new Cookie("visit", guestId);
    // cookie.setMaxAge(60*60*24*7); // 1 week
    // response.addCookie(cookie);
    // return ResponseEntity.ok("Welcome Guest!");
    // }

    @GetMapping("/add-to-cart")
    public ResponseEntity<String> addToCart(HttpServletRequest request, HttpServletResponse response,
            @RequestParam String itemId) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    String cartItems = new String(Base64.getDecoder().decode(cookie.getValue()));
                    cartItems += "," + itemId;
                    cookie.setValue(Base64.getEncoder().encodeToString(cartItems.getBytes()));
                    response.addCookie(cookie);
                    return ResponseEntity.ok("Item added to cart!");
                }
            }
        }

        String cartItems = itemId;
        Cookie cookie = new Cookie("cart", Base64.getEncoder().encodeToString(cartItems.getBytes()));
        cookie.setMaxAge(60 * 60 * 24 * 7); // 1 week
        response.addCookie(cookie);
        return ResponseEntity.ok("Item added to cart!");
    }

    @GetMapping("/view-cart")
    public ResponseEntity<String> viewCart(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    String cartItems = new String(Base64.getDecoder().decode(cookie.getValue()));
                    return ResponseEntity.ok("Cart Items: " + cartItems);
                }
            }
        }

        return ResponseEntity.ok("Cart is empty!");
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login")) {
                    return ResponseEntity.ok("Welcome Back, User!");
                }
            }
        }

        Cookie cookie = new Cookie("login", "1");
        cookie.setMaxAge(60 * 60 * 24 * 7); // 1 week
        response.addCookie(cookie);
        return ResponseEntity.ok("Welcome User!");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0); // delete the cookie
                cookie.setPath(cookie.getPath()); // set the same path
                if (cookie.getDomain() != null) {
                    cookie.setDomain(cookie.getDomain()); // set the same domain
                }
                response.addCookie(cookie);
            }
        }

        // Generate a new guest cookie
        String guestId = UUID.randomUUID().toString();
        Cookie cookie = new Cookie("visit", guestId);
        cookie.setMaxAge(60 * 60 * 24 * 7); // 1 week
        cookie.setPath("/"); // allow the entire application to access it
        response.addCookie(cookie);

        return ResponseEntity.ok("Logged out successfully!");
    }

}
