package com.github.mingruyue.sbmoon.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/*
服务器使用一个随机端口，在测试环境中避免冲突
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class HelloControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void home() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/demo/",
                String.class)).contains("home");
    }

    @Test
    public void hello() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/demo/hello",
                String.class)).contains("success");
    }
}