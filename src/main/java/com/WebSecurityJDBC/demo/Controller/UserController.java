package com.WebSecurityJDBC.demo.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.WebSecurityJDBC.demo.entity.User;

@Controller
public class UserController {

	private final UserDetailsService userDetailsService;

	@Autowired
	public UserController(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private DataSource dataSource;

	@GetMapping("/saveUser")
	public String showSaveUserForm(Model model) {
		model.addAttribute("user", new User());
		return "saveuser";
	}


	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user, Model model) {
		try {
			Connection connection = dataSource.getConnection();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO stu_table (username, password, role) VALUES (?, ?, ?)");
			statement.setString(1, user.getUsername());
			statement.setString(2, encodedPassword);
			statement.setString(3, user.getRole());
			statement.executeUpdate();

			return "redirect:/login";
		} catch (SQLException e) {
			model.addAttribute("errorMessage", "Error saving user: " + e.getMessage());
			return "save-user";
		}
	}

	@GetMapping("/login")
	public String getlog() {
		return "login";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/user")
	public String user() {
		return "user";
	}
}