package com.example.backend;

import com.example.backend.auth.model.User;
import com.example.backend.auth.pojo.LoginForm;
import com.example.backend.auth.repository.UserRepository;
import com.example.backend.manual.pojo.ActionJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.descriptor.web.ContextHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.SQLOutput;

import static com.example.backend.manual.model.ActionExecutorName.HELPER_BOT;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void actionShouldBeDeserialized() throws Exception {
        ActionJson testAction = objectMapper.readValue("""
                {
                            "stepId": 1,
                            "step": "Что вы чувствуете5",
                            "actionExecutor": "HELPER_BOT"

                        }""", ActionJson.class);

        assertThat(testAction.getActionExecutor()).isEqualTo(HELPER_BOT);
    }

    @Test
    void passwordecodeSouldBeSimilar() throws Exception{
        String password = "1234";
        String encodePassword = passwordEncoder.encode(password);
        System.out.println(passwordEncoder.matches("1234", encodePassword));


        LoginForm testPassword = objectMapper.readValue("""
                {
                            "username": "matrena",
                            "password": "123"

                        }""", LoginForm.class);
        var userOptional = userRepository.findByUsername(testPassword.getUsername());
        var user = userOptional.orElseThrow(()-> new UsernameNotFoundException(testPassword.getUsername()));

        System.out.println(assertThat(passwordEncoder.matches(testPassword.getPassword(),user.getPassword())));


    }
    @Test
    void setUserRepository() throws Exception{
        LoginForm testPassword = objectMapper.readValue("""
                {
                            "username": "matrena",
                            "password": "123"

                        }""", LoginForm.class);
        var userOptional = userRepository.findByUsername(testPassword.getUsername());
        var user = userOptional.orElseThrow(()-> new UsernameNotFoundException(testPassword.getUsername()));
        System.out.println(user);



    }
}
