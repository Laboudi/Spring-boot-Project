package com.architeo.ehiringapp.Repository;

import com.architeo.ehiringapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long > {
    User findByUserName(String username);
}
