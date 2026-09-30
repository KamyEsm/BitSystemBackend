package com.kamyesm.bitsystembackend.Security;

import com.kamyesm.bitsystembackend.Service.Implemention.CustomUserDetailsService;
import com.kamyesm.bitsystembackend.Service.JWTService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JWTVerificationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            // خواندن هدر
            String authHeader = request.getHeader("Authorization");

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                // ادامه مسیر بدون احراز هویت (در صورت عمومی بودن آدرس)
                filterChain.doFilter(request, response);
                return;
            }

            String token = authHeader.substring(7);

            String phoneNumber = jwtService.extractUsername(token);
            UserDetails userDetails = null;
            // بررسی لاگین بودن کاربر
            if (SecurityContextHolder.getContext().getAuthentication() == null)
                userDetailsService.loadUserByUsername(phoneNumber);
            else {
                // ادامه زنجیره فیلتر ها
                filterChain.doFilter(request, response);
                return;
            }

            // در صورت معتبر نبودن توکن قطع زنجیره و ارسال خطای ۴۰۱ مستقیم
            if (!jwtService.isTokenValid(token , userDetails) || !userDetails.isAccountNonLocked()) {
                sendUnauthorizedError(response);
                return; // صدا نزدن doFilter باعث قطع زنجیره می‌شود
            }

            Authentication authentication = new OtpAuthenticationToken(userDetails , userDetails.getAuthorities());
            // قرار دادن اطلاعات کاربر در کانتکست اسپرینگ سکوریتی
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }
        catch (Exception e) {
            sendUnauthorizedError(response);
            return;
        }

        filterChain.doFilter(request, response);
    }

    private void sendUnauthorizedError(HttpServletResponse response) throws IOException {
        // کد استتوس
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        // نوع دیتا
        response.setContentType("application/json;charset=UTF-8");
        //متن ارور
        response.getWriter().write("{\"error\": \"توکن نامعتبر یا منقضی شده است\"}");
    }
}
