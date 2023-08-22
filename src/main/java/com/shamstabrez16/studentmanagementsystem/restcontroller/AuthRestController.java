package com.shamstabrez16.studentmanagementsystem.restcontroller;


import com.shamstabrez16.studentmanagementsystem.dto.UserDto;
import com.shamstabrez16.studentmanagementsystem.model.User;
import com.shamstabrez16.studentmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthRestController {
    private final UserService service;

    @Autowired
    public AuthRestController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> createNewUser(@RequestBody UserDto user) {
        User user1 = User.builder()
                .email(user.getEmail())
                .secretkey(user.getSecretkey()).build();
        user1 =     service.saveUser(user1);
        UserDto userDto = new UserDto(user1.getId(), user.getEmail());
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto user) {
        User user1 = User.builder()
                .email(user.getEmail())
                .secretkey(user.getSecretkey()).build();
     return service.findByUsernameOrEmail(user1) ? ResponseEntity.ok("jwtToken"):ResponseEntity.badRequest().body("Login failed");
    }
}
