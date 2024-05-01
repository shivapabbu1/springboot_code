package com.AuthDemo_Authenticated.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests to "/api" endpoints.
 * @see com.auth0.example.security.SecurityConfig to see how these endpoints are protected.
 */
@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
// For simplicity of this sample, allow all origins. Real applications should configure CORS for their use case.
@CrossOrigin(origins = "http://localhost:5173/")
public class APIController {

    @GetMapping(value = "/public")
    public Message publicEndpoint() {
        return new Message("Hey you are free to go bcz you are public api.");
    }

    @GetMapping(value = "/private")
    public Message privateEndpoint() {
        return new Message("Hey you are not  free to go bcz you are private api..");
    }

    @GetMapping(value = "/scoped")
    public Message privateScopedEndpoint() {
        return new Message("hey you are special because you are Authenticated with a Token granted the 'read:users' scope");
    }
}