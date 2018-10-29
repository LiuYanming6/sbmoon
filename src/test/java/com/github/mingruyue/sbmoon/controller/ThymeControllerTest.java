package com.github.mingruyue.sbmoon.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
1. 相比HelloControllerTest,这里为什么使用MockMvc呢：
使用MockMvc可以避免了开启服务器的开销，同时效果相同
the full Spring application context is started, but without the server
2. @WebMvcTest
只是初始化web层而不是整个上下文
3. 继续减小开销， 下面可以指定实例化对象，默认是所有
@WebMvcTest(HomeController.class)
推荐做法，不受其它测试失败的影响
 */
@RunWith(SpringRunner.class)
/* 演示 1
@SpringBootTest
@AutoConfigureMockMvc
*/
//演示 3，比 1 快多了
@WebMvcTest(ThymeController.class)
public class ThymeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        this.mockMvc.perform(get("/thyme/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("刘艳明")));
    }
}