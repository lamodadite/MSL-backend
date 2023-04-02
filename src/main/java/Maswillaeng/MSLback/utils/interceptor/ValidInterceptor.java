package Maswillaeng.MSLback.utils.interceptor;

import Maswillaeng.MSLback.jwt.JwtTokenProvider;
import Maswillaeng.MSLback.utils.auth.ValidToken;
import Maswillaeng.MSLback.utils.auth.ValidTokenProcess;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@NoArgsConstructor
@ComponentScan
public class ValidInterceptor implements Ordered, HandlerInterceptor {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {

        HandlerMethod handlerMethod;

        if (!(handler instanceof HandlerMethod))
            return true;
        handlerMethod = (HandlerMethod) handler;

        ValidToken token = handlerMethod.getMethodAnnotation(ValidToken.class);
        if (token == null) {
            return true;
        }

        return ValidTokenProcess.execute(req, res, jwtTokenProvider);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
