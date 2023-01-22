package com.example.backend.manual;

import com.example.backend.auth.repository.UserRepository;
import com.example.backend.manual.pojo.ActionJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.backend.manual.model.ActionExecutorName.HELPER_BOT;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class Action {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    UserRepository userRepository;

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
}
