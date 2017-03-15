package com.github.fjtorres.samples.jsf.primefacesTest.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Custom authentication provider for spring security.
 * 
 * @author fjtorres
 *
 */
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

   @Override
   protected void additionalAuthenticationChecks(UserDetails userDetails,
         UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
      
      // Add custom verifications hear
      
      super.additionalAuthenticationChecks(userDetails, authentication);
   }
}
