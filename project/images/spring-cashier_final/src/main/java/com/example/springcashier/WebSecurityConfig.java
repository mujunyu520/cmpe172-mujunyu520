package com.example.springcashier;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public org.springframework.security.core.userdetails.UserDetailsService userDetailsService() {
        return new UserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
;


        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }




    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/login","/register","/logout").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true);


    }






//    @Bean
//    public UserDetailsService userDetailsService() {
////        String pass =  hmac_sha256(Key,Password);
////        System.out.println("pass:" + pass);
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("midterm")
//                        .password("pass")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);






}




////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http.csrf().disable()
////                .authorizeHttpRequests((requests) -> requests
////                        .antMatchers("/").authenticated()
////                )
////                .formLogin()
////                .and()
////                .logout((logout) -> logout.permitAll());
////
////        return http.build();
////    }
//    @Bean
//    public UserDetailsService userDetailsService() {
////        String pass =  hmac_sha256(Key,Password);
////        System.out.println("pass:" + pass);
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("midterm")
//                        .password("pass")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);

//    private String hmac_sha256(String secretKey, String data) {
//        try {
//            Mac mac = Mac.getInstance("HmacSHA256") ;
//            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256") ;
//            mac.init(secretKeySpec) ;
//            byte[] digest = mac.doFinal(data.getBytes()) ;
//            java.util.Base64.Encoder encoder = java.util.Base64.getEncoder() ;
//            String hash_string = encoder.encodeToString(digest) ;
//            return hash_string ;
//        } catch (InvalidKeyException e1) {
//            throw new RuntimeException("Invalid key exception while converting to HMAC SHA256") ;
//        } catch (NoSuchAlgorithmException e2) {
//            throw new RuntimeException("Java Exception Initializing HMAC Crypto Algorithm") ;
//        }
//    }
//}