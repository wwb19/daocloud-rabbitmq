package com.daocloud.demo.rabbitmqdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender2 helloSender2;
    @Autowired
    private HelloSender2 helloSender3;

    @RequestMapping("/hello")
    public void hello() {
        helloSender1.send();
    }

    /**
     * 单生产者-多消费者
     */
    @RequestMapping("/oneToMany")
    public void oneToMany() {
        for(int i=0;i<10;i++){
            helloSender2.send("hellomsg:"+i);
        }

    }


    @RequestMapping("/manyToMany")
    public void manyToMany() {
        for(int i=0;i<10;i++){
            helloSender2.send("hellomsg:"+i);
            helloSender3.send("hellomsg:"+i);
        }

    }
}
