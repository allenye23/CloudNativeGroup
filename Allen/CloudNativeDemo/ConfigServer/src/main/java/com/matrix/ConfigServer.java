package com.matrix;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigServer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigServer.class).web(WebApplicationType.SERVLET).run(args);
    }

}
