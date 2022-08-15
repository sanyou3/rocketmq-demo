package com.sanyou.rocketmq.demo;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试
 *
 * @author sanyou
 * @date 2022/8/14 21:19
 */
@SpringBootTest(classes = RocketMQApplication.class)
@RunWith(SpringRunner.class)
public class RocketMQTest {

    @Autowired
    private RocketMQTemplate template;

    @Test
    public void send() throws InterruptedException {
        template.convertAndSend("sanyouTopic", "三友的java日记");
        Thread.sleep(60000);
    }

}
