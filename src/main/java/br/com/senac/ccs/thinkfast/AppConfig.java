package br.com.senac.ccs.thinkfast;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan( basePackages = { "br.com.senac.ccs.thinkfast" } )
public class AppConfig extends WebMvcConfigurationSupport {

}