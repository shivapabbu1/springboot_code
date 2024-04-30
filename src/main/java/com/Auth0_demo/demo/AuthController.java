package com.Auth0_demo.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

@CrossOrigin(origins = "*")
public class AuthController {

	 @GetMapping("/public")
	    public ResponseEntity<ResponseDto> publicEndpoint() {
	        ResponseDto responseDto = new ResponseDto("All good. You DO NOT need to be authenticated to call /api/public.");
	        return ResponseEntity.ok(responseDto);
	    }

    @GetMapping(value = "/private")
    public ResponseEntity<ResponseDto> privateEndpoint() {
    	   ResponseDto responseDto = new ResponseDto("All good. You can see this because you are Authenticated.");
    	   return ResponseEntity.ok(responseDto);
    }

    @GetMapping(value = "/private-scoped")
    
    public ResponseEntity<ResponseDto>  privateScopedEndpoint() {
    	 ResponseDto responseDto = new ResponseDto("All good. You can see this because you are Authenticated with a Token granted the 'read:messages' scope");
    	   return ResponseEntity.ok(responseDto);
    }
}