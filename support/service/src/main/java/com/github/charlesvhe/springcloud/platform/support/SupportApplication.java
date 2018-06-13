package com.github.charlesvhe.springcloud.platform.support;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.alicp.jetcache.anno.support.SpringConfigProvider;
import com.alicp.jetcache.support.AbstractValueDecoder;
import com.alicp.jetcache.support.AbstractValueEncoder;
import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.spring.SpringConnectionProvider;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.function.Function;

@SpringBootApplication
@EnableDiscoveryClient
@EnableMethodCache(basePackages = "com.github.charlesvhe.springcloud.platform.support")
@EnableCreateCacheAnnotation
@EnableSwagger2
public class SupportApplication {
    private static final String CURRENT_VERSION = "v2";
    private static final String COMPATIBLE_VERSION = "v2,v1";

    @Bean("jsonValueEncoder")
    public AbstractValueEncoder jsonValueEncoder() {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        return JsonValueEncoder.INSTANCE;
    }

    @Bean("jsonValueDecoder")
    public AbstractValueDecoder jsonValueDecoder() {
        return JsonValueDecoder.INSTANCE;
    }

    @Bean("stringKeyConverter")
    public StringKeyConverter stringKeyConvertor() {
        return StringKeyConverter.INSTANCE;
    }

    static class JsonValueEncoder extends AbstractValueEncoder {

        public static final JsonValueEncoder INSTANCE = new JsonValueEncoder(false);

        public JsonValueEncoder(boolean useIdentityNumber) {
            super(useIdentityNumber);
        }

        @Override
        public byte[] apply(Object value) {
            return JSON.toJSONBytes(value, SerializerFeature.WriteClassName);
        }
    }

    static class JsonValueDecoder extends AbstractValueDecoder {
        public static final JsonValueDecoder INSTANCE = new JsonValueDecoder(false);

        public JsonValueDecoder(boolean useIdentityNumber) {
            super(useIdentityNumber);
        }

        @Override
        public Object doApply(byte[] buffer) {
            return JSON.parse(buffer);
        }
    }

    static class StringKeyConverter implements Function<Object, Object> {
        public static final StringKeyConverter INSTANCE = new StringKeyConverter();

        @Override
        public Object apply(Object originalKey) {
            return originalKey.toString();
        }
    }

    @Bean
    public SQLQueryFactory queryFactory(DataSource dataSource) {
        return new SQLQueryFactory(
                new com.querydsl.sql.Configuration(MySQLTemplates.builder().build()),
                new SpringConnectionProvider(dataSource));
    }

    @Bean(destroyMethod = "close")
    public RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));
    }

    @Bean
    public Docket docket(@Value("${swagger.enable:true}") boolean enableSwagger) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("服务提供者2.0")
                                .description("当前API版本" + SupportApplication.CURRENT_VERSION + " 兼容API版本" + SupportApplication.COMPATIBLE_VERSION)
                                .version(SupportApplication.CURRENT_VERSION)
                                .build())
                .select().apis(RequestHandlerSelectors.basePackage(SupportApplication.class.getPackage().getName()))
                .build().enable(enableSwagger);
    }

    public static void main(String[] args) {
        // 开启 H2database TCP服务端
        try {
            Server.createTcpServer().start();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SpringApplication.run(SupportApplication.class, args);
    }
}
