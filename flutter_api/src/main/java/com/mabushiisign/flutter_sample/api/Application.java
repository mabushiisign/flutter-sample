package com.mabushiisign.flutter_sample.api;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "${api.title}", version = "${api.version}", description = "${api.description}"))
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
