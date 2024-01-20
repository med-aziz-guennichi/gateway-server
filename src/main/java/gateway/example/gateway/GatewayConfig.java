package gateway.example.gateway;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public GlobalFilter customGlobalFilter() {
        return (exchange, chain) -> {
            // Log your request information here
            System.out.println("New request redirected to [" + exchange.getRequest().getPath() + "] at [" + java.time.LocalDateTime.now() + "]");

            // Continue the filter chain
            return chain.filter(exchange);
        };
    }
}
