package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

//스프링 시큐리티의 전체 동작 규칙 선언
@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(frame -> frame.disable())//H2-console에 쓰려고 있는 코드라고 함.
                )
                .authorizeHttpRequests(auth -> auth.requestMatchers(
                        "/",
                        "/css/**",
                        "/images/**",
                        "/js/**",
                        "/h2-console/**"
                ).permitAll()//위에 있는 url들은 무조건 허용한다.
                        .requestMatchers("/api/v1/**")
                        .hasRole(Role.USER.name())// /api/v1/**의 주소들은 모두 USER라는 권한이 있어야 허용한다.
                        .anyRequest().authenticated()//위에서 걸리지 않은 모든 요청은 로그인만 하면 허용
                )
                .logout(logout -> logout.logoutSuccessUrl("/")//로그아웃 뒤 해당 주소로 이동.
                )
                .oauth2Login(oauth2 -> oauth2.userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService)
                )//로그인 시 우리가 커스텀한 서비스를 넣어서 이동
                );
        return http.build();
    }

}
