package com.sanyou.rocketmq.demo;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 生产者
 *
 * @author sanyou
 * @date 2022/8/14 12:40
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        //创建一个生产者，指定生产者组为sanyouProducer
        DefaultMQProducer producer = new DefaultMQProducer("sanyouProducer");

        // 指定NameServer的地址
        producer.setNamesrvAddr("192.168.200.143:9876");
        // 第一次发送可能会超时，我设置的比较大
        producer.setSendMsgTimeout(60000);

        // 启动生产者
        producer.start();

        //创建一条消息
        // topic为 sanyouTopic
        // 消息内容为 三友的java日记
        // tags 为 TagA
        Message msg = new Message("sanyouTopic", "TagA", "三友的java日记 ".getBytes(RemotingHelper.DEFAULT_CHARSET));

        // 发送消息并得到消息的发送结果，然后打印
        SendResult sendResult = producer.send(msg);
        System.out.printf("%s%n", sendResult);

        // 关闭生产者
        producer.shutdown();
    }

}
