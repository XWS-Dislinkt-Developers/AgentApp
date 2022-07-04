package com.example.demo.controller.users;

import com.example.demo.dto.users.UserDTO;
import com.example.demo.dto.users.UserUpdateDTO;
import com.example.demo.model.users.User;
import com.example.demo.service.users.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PreAuthorize("hasAnyRole('ADMIN','USER', 'COMPANY_OWNER')")
    @GetMapping(value = "/userInfo")
    public ResponseEntity<UserDTO> fetchProfileInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER', 'COMPANY_OWNER')")
    @PostMapping(value="/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@RequestBody UserUpdateDTO updatedUser){
        userService.update(updatedUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
