package giovanni_565123.agrosatalert.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("AgroSat Alert API")
                        .description("API REST para monitoramento agricola via satelite - Global Solution 2026 FIAP")
                        .version("v2.0"));
    }
}
