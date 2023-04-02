package Maswillaeng.MSLback.utils.interceptor;

import Maswillaeng.MSLback.common.exception.NotAuthorizedException;
import Maswillaeng.MSLback.utils.auth.AuthCheck;
import Maswillaeng.MSLback.utils.auth.TokenUserData;
import Maswillaeng.MSLback.utils.auth.UserContext;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ComponentScan
@NoArgsConstructor
public class AuthInterceptor implements HandlerInterceptor, Ordered {

    private static final String PRESENT_REPORT = "해당 요청";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        HandlerMethod handlerMethod;

        if (!(handler instanceof HandlerMethod)){
            return true;
        }

        handlerMethod = (HandlerMethod) handler;

        AuthCheck auth = handlerMethod.getMethodAnnotation(AuthCheck.class);
        if (auth == null) {
            return true;
        }

        TokenUserData userData = UserContext.userData.get();

        if (userData == null) {
            throw new NotAuthorizedException(PRESENT_REPORT);
        }

        int userRoleLevel = AuthCheck.Role.valueOf(userData.getUserRole()).getLevel();
        int requiredRoleLevel = auth.role().getLevel();

        if (userRoleLevel < requiredRoleLevel) {
            throw new NotAuthorizedException(PRESENT_REPORT);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        UserContext.remove();
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
