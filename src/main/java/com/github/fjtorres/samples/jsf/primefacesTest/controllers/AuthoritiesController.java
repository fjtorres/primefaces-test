package com.github.fjtorres.samples.jsf.primefacesTest.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

/**
 * Managed bean for authorities operations.
 * 
 * @author fjtorres
 *
 */
@Controller
@Scope("session")
public class AuthoritiesController {

   /**
    * Check that user has all authorities.
    * 
    * @param authorities
    *           Authorities to check.
    * @return <code>true</code> if user has all authorities, otherwise
    *         <code>false</code>.
    */
   public boolean allGranted(String... authorities) {

      List<String> userAuthorities = getLoggedUserAuthorities();

      return Stream.of(authorities).allMatch(authority -> userAuthorities.contains(authority));
   }

   /**
    * Get logged user authorities as list of string.
    * 
    * @return User authorities list.
    */
   private List<String> getLoggedUserAuthorities() {

      return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
            .map(authority -> authority.getAuthority()).collect(Collectors.toList());
   }
}
