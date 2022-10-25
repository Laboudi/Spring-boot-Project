package com.architeo.ehiringapp.ServiceImpl;

import com.architeo.ehiringapp.Model.Role;
import com.architeo.ehiringapp.Model.User;
import com.architeo.ehiringapp.Repository.RoleRepository;
import com.architeo.ehiringapp.Repository.UserRepository;
import com.architeo.ehiringapp.Service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User registerNewUser(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        User user=userRepository.findByUserName(username);
        Role role=roleRepository.findByRoleName(rolename);
        user.getRole().add(role);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
