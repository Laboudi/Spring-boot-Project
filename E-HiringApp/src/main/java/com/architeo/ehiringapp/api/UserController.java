package com.architeo.ehiringapp.api;

import com.architeo.ehiringapp.Model.Role;
import com.architeo.ehiringapp.Model.User;

import com.architeo.ehiringapp.RequestResponse.JwtRequest;
import com.architeo.ehiringapp.RequestResponse.JwtResponse;
import com.architeo.ehiringapp.Service.UserRoleService;
import com.architeo.ehiringapp.ServiceImpl.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class UserController {
    private final UserRoleService userRoleServicel;

    private final JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
    @PostMapping("/registerNewUser")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        return ResponseEntity.ok().body(userRoleServicel.registerNewUser(user));
    }
    @PostMapping("/api/roles")
    public ResponseEntity<List<Role>> getRoles(){
        return ResponseEntity.ok().body(userRoleServicel.getRoles());
    }
    @GetMapping("/forAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getAdminPage(){
        return ResponseEntity.ok("You are in the admin page");
    }
    @GetMapping("/forUser")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> getUserPage(){
        return ResponseEntity.ok("You are in the user page .");
    }
    @PostMapping("/saveRole")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        return ResponseEntity.ok().body(userRoleServicel.saveRole(role));
    }
}
