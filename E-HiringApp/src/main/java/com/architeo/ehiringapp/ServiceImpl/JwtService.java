package com.architeo.ehiringapp.ServiceImpl;

import com.architeo.ehiringapp.Model.User;
import com.architeo.ehiringapp.Repository.UserRepository;
import com.architeo.ehiringapp.RequestResponse.JwtRequest;
import com.architeo.ehiringapp.RequestResponse.JwtResponse;
import com.architeo.ehiringapp.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JwtService implements UserDetailsService {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userName=jwtRequest.getUserName();
        String password=jwtRequest.getUserPassword();
        authenticate(userName,password);
        UserDetails userDetails=loadUserByUsername(userName);
        String newGeneratedToken=jwtUtil.generateToken(userDetails);
        User user=userRepository.findByUserName(userName);
        return new JwtResponse(user,newGeneratedToken);
    }
    public void authenticate(String userName,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
        }catch (DisabledException e){
            throw new Exception("USER_DISABLED",e);
        }catch (BadCredentialsException e){
            throw new Exception("Invalid_Credentials",e);
        }
    }

    private  Set getAuthority(User user){
        Set<SimpleGrantedAuthority> authorities=new HashSet<>();
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        });
        return authorities;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUserName(username);
        if(user!=null){
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getUserPassword(),
                    getAuthority(user)
            );
        }else {
            throw new UsernameNotFoundException("User not found with username : "+username);
        }
    }
}
