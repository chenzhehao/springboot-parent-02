package com.chenzhehao.test.springbootnetty;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic", "/testUser", "/user"); // 设置一个简单的消息代理前缀
        config.setApplicationDestinationPrefixes("/nettyTest"); // 设置应用程序特定的前缀
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket")// 设置socket连接
//                .setAllowedOrigins("*")//解决跨域问题
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }
}
