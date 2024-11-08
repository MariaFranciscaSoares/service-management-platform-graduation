package br.com.piel.service.login.controller;

import br.com.piel.service.login.dto.UserDto;
import br.com.piel.service.login.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {

	private final UserService userService;
	private final PasswordEncoder passwordEncoder;

	public UserController(UserService userService, PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder; 
	}

	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
		try {
			UserDto savedUser = userService.saveUser(userDto);
			return ResponseEntity.ok(savedUser);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<UserDto> loginUser(@RequestBody UserDto userDto) {

		UserDto existingUser = userService.findByEmail(userDto.getEmail());


		if (passwordEncoder.matches(userDto.getPassword(), existingUser.getPassword())) {
			return ResponseEntity.ok(existingUser);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}

	@GetMapping("/currentUser")
	public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
	    String email = userDetails.getUsername();

	    UserDto currentUser = userService.findByEmail(email);
	    
	    if (currentUser != null) {
	        return ResponseEntity.ok(currentUser);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado com o email: " + email);
	    }
	}

}
