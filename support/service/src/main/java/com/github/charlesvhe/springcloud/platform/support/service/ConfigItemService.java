package com.github.charlesvhe.springcloud.platform.support.service;

import com.github.charlesvhe.springcloud.platform.core.querydsl.QuerydslUtil;
import com.github.charlesvhe.springcloud.platform.support.entity.ConfigItem;
import com.querydsl.sql.SQLQueryFactory;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.github.charlesvhe.springcloud.platform.support.entity.QConfigItem.qConfigItem;


@RestController
@Transactional
public class ConfigItemService {
    @Autowired
    private SQLQueryFactory queryFactory;

    @ApiImplicitParam()
    @PostMapping("/pv/{version}/ConfigItems")
    public long post(@RequestBody ConfigItem configItem) {
        configItem.setGmtCreate(new Date());
        configItem.setGmtModified(new Date());

        return queryFactory.insert(qConfigItem).populate(configItem).executeWithKey(Long.class);
    }

    @DeleteMapping("/pv/{version}/ConfigItems/{id:\\d+}")
    public long delete(@PathVariable Long id) {
        return queryFactory.delete(qConfigItem).where(qConfigItem.id.eq(id)).execute();
    }

    @PutMapping("/pv/{version}/ConfigItems/{id:\\d+}")
    public long put(@PathVariable Long id, @RequestBody ConfigItem configItem) {
        return queryFactory.update(qConfigItem).populate(configItem).where(qConfigItem.id.eq(id)).execute();
    }

    @GetMapping("/pb/{version}/ConfigItems")
    public List<ConfigItem> get(@RequestBody ConfigItem configItem) throws ReflectiveOperationException {
        return queryFactory.selectFrom(qConfigItem).where(QuerydslUtil.buildWhere(qConfigItem, configItem)).fetch();
    }

    @GetMapping("/pb/{version}/ConfigItems/{id:\\d+}")
    public ConfigItem get(@PathVariable Long id) {
        return queryFactory.selectFrom(qConfigItem).where(qConfigItem.id.eq(id)).fetchOne();
    }
}
