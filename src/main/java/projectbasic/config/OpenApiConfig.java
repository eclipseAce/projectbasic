package projectbasic.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@OpenAPIDefinition(info = @Info(title = "SourceFX"))
@SecurityScheme(
        name = "user",
        type = SecuritySchemeType.HTTP,
        scheme = "Bearer",
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        bearerFormat = "accessToken"
)
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi defaultApiGroup() {
        return GroupedOpenApi.builder()
                .group("default")
                .displayName("Default APIs")
                .pathsToMatch("/api/**")
                .addOperationCustomizer((operation, handlerMethod) -> {
                    operation.setSecurity(Collections.singletonList(new SecurityRequirement().addList("user")));
                    return operation;
                })
                .build();
    }

    @Bean
    public GroupedOpenApi publicApiGroup() {
        return GroupedOpenApi.builder()
                .group("public")
                .displayName("Public APIs")
                .pathsToMatch("/api/public/**")
                .build();
    }
}
