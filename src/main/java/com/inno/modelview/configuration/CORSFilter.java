package com.inno.modelview.configuration;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Will Hu
 * The filter is to allow cross domain request.
 * The service is design to provide public visit, thus the Access-Control-Allow-Credentials is *
 * If customising headers are to be accessible, Access-Control-Allow-Headers is to be modified to reach the goal.
 */
public class CORSFilter implements Filter {

    final static String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    final static String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
    final static String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    final static String ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";
    final static String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";

    private HashMap<String, String> responseSettings = new HashMap();

    {
        responseSettings.put(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        responseSettings.put(ACCESS_CONTROL_ALLOW_CREDENTIALS, "*");
        responseSettings.put(ACCESS_CONTROL_ALLOW_METHODS, "POST, GET, PUT, OPTIONS, DELETE");
        responseSettings.put(ACCESS_CONTROL_MAX_AGE, "172800");
        responseSettings.put(ACCESS_CONTROL_ALLOW_HEADERS, "Authorization, Content-Type, X-CSRF-Token, X-Requested-With, Accept, Accept-Version, Content-Length, Content-MD5,  Date, X-Api-Version, X-File-Name");
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        //TODO Need to replace with DNS when in the production,
        //Otherwise it would be extremely dangerous that every unknown request may process this API
        //e.g. http://localhost:3000
        //http://192.168.18.145:3000
        response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, responseSettings.get(ACCESS_CONTROL_ALLOW_ORIGIN));
        response.setHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, responseSettings.get(ACCESS_CONTROL_ALLOW_CREDENTIALS));
        response.setHeader(ACCESS_CONTROL_ALLOW_METHODS, responseSettings.get(ACCESS_CONTROL_ALLOW_METHODS));
        //Beyond the timeRange (Access-Control-Max-Age), preflight requests would send "OPTION" again to the API to make sure the safety
        response.setHeader(ACCESS_CONTROL_MAX_AGE, responseSettings.get(ACCESS_CONTROL_MAX_AGE));
        response.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, responseSettings.get(ACCESS_CONTROL_ALLOW_HEADERS));
        chain.doFilter(req, res);
        //TODO add Cache
    }

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}

}