package com.example.inteceptor.config;

import com.example.inteceptor.model.Repository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@RequiredArgsConstructor
@Component
public class RequestInterceptor implements HandlerInterceptor {

    private final Repository repository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        var apiAccessEnabled = repository.findByKey("INTECEPTOR");
        var status = apiAccessEnabled.get().getStatus();
        String requestPath = request.getRequestURI();

        if (requestPath.startsWith("/api/v1/") &&
                !(requestPath.equals("/api/v1/turn-off")) &&
                !(requestPath.equals("/api/v1/turn-on"))) {

            if (status) {
                return true; // Access allowed
            } else {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getWriter().write("API access is not allowed.");
                return false;
            }
        }

        // For other paths, continue processing the request
        return true;
    }

}
