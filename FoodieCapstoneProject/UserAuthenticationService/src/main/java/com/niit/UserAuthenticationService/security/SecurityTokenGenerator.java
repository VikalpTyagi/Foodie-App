package com.niit.UserAuthenticationService.security;





import com.niit.UserAuthenticationService.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}
