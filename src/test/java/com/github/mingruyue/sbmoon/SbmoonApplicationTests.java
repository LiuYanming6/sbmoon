package com.github.mingruyue.sbmoon;

import com.github.mingruyue.sbmoon.controller.ThymeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbmoonApplicationTests {

    @Autowired
    private ThymeController thymeController;
    @Test
    public void contextLoads() {
        assertThat(thymeController).isNotNull();
    }

}
