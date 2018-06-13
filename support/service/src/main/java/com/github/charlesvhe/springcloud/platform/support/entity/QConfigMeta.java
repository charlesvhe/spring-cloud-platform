package com.github.charlesvhe.springcloud.platform.support.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QConfigMeta is a Querydsl query type for ConfigMeta
 */
@Generated("com.github.charlesvhe.springcloud.platform.core.querydsl.MyMetaDataSerializer")
public class QConfigMeta extends com.querydsl.sql.RelationalPathBase<ConfigMeta> {

    private static final long serialVersionUID = -276878689;

    public static final QConfigMeta qConfigMeta = new QConfigMeta("config_meta");

    public final StringPath appId = createString("appId");

    public final StringPath code = createString("code");

    public final StringPath columnName = createString("columnName");

    public final StringPath description = createString("description");

    public final DateTimePath<java.util.Date> gmtCreate = createDateTime("gmtCreate", java.util.Date.class);

    public final DateTimePath<java.util.Date> gmtModified = createDateTime("gmtModified", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath property = createString("property");

    public final NumberPath<Short> sort = createNumber("sort", Short.class);

    public final com.querydsl.sql.PrimaryKey<ConfigMeta> constraint8 = createPrimaryKey(id);

    public QConfigMeta(String variable) {
        super(ConfigMeta.class, forVariable(variable), "public", "config_meta");
        addMetadata();
    }

    public QConfigMeta(String variable, String schema, String table) {
        super(ConfigMeta.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QConfigMeta(String variable, String schema) {
        super(ConfigMeta.class, forVariable(variable), schema, "config_meta");
        addMetadata();
    }

    public QConfigMeta(Path<? extends ConfigMeta> path) {
        super(path.getType(), path.getMetadata(), "public", "config_meta");
        addMetadata();
    }

    public QConfigMeta(PathMetadata metadata) {
        super(ConfigMeta.class, metadata, "public", "config_meta");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(appId, ColumnMetadata.named("app_id").withIndex(2).ofType(Types.VARCHAR).withSize(64).notNull());
        addMetadata(code, ColumnMetadata.named("code").withIndex(3).ofType(Types.VARCHAR).withSize(64).notNull());
        addMetadata(columnName, ColumnMetadata.named("column_name").withIndex(5).ofType(Types.VARCHAR).withSize(64).notNull());
        addMetadata(description, ColumnMetadata.named("description").withIndex(6).ofType(Types.VARCHAR).withSize(128).notNull());
        addMetadata(gmtCreate, ColumnMetadata.named("gmt_create").withIndex(8).ofType(Types.TIMESTAMP).withSize(26).withDigits(6).notNull());
        addMetadata(gmtModified, ColumnMetadata.named("gmt_modified").withIndex(9).ofType(Types.TIMESTAMP).withSize(26).withDigits(6).notNull());
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(property, ColumnMetadata.named("property").withIndex(4).ofType(Types.VARCHAR).withSize(64).notNull());
        addMetadata(sort, ColumnMetadata.named("sort").withIndex(7).ofType(Types.SMALLINT).withSize(5).notNull());
    }

}

