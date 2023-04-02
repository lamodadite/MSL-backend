package Maswillaeng.MSLback.utils.interceptor;

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
import java.nio.file.AccessDeniedException;

@ComponentScan
@NoArgsConstructor
public class AuthInterceptor implements HandlerInterceptor, Ordered {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        HandlerMethod handlerMethod;

        if (!(handler instanceof HandlerMethod))
            return true;
        handlerMethod = (HandlerMethod) handler;

        AuthCheck auth = handlerMethod.getMethodAnnotation(AuthCheck.class);
        if (auth == null) {
            return true;
        }

        TokenUserData userData = UserContext.userData.get();

        if (userData == null) {
            new NullPointerException("토큰이 없습니다.");
            return false;
        }

        if (auth.role().equals(AuthCheck.Role.USER)) {
            if (!userData.getUserRole().equals(AuthCheck.Role.USER.toString())) {
                new AccessDeniedException("접근권한이 없습니다.");
                return false;
            }
        }

        if (auth.role().equals(AuthCheck.Role.ADMIN)) {
            if (!userData.getUserRole().equals(AuthCheck.Role.ADMIN.toString())) {
                new AccessDeniedException("접근권한이 없습니다.");
                return false;
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        UserContext.remove();
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
