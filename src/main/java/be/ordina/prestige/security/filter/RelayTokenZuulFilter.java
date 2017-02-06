package be.ordina.prestige.security.filter;

import be.ordina.prestige.exception.AccessDeniedException;
import be.ordina.prestige.security.JwtTokenUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RelayTokenZuulFilter extends ZuulFilter {

    private UserDetailsService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public RelayTokenZuulFilter(UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil){
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String header = ctx.getRequest().getHeader("Authorization");
        return StringUtils.isNotEmpty(header);
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String token = ctx.getRequest().getHeader("Authorization");
        final HttpServletResponse response = ctx.getResponse();

        System.out.println("RelayTokenZuul filter is used");

        String jwt = token.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(jwt);

        boolean isValid = jwtTokenUtil.validateToken(jwt, userDetailsService.loadUserByUsername(username));
        //boolean isValid = true;
        if (isValid) {
            return null;
        } else {
            try {
                //log.error(String.format("invalid token  %s", token));
                response.sendError(403, "Token is not valid");
                return null;
            } catch (final IOException ex) {
                //log.error(String.format("invalid token  %s", token, ex));
                throw new AccessDeniedException("Token is not valid", ex);
            }
        }
    }
}
