package com.groupsix.auth.controller;

import com.groupsix.auth.bean.User;
import com.groupsix.auth.common.ResponseStatus;
import com.groupsix.auth.constant.Constant;
import com.groupsix.auth.request.UserRequest;
import com.groupsix.auth.response.UserResponse;
import com.groupsix.auth.security.CookieUtil;
import com.groupsix.auth.security.JwtUtil;
import com.groupsix.auth.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService service) {this.loginService = service;}

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public UserResponse doPostLogin(@RequestBody UserRequest request, HttpServletResponse httpServletResponse){
        System.out.println("in login get");

        String username = request.getUsername();
        String password = request.getPassword();

        UserResponse response = new UserResponse();
        User user = loginService.getUserByUsername(username);
        if(user == null) {
            ResponseStatus status = new ResponseStatus(false, "Incorrect username or password");
            response.setStatus(status);
            return response;
        }
        if(!user.getPassword().equals(password)){
            System.out.println("Incorrect password");
            ResponseStatus status = new ResponseStatus(false, "Incorrect username or password");
            response.setStatus(status);
            return response;
        }

        String token = JwtUtil.generateToken(Constant.SIGNING_KEY, username);
        CookieUtil.create(httpServletResponse, Constant.JWT_TOKEN_COOKIE_NAME, token, false, -1, "localhost");
        ResponseStatus status = new ResponseStatus(true, "Login Success");
        response.setUser(user);
        response.setStatus(status);
        return response;
    }
}
