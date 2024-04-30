package com.Auth0_demo.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
// For simplicity of this sample, allow all origins. Real applications should configure CORS for their use case.
@CrossOrigin(origins = "*")
public class AuthController {

    @GetMapping(value = "/public")
    public ResponseDto publicEndpoint() {
        return new ResponseDto("All good. You DO NOT need to be authenticated to call /api/public.");
    }

    @GetMapping(value = "/private")
    public ResponseDto privateEndpoint() {
        return new ResponseDto("All good. You can see this because you are Authenticated.");
    }

    @GetMapping(value = "/private-scoped")
    
    public ResponseDto privateScopedEndpoint() {
        return new ResponseDto("All good. You can see this because you are Authenticated with a Token granted the 'read:messages' scope");
    }
}