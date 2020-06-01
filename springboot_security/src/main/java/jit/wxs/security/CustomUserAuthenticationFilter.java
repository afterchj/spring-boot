package jit.wxs.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomUserAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String USERNAME = "";
    public static final String PASSWORD = "";

    /**
     * @param :args
     * @return
     * @throws Exception
     * @Description:用户登录验证方法入口
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        logger.warn("用户登录验证方法入口...");
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        String username = obtainUsername(request).trim();
        String password = obtainPassword(request);
        String secret = BCrypt.hashpw(password, BCrypt.gensalt());
        logger.warn("password {},secret {}", password, secret);
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, secret);
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);

    }


    /**
     * @param :args
     * @return
     * @throws Exception
     * @Description:获取密码
     */
    @Override
    protected String obtainPassword(HttpServletRequest request) {
        // TODO Auto-generated method stub
        Object obj = request.getParameter(PASSWORD);
        return null == obj ? "" : obj.toString();
    }

    /**
     * @param :args
     * @return
     * @throws Exception
     * @Description:获取用户名
     */
    @Override
    protected String obtainUsername(HttpServletRequest request) {
        // TODO Auto-generated method stub
        Object obj = request.getParameter(USERNAME);
        return null == obj ? "" : obj.toString().trim().toLowerCase();
    }
}
