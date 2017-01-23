package be.ordina.prestige.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by JoLe on 23/01/2017.
 */
public class JwtAuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

    @Value("${jwt.header}")
    private String tokenHeader;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authToken = httpRequest.getHeader(this.tokenHeader);
        if (authToken != null) {
            authToken = authToken.substring(7);
            System.out.println(authToken);
        }
        if(httpRequest.getUserPrincipal() != null &&  httpRequest.getUserPrincipal().getName() != null){
            System.out.println(httpRequest.getUserPrincipal().getName());
        }

        if(httpRequest.getHeader("X-XSRF-TOKEN") != null){
            System.out.println(httpRequest.getHeader("X-XSRF-TOKEN"));
        }


        chain.doFilter(request, response);
    }
}
