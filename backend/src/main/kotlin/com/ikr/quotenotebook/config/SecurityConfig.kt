package com.ikr.quotenotebook.config

import com.ikr.quotenotebook.security.FirebaseTokenFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class SecurityConfig(
    private val firebaseTokenFilter: FirebaseTokenFilter
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            //.csrf(Customizer.withDefaults())
            .csrf { it.disable() } //✅ TEMP: Remove alter on, this allows all POST without Auth
            .sessionManagement { session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/h2-console/**").permitAll()  // Allow H2 console without auth
                    .requestMatchers("/api/v1/auth/**").permitAll()
                    .requestMatchers("/api/**").permitAll()  // ✅ TEMP: allow all for now
                    .anyRequest().authenticated()
            }
            //.csrf { csrf -> csrf.ignoringRequestMatchers("/h2-console/**") } // Disable CSRF for H2 console
            .headers { headers -> headers.frameOptions { it.disable() } }   // Allow frames for H2 console
            .addFilterBefore(firebaseTokenFilter, UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }
}