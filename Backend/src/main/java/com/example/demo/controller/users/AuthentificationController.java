package com.example.demo.controller.users;

import com.example.demo.dto.users.JwtAuthenticationRequest;
import com.example.demo.dto.users.UserRequest;
import com.example.demo.dto.users.UserTokenState;
import com.example.demo.model.users.*;
import com.example.demo.service.users.*;
import com.example.demo.utils.TokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping(value = "auth")
public class AuthentificationController {

    private AuthenticationManager authenticationManager;
    private UserService userService;
    private TokenUtils tokenUtils;

    public AuthentificationController (AuthenticationManager authenticationManager, UserService userService, TokenUtils tokenUtils) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.tokenUtils = tokenUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {

        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        }
        catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getEmail());
        int expiresIn = tokenUtils.getExpiredIn();
        if (user.isEnabled() == false) {
            return ResponseEntity.ok(new UserTokenState(jwt, expiresIn,user.getRole().getName(), user.isEnabled()));
        }

        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn,user.getRole().getName(), user.isEnabled()));
    }


    @RequestMapping(value="/signup", method = {RequestMethod.POST })
    public ResponseEntity<HttpStatus> addUser(@RequestBody UserRequest userRequest){
        User existUser = this.userService.findByEmail(userRequest.getEmail());
           if (existUser != null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           }
           userService.save(userRequest);
           return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value="/addAdmin", method = {RequestMethod.POST })
    public ResponseEntity<HttpStatus> addAdmin(@RequestBody UserRequest userRequest){
        User existUser = this.userService.findByEmail(userRequest.getEmail());
        if (existUser != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.save(userRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
