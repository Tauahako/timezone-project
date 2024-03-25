package com.tahitinumerique.tz.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplicationPostLaunchListener implements ApplicationListener<WebServerInitializedEvent> {

    @Value("${spring.h2.console.enabled}")
    private boolean h2consoleActive;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        var port = event.getWebServer().getPort();
        log.info("REST interface at http://localhost:" + port);
        log.info("SwaggerUI interface at http://localhost:" + port + "/swagger-ui/index.html");
        if (h2consoleActive) {
            log.info("h2 interface at http://localhost:" + port + "/h2-console");
        }

    }
}
