package com.example.backend;

import com.example.backend.manual.pojo.ActionJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.backend.manual.model.ActionExecutorName.HELPER_BOT;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

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
}
