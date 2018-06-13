package com.github.charlesvhe.springcloud.platform.support.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.Cached;
import com.github.charlesvhe.springcloud.platform.core.querydsl.QuerydslUtil;
import com.github.charlesvhe.springcloud.platform.support.entity.ConfigMeta;
import com.querydsl.sql.SQLQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static com.github.charlesvhe.springcloud.platform.support.entity.QConfigMeta.qConfigMeta;

@RestController
@Transactional
public class ConfigMetaService {
    @Autowired
    private SQLQueryFactory queryFactory;

    @PostMapping("/pv/{version}/ConfigMetas")
    public Long post(@RequestBody ConfigMeta configMeta) {
        configMeta.setGmtCreate(new Date());
        configMeta.setGmtModified(new Date());

        return queryFactory.insert(qConfigMeta).populate(configMeta).executeWithKey(Long.class);
    }

    @CacheInvalidate(name="support:ConfigMeta:", key="#id")
    @DeleteMapping("/pv/{version}/ConfigMetas/{id:\\d+}")
    public long delete(@PathVariable Long id) {
        return queryFactory.delete(qConfigMeta).where(qConfigMeta.id.eq(id)).execute();
    }

    @CacheInvalidate(name="support:ConfigMeta:", key="#id")
    @PutMapping("/pv/{version}/ConfigMetas/{id:\\d+}")
    public long put(@PathVariable Long id, @RequestBody ConfigMeta configMeta) {
        return queryFactory.update(qConfigMeta).populate(configMeta).where(qConfigMeta.id.eq(id)).execute();
    }

    @GetMapping("/pb/{version}/ConfigMetas")
    public List<ConfigMeta> get(ConfigMeta configMeta) throws ReflectiveOperationException {
        return queryFactory.selectFrom(qConfigMeta).where(QuerydslUtil.buildWhere(qConfigMeta, configMeta)).fetch();
    }

    @Cached(name="support:ConfigMeta:", key="#id", expire = 3600)
    @GetMapping("/pb/{version}/ConfigMetas/{id:\\d+}")
    public ConfigMeta get(@PathVariable Long id) {
        return queryFactory.selectFrom(qConfigMeta).where(qConfigMeta.id.eq(id)).fetchOne();
    }
}
