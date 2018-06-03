package cn.iwangwei.support;

import com.xkw.mdm.api.DefaultApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MdmConfiguration {

    @Bean
    public DefaultApi defaultApi() {
        return new DefaultApi("http://api.xkw.com/master/v1", "qbm", "JyBGJLng_TMyCwwj2WY4B?Klvj8#!i89");
    }
}
