package com.solars.SolarWeb.Controllers;

import com.solars.SolarWeb.Config.JwtUtils;
import com.solars.SolarWeb.Domain.AuthenticationRequest;
import com.solars.SolarWeb.Domain.PromoForm;
import com.solars.SolarWeb.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtils jwtUtils;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate( AuthenticationRequest request, HttpServletRequest servletRequest,
                                               HttpServletResponse response) throws IOException {
        System.out.println("1");
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), userService.userPasswordEncoder().encode(request.getPassword())));
        System.out.println("2");
        final UserDetails user = userService.findByEmail(request.getEmail());
        System.out.println("3");
        if (user != null){
            System.out.println("4");
            response.sendRedirect("/adminnn");
            System.out.println("5");
            return ResponseEntity.ok(jwtUtils.generateToken(user));
        }
         return ResponseEntity.status(400).body("An error occurred");
    }


}
