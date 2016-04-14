package com.inno.modelview.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class CORSFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        //TODO Need to replace with DNS when in the production,
        //Otherwise it would be extremely dangerous that every unknown request may process this API
        //e.g. http://localhost:3000
        //http://192.168.18.145:3000
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        //Beyond the timeRange (Access-Control-Max-Age), preflight requests would send "OPTION" again to the API to make sure the safety
        response.setHeader("Access-Control-Max-Age", "1728000");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        chain.doFilter(req, res);
        //TODO add Cache
    }

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}

}