package com.winter.springbootmybatisdemo;

import com.winter.service.user.impl.UserServiceImpl;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisDemoApplicationTests {

    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext

    private MockMvc mockMvc;

    @Autowired
    private UserServiceImpl userService;


    @Before // 在测试开始前初始化工作
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void contextLoads() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("address", "合肥");

        MvcResult result = mockMvc.perform(post("/save").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(map)))
                .andExpect(status().isOk())// 模拟向testRest发送get请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
                .andReturn();// 返回执行请求的结果

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void getAllUser() throws Exception {
        MvcResult result = mockMvc.perform(post("/user/getAll").contentType("application/json;charset=UTF-8")).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }




}
