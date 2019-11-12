package edu.udacity.java.nano;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpSession;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;



@RunWith(SpringRunner.class)
@WebMvcTest
public class WebSocketChatApplicationTest {
    MockHttpSession session = new MockHttpSession();
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void login() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

     @Test
     public void indexTest() throws Exception{
          MockHttpSession session = new MockHttpSession();

            MockHttpServletRequestBuilder builder = get("/index").session(session);
            this.mockMvc.perform(builder).andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(view().name("chat"))
                    .andExpect(model().attribute("sender", "GUEST"));

        }

}