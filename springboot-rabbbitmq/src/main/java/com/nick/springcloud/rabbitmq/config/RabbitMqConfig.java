package com.nick.springcloud.rabbitmq.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {

    /**
     * 配置direct类型的交换机
     * @return
     */
    @Bean
    public DirectExchange directExchange () {
        return new DirectExchange("bootDirectExchange");
    }

    /**
     * 配置队列
     * @return
     */
    @Bean
    public Queue directQueue () {
        return new Queue("bootDirectQueue");
    }

    /**
     * 绑定队列和交换机
     * @param directQueue 参数名和某个方法名相同，springboot会进行自动注入
     * @param directExchange 参数名和某个方法名相同，springboot会进行自动注入
     *
     */
    @Bean
    public Binding directBinding(Queue directQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue)
                .to(directExchange)
                .with("bootDirectRoutingKey");
    }


}
