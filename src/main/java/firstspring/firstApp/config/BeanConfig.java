package firstspring.firstApp.config;

import firstspring.firstApp.beans.FirstBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public FirstBean firstBean(){
        return new FirstBean();
    }

    

}
