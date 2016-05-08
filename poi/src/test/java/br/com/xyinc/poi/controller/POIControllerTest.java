package br.com.xyinc.poi.controller;

/**
 * Created by alisson on 5/5/16.
 */

import br.com.xyinc.poi.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@TestPropertySource(locations = "classpath:test.properties")
@WebAppConfiguration
public class POIControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void listAll() throws Exception {
        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andReturn();

    }

    @Test
    public void add() throws Exception {
        mockMvc.perform(get("/add?name=Loja1&x=100&y=100"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andReturn();
    }

    @Test
    public void addError() throws Exception {
        mockMvc.perform(get("/add?name=Loja1&x=100&y=-100"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(contentType))
                .andReturn();
    }

    @Test
    public void getByReference() throws Exception {
        mockMvc.perform(get("/reference?x=20&y=10&d=10"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andReturn();
    }

    @Test
    public void getByReferenceError() throws Exception {
        mockMvc.perform(get("/reference?x=20&y=10&d=-10"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(contentType))
                .andReturn();
    }

}
