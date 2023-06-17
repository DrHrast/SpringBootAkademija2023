package hr.king.springbootakademija2023.config;

import com.amadeus.Amadeus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class AmadeusConfig {

    @Bean
    public Amadeus getAmadeus(){
        return Amadeus
                .builder("RuRNwWDrX0F4G3nLKVGDGEZiOPGoIlew", "jOHSRFlXPsGwDFyz")
                .build();
    }
}
