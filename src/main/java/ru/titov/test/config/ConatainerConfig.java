package ru.titov.test.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import ru.titov.test.domain.ContainerRequest;

import java.util.LinkedList;
import java.util.List;

@Configuration
public class ConatainerConfig {
    @Bean
//    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    ContainerRequest getContainer() {
        ContainerRequest containerRequest = new ContainerRequest();
        List<String> listResults = new LinkedList<>();
        listResults.add("Ни один пользователь не зарегистрирован");
        containerRequest.setListResults(listResults);
        return containerRequest;
    }
}
