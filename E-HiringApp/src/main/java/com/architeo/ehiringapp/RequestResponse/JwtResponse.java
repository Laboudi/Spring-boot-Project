package com.architeo.ehiringapp.RequestResponse;

import com.architeo.ehiringapp.Model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private User user;
    private String token;
}
