package com.sanyou.rocketmq.demo;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 监听rocketmq主题的消息
 *
 * @author sanyou
 * @date 2022/8/14 19:29
 */
@Component
@RocketMQMessageListener(consumerGroup = "sanyouConsumer", topic = "sanyouTopic")
public class SanYouTopicListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String msg) {
        System.out.println("处理消息:" + msg);
    }

}
