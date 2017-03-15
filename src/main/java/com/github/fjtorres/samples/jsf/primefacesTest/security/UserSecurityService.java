package com.github.fjtorres.samples.jsf.primefacesTest.security;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Custom security service to retrieve the user.
 * 
 * @author fjtorres
 *
 */
@Component("customUserSecurityService")
public class UserSecurityService implements UserDetailsService {
   
   private static final Map<String, User> IN_MEMORY = new HashMap<>();
   
   static {
      IN_MEMORY.put("user",  new User("user", "user", Arrays.asList(new SimpleGrantedAuthority("user"))));
      IN_MEMORY.put("admin",  new User("admin", "admin", Arrays.asList(new SimpleGrantedAuthority("admin"))));
   }
   
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      
      User user = IN_MEMORY.get(username);
      
      if (user == null) {
         throw new UsernameNotFoundException(String.format("User %s not found", username));
      }
      
      return user;
   }
}
