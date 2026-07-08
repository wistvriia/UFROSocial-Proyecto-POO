package ufro.redsocial.config;

import ufro.redsocial.util.Sesion;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession(false);
        boolean autenticado = session != null && session.getAttribute(Sesion.USUARIO_ID) != null;

        if (autenticado) {
            return true;
        }
        response.sendRedirect(request.getContextPath() + "/login");
        return false;
    }
}
