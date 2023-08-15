package com.tailor.filter;

import com.tailor.service.UserDetail;
import com.tailor.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JWTFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;

    private UserDetail userDetail;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
       String token;
       String userName;
       String authorizationHeader = httpServletRequest.getHeader("Authorization");
       if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer ")){
         token= authorizationHeader.substring(7);
         userName = jwtUtil.extractUsername(token);
         if(userName !=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = userDetail.loadUserByUsername(userName);

             if (jwtUtil.validateToken(token, userDetails)) {

                 UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                         new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                 usernamePasswordAuthenticationToken
                         .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
             }
         }
         filterChain.doFilter(httpServletRequest,httpServletResponse);
       }
    }
}
