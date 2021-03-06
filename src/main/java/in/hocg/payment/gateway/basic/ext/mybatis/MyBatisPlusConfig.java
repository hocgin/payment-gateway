package in.hocg.payment.gateway.basic.ext.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import in.hocg.payment.gateway.BootApplication;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hocgin on 2020/1/5.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Configuration
@MapperScan(basePackageClasses = BootApplication.class, annotationClass = Mapper.class)
public class MyBatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
