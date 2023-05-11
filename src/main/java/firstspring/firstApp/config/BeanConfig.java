package firstspring.firstApp.config;

import firstspring.firstApp.beans.FirstBean;
import firstspring.firstApp.beans.ThirdBean;
import firstspring.firstApp.beans.ThirdBeanImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {

    @Bean
    public FirstBean firstBean(){
        return new FirstBean();
    }
    @Bean
    public FirstBean secondaryBean(){
        return new FirstBean("Beksultan",18);
    }
    @Bean
    public ThirdBean thirdBean(){
        return new ThirdBeanImpl();
    }
}
