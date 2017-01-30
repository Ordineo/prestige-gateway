package be.ordina.prestige.security.filter;

import be.ordina.prestige.exception.AccessDeniedException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1000;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String path = ctx.getRequest().getServletPath();
        final HttpServletResponse response = ctx.getResponse();

        System.out.println("Auth filter is used");

        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            return null;
        } else {
            String msg = String.format("You have no access to this path!%s", path);
            try {
                //log.error("access denied {} ", msg);
                response.sendError(403, msg);
                return null;
            } catch (final IOException ex) {
                //log.error("access denied {} ", msg, ex);
                throw new AccessDeniedException(msg, ex);
            }
        }

    }
}
