package com.viettel.safe.one.configuration.Filter;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by gianglh7 on 2/5/2015.
 */
public class PostSecurityLoggingFilter implements Filter
{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException
    {
        SecurityContext context = SecurityContextHolder.getContext();
        if(context != null && context.getAuthentication() != null)
            ThreadContext.put("username", context.getAuthentication().getName());

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void destroy() { }
}
