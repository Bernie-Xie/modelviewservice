package com.inno.modelview.configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.inno.modelview.exception.InvalidToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

/**
 * Created by Will Hu on 16-5-19.
 * The filter is to handle JSon web token
 * As you can see we use a hardcoded key "SECRETKEY" here.
 * In real production scenario’s this would typically be randomly generated on start-up or stored in some kind of central cache.
 * This has the added benefit of making all tokens invalid when the service restarts.
 * For convenience it’s hardcoded in these examples.
 * OPTIONS is allowed here to pass the filter because the preflight requests would send "OPTION" first without Authority.
 */
public class JWTFilter implements Filter {

    final static String AUTH_HEADER = "Authorization";
    final static String BEARER = "Bearer ";
    final static String SECRET_KEY = "SECRETKEY"; // TODO need to be change to complex string and config in resource file
    final static String CLAIMS = "claims";

    final static Pattern excludeUrls = Pattern.compile("/login$", Pattern.CASE_INSENSITIVE);
    final static Pattern partiallyExcludeUrls = Pattern.compile("/logout$", Pattern.CASE_INSENSITIVE);

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final String authHeader = request.getHeader(AUTH_HEADER);

        if (isExludeJWTRequest(request) && request.getMethod() != "OPTIONS") {
            if (authHeader == null || !authHeader.startsWith(BEARER)) {
                //throw new InvalidToken("Missing or invalid Authorization header.");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            final String token = authHeader.substring(7);   // The part after "Bearer "
            try {
                final Claims claims = Jwts.parser().setSigningKey(SECRET_KEY)
                        .parseClaimsJws(token).getBody();
                request.setAttribute(CLAIMS, claims);
            } catch (final ExpiredJwtException ex) {
                if (!isPartiallyExludeJWTRequest(request)) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
                // for Logout request as well as JWT Expired case, let it go!
            } catch (final SignatureException ex) {
                //throw new InvalidToken();
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }
        chain.doFilter(req, res);
    }


    /**
     * The function is to let the some requests skip JWT validation e.g. Login request
     */
    private boolean isExludeJWTRequest(HttpServletRequest request) {
        String url = request.getRequestURI().toString();
        Matcher m = excludeUrls.matcher(url);
        return (!m.matches());
    }

    /**
     * The function is to let the some request partially skip JWT validation.
     * For example, Logout request needs to pass JWT validation if the token is expired.
     */
    private boolean isPartiallyExludeJWTRequest(HttpServletRequest request) {
        String url = request.getRequestURI().toString();
        Matcher m = partiallyExcludeUrls.matcher(url);
        return (!m.matches());
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void destroy() { }
}
