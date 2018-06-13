package com.github.charlesvhe.springcloud.platform.support.service;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class StatisticService {
//    @Autowired
//    private RestHighLevelClient restHighLevelClient;
//
//    @PostConstruct
//    public void init() throws IOException {
//        restHighLevelClient.getLowLevelClient().performRequest(HttpMethod.DELETE.name(), "/statistic");
//
//        Random random = new Random(System.currentTimeMillis());
//
//        String[][] arrD1 = {{"男", "" + random.nextInt(10)}, {"女", "" + random.nextInt(10)}};
//        String[][] arrD2 = {{"政府 职员", "" + random.nextInt(10)},
//                {"农民", "" + random.nextInt(10)},
//                {"工人", "" + random.nextInt(10)},
//                {"公司职员", "" + random.nextInt(10)},
//                {"学生", "" + random.nextInt(10)}};
//        String[][] arrD3 = {{"华东", "" + random.nextInt(10)},
//                {"华南", "" + random.nextInt(10)},
//                {"西北", "" + random.nextInt(10)},
//                {"华北", "" + random.nextInt(10)},
//                {"华中", "" + random.nextInt(10)}};
//
//        ZonedDateTime zonedDateTime = ZonedDateTime.now().withMinute(0).withSecond(0).withNano(0);
//        int hour = zonedDateTime.getHour();
//        for (String[] d1 : arrD1) {
//            for (String[] d2 : arrD2) {
//                for (String[] d3 : arrD3) {
//                    Long value = Long.valueOf(random.nextInt(10_000));
//                    for (int i = 0; i < hour; i++) {
//                        Map<String, Object> source = new HashMap<>();
//                        source.put("appId", "TEST");
//                        source.put("code", "user.register");
//                        source.put("dimension1", d1[0]);
//                        source.put("dimension2", d2[0]);
//                        source.put("dimension3", d3[0]);
//                        source.put("dimension4", "");
//                        source.put("dimension5", "");
//                        source.put("value", value);
//                        source.put("timestamp", Date.from(zonedDateTime.withHour(i).toInstant()));
//                        restHighLevelClient.index(new IndexRequest("statistic", "statistic").source(source));
//
//                        value += Long.valueOf(random.nextInt(10))
//                                * Long.parseLong(d1[1])
//                                * Long.parseLong(d2[1])
//                                * Long.parseLong(d3[1]);
//                    }
//                }
//            }
//        }
//    }
}
