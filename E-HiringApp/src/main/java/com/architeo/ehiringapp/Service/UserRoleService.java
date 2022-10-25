package com.architeo.ehiringapp.Service;

import com.architeo.ehiringapp.Model.Role;
import com.architeo.ehiringapp.Model.User;

import java.util.List;

public interface UserRoleService {
    public User registerNewUser(User user);
    public Role saveRole(Role role);
    public void addRoleToUser(String username,String rolename);
    public List<Role> getRoles();
}
