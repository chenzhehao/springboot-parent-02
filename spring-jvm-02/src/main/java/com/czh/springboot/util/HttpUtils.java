package com.czh.springboot.util;


import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;


@Slf4j
public class HttpUtils {

    public static void main(String[] args) throws Exception {
        String url = "http://localhost:8081/jvm2/ddd/test/uuid001";
//        String requestBody = "{\"name\":\"XYZ\"}";
        String requestBody = "";
        int connectionTimeout = 10000;
        int requestTimeout = 10000;
        int readTimeout = 10000;
        String response = httpCommon(url, requestBody, connectionTimeout, requestTimeout, readTimeout);
        log.info("测试1------- API Response {}", response);


        Mono<String> responseAsync = httpCommonAsync(url, requestBody, connectionTimeout, requestTimeout, readTimeout);
        responseAsync.subscribe(res -> {
            log.info("测试2------- API responseAsync {}", res);
        });

        log.info("测试3------- API responseAsync 11");
        Thread.sleep(3000);
    }

    public static String httpCommon(String url, String requestBody, int connectionTimeout, int requestTimeout, int readTimeout) throws Exception {
        HttpClient httpClient =
                HttpClient.create()
                        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectionTimeout)
                        .responseTimeout(Duration.ofMillis(requestTimeout))
                        .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(readTimeout)));

        WebClient client =
                WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient)).build();

        String response = "";
        try {
            response =
                    client
                            .method(HttpMethod.GET)
                            .uri(url)
                            .accept(MediaType.ALL)
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(requestBody)
                            .retrieve()
                            .bodyToMono(String.class)
                            .block();
        } catch (Exception ex) {
            log.error("Error while calling API ", ex);
            throw new Exception("XYZ service api error: " + ex.getMessage());
        } finally {
            log.info("API Response {}", response);
        }
        return response;
    }

    /**
     * 异步调用
     * @param url
     * @param requestBody
     * @param connectionTimeout
     * @param requestTimeout
     * @param readTimeout
     * @return
     * @throws Exception
     */
    public static  Mono<String> httpCommonAsync(String url, String requestBody, int connectionTimeout, int requestTimeout, int readTimeout) throws Exception {
        HttpClient httpClient =
                HttpClient.create()
                        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectionTimeout)
                        .responseTimeout(Duration.ofMillis(requestTimeout))
                        .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(readTimeout)));

        WebClient client =
                WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient)).build();

        Mono<String> response = null;
        try {
            response =
                    client
                            .method(HttpMethod.GET)
                            .uri(url)
                            .accept(MediaType.ALL)
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(requestBody)
                            .retrieve()
                            .bodyToMono(String.class);
        } catch (Exception ex) {
            log.error("Error while calling API ", ex);
            throw new Exception("XYZ service api error: " + ex.getMessage());
        } finally {
            log.info("API Response {}", response);
        }

        Thread.sleep(1000);

        return response;
    }

}
